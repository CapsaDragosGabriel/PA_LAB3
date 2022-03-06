public class Switch extends Node {
    public Switch(String name, Location mapLocation, String macAddress) {
        super(name, mapLocation, macAddress);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "name='" + name + '\'' +
                ", mapLocation=" + mapLocation +
                ", macAddress='" + macAddress + '\'' +
                "}\n";
    }

}
