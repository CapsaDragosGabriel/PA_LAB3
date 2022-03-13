import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    //… constructors, getters,

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
    public void printShortestPaths()
    {
        for (int index=0;index<nodes.size();index++)
        {
            if(nodes.get(index) instanceof Identifiable)
            {
                int V=nodes.size();
                int dist[] = new int[V];
                Boolean sptSet[] = new Boolean[V];
                
                for (int iterator = 0; iterator < V; iterator++) {
                    dist[iterator] = Integer.MAX_VALUE;
                    sptSet[iterator] = false;
                }
                dist[index] = 0;
                for (int count = 0; count < V - 1; count++) {
                    // Pick the minimum distance vertex from the set of vertices
                    // not yet processed. u is always equal to src in first
                    // iteration.
                    int u = Dijkstra.minDistance(dist, sptSet,V);

                    // Mark the picked vertex as processed
                    sptSet[u] = true;

                    // Update dist value of the adjacent vertices of the
                    // picked vertex.
                    for (int v = 0; v < V; v++)

                        // Update dist[v] only if is not in sptSet, there is an
                        // edge from u to v, and total weight of path from src to
                        // v through u is smaller than current value of dist[v]
                        if (!sptSet[v] && graph[u][v] != 0 &&
                                dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                            dist[v] = dist[u] + graph[u][v];
                }





            }

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