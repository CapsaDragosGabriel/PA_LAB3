import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    //… constructors, getters,
    private final int INF=Integer.MAX_VALUE;
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
    public int getClosestNodeIndex(boolean visited[],int minRoute[]) {
        int min = INF;
        int minIndex = -99;
        for (int index = 0; index < nodes.size(); index++)
            if (!visited[index])
                if (minRoute[index] < min)
                {min = minRoute[index];
                minIndex=index;
                }

        return minIndex;
    }
    public void printShortestPaths(int startIndex)
    {

        int minRoute[]=new int[nodes.size()];
        boolean visited[]=new boolean[nodes.size()];
        for (int index=0;index<nodes.size();index++)
        {
            minRoute[index]=INF;
            visited[index]=false;
        }
        Node startNode=nodes.get(startIndex);
        minRoute[startIndex]=0;
        visited[startIndex]=true;

        for (Node node : startNode.getConnectionCosts().keySet())//vad cu ce noduri am conexiune
        {
            int currIndex=nodes.indexOf(node);

            minRoute[currIndex]=startNode.getConnectionCosts().get(node);

        }
        for (int index=1;index<nodes.size();index++)
        {
            int currIndex=getClosestNodeIndex(visited,minRoute);//gasesc cel mai apropiat nod
            visited[currIndex]=true;//si il vizitez

            Node currNode=nodes.get(currIndex);
            for (Node node : currNode.getConnectionCosts().keySet())//merg prin conexiunile acestuia
            {
                int currIndex2=nodes.indexOf(node);
                if (!visited[currIndex2])//daca gasesc un nod pe care nu l-am vizitat si aflu o cale mai scurta
                    if (minRoute[currIndex]+currNode.getConnectionCosts().get(node)<minRoute[currIndex2])
                    {
                        minRoute[currIndex2]=minRoute[currIndex]+currNode.getConnectionCosts().get(node);
                    }
            }
        }
        System.out.println("Starting node is "+startNode.getName()+". The shortest routes are: ");
     for (int index=0;index<nodes.size();index++)
        {
            if(nodes.get(index) instanceof Identifiable){
            System.out.print("To "+nodes.get(index).getName()+" ");
            System.out.print(minRoute[index]+"\n");}
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