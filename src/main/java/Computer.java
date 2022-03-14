import java.util.Objects;

public class Computer extends Node implements Identifiable, Storage {

    private String ipAddress;
    private double storageCapacity;

    public Computer(String name, String macAddress, Location mapLocation, String ipAddress, double storageCapacity) {
        super(name, mapLocation,macAddress);
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
                ", name='" + name + '\'' +
                ", mapLocation=" + mapLocation +
                ", macAddress='" + macAddress + '\'' +
                "ipAddress='" + ipAddress + '\'' +
                ", storageCapacity=" + storageCapacity +
                "}\n";
    }

    @Override
    public double getSizeUnit(UnitTypes type) {//punctul2
        double storageCap=this.storageCapacity;
        switch (type)
        {
            case TB:
                storageCap/=1000;
            case GB:
                break;
            case MB:
                storageCap*=1000;
                break;
            case KB:
                storageCap*=1000000;
                break;
            case B:
                storageCap*=1000000000;
                break;

        }
        return storageCap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        if (!super.equals(o)) return false;
        Computer computer = (Computer) o;
        return Double.compare(computer.getStorageCapacity(), getStorageCapacity()) == 0 && getIpAddress().equals(computer.getIpAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIpAddress(), getStorageCapacity());
    }
}




