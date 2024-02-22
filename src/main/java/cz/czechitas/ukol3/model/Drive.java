package cz.czechitas.ukol3.model;

public class Drive {
    private long driveCapacity; // in bites
    private long usedSpace; // in bites

    public long getDriveCapacity() {
        return driveCapacity;
    }

    public void setDriveCapacity(long driveCapacity) {
        this.driveCapacity = driveCapacity;
    }

    public long getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(long usedSpace) {
        this.usedSpace = usedSpace;
    }

    public String toString(){ return "Budu něco dělat. ";};
}
