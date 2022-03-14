interface Storage {
     double getStorageCapacity() ;
     void setStorageCapacity(double cap);
     default double getSizeUnit(UnitTypes unit){ //punctul2
          System.out.println("Capacity not initialized.");
          return -1;
     };
}
