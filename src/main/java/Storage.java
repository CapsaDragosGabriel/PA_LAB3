interface Storage {
     double getStorageCapacity() ;
     void setStorageCapacity(double cap);
     default double getSizeUnit(UnitTypes unit){
          System.out.println("Capacity not initialized.");
          return -1;
     };
}
