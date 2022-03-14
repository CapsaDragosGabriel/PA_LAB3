import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    //… constructors, getters,
    private final int INFINITY=Integer.MAX_VALUE;
    public void addNode(Node node) {
    int iterator=0;
    boolean alreadyExists=false;
    for(iterator=0;iterator<nodes.size();iterator++)
        if (nodes.get(iterator) ==node)
        {
            alreadyExists=true;
            System.out.println("There is already a node with this name:"+node.getName());
        }
    if (alreadyExists==false)
    {
        nodes.add(node);
    }
    }
    public void sortNodes()
    {
        nodes.sort(Node::compareTo);
    }
    @Override
    public String toString()
    {

        return "Network{\n" +
                "nodes=" + nodes +

                "}\n";
    }

    public void printConnections()
    {for (int index=0;index<nodes.size();index++)
        {System.out.println(nodes.get(index).getConnectionCosts());
            System.out.println();
        }
    }
    public int getIndexOfMinNode(boolean visited[],int minPath[]) {
        int min = INFINITY;
        int minIndex = -1;
        for (int index = 0; index < nodes.size(); index++)
            if (!visited[index])
                if (minPath[index] < min)
                {min = minPath[index];
                minIndex=index;
                }

        return minIndex;
    }
    public void printShortestPaths(int startingIndex)
    {

        int minPath[]=new int[nodes.size()];
        boolean visited[]=new boolean[nodes.size()];
        for (int index=0;index<nodes.size();index++)
        {
            minPath[index]=INFINITY;
            visited[index]=false;
        }
        Node startNode=nodes.get(startingIndex);
        minPath[startingIndex]=0;
        visited[startingIndex]=true;

        for (Node node : startNode.getConnectionCosts().keySet())
        {
            int currIndex=nodes.indexOf(node);

            minPath[currIndex]=startNode.getConnectionCosts().get(node);

        }
        for (int index=1;index<nodes.size();index++)
        {
            int currIndex=getIndexOfMinNode(visited,minPath);
            visited[currIndex]=true;
            Node currNode=nodes.get(currIndex);
            for (Node node : currNode.getConnectionCosts().keySet())
            {
                int currIndex2=nodes.indexOf(node);
                if (!visited[currIndex2])
                    if (minPath[currIndex]+currNode.getConnectionCosts().get(node)<minPath[currIndex2])
                    {
                        minPath[currIndex2]=minPath[currIndex]+currNode.getConnectionCosts().get(node);
                    }
            }
        }

        nodes.stream().forEach(node -> System.out.println((node.getName() + " ")));
      //  System.out.println(nodes);
        System.out.println("Starting node is "+startNode.getName()+" the costs of paths are: ");
        for (int index=0;index<nodes.size();index++)
        {
            System.out.print(nodes.get(index).getName()+" ");
            System.out.print(minPath[index]+"\n");
        }

    }




    public void printIdentifiable()
    { List<Node> identifiables = new ArrayList<>();
        for (int index=0;index<nodes.size();index++)
        {
            if(nodes.get(index) instanceof Identifiable)
            identifiables.add(nodes.get(index));
        }
        identifiables.sort(new Comparator<Node>() {
                               @Override
                               public int compare(Node o1, Node o2) {
                                   if(((Identifiable)o1).getIpAddress().compareTo(((Identifiable)o2).getIpAddress())<0)
                                       return -1;
                                   if(((Identifiable)o1).getIpAddress().compareTo(((Identifiable)o2).getIpAddress())==0)
                                       return 0;
                                   return 1;
                               }
                           }
        );

        for (int index=0;index<identifiables.size();index++)
        {
            System.out.println(identifiables.get(index));
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Network)) return false;
        Network network = (Network) o;
        return Objects.equals(nodes, network.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }

    //… toString, etc.
}