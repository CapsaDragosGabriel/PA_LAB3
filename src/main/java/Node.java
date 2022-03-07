import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Node {
    protected String name;
    protected Location mapLocation;
    protected String macAddress;
    Map<Node,Integer> connectionCosts;
    //… constructors, getters, setters
    public Node(String name,  Location mapLocation, String macAddress) {
        this.name = name;
        this.macAddress = macAddress;
        this.mapLocation = mapLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(Location mapLocation) {
        this.mapLocation = mapLocation;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Map<Node, Integer> getConnectionCosts() {
        return connectionCosts;
    }

    public void setConnectionCosts(Map<Node, Integer> connectionCosts) {
        this.connectionCosts = connectionCosts;
    }
    public void addConnection(Node node, int timeCost) {
        if (timeCost < 0) System.out.println("Time cost cannot be negative");
        else
            connectionCosts.put(node, timeCost);
    }
    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", mapLocation=" + mapLocation +
                ", macAddress='" + macAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(getName(), node.getName()) && Objects.equals(getMapLocation(), node.getMapLocation()) && Objects.equals(getMacAddress(), node.getMacAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMapLocation(), getMacAddress());
    }

}