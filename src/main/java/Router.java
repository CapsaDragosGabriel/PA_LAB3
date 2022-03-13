import java.util.Objects;

public class Router extends Node implements Identifiable {
    public String ipAddress;

    public Router(String name, String macAddress, Location mapLocation,String ipAddress) {
        super(name,mapLocation,macAddress);
        this.ipAddress = ipAddress;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + name + '\'' +
                ", mapLocation=" + mapLocation +
                ", macAddress='" + macAddress + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Router)) return false;
        if (!super.equals(o)) return false;
        Router router = (Router) o;
        return getIpAddress().equals(router.getIpAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIpAddress());
    }
}
