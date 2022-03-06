import java.util.Objects;

public class Computer extends Node implements Identifiable, Storage {

    private String ipAddress;
    private double storageCapacity;

    public Computer(String name, String macAddress, Location mapLocation, String ipAddress, double storageCapacity) {
        super(name, macAddress, mapLocation);
        this.ipAddress = ipAddress;
        this.storageCapacity = storageCapacity;
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
    public double getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public void setStorageCapacity(double cap) {
        this.storageCapacity = cap;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", storageCapacity=" + storageCapacity +
                ", ipAddress='" + ipAddress + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", mapLocation='" + mapLocation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Computer computer = (Computer) o;
        return Double.compare(computer.storageCapacity, storageCapacity) == 0 && Objects.equals(ipAddress, computer.ipAddress);
    }


}




