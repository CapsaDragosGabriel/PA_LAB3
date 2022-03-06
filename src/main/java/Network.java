import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    //… constructors, getters,

    public void addNode(Node node) {
        nodes.add(node);
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