import java.util.ArrayList;
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
    {for (int i=0;i<nodes.size();i++)
        {System.out.println(nodes.get(i).getConnectionCosts());
            System.out.println();
        }
    }
    public void printIdentifiable()
    {for (int i=0;i<nodes.size();i++)
    {if(nodes.get(i) instanceof Identifiable)
        System.out.println(nodes.get(i));
        System.out.println();
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