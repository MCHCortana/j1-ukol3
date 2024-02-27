package cz.czechitas.ukol3.model;


import java.util.Locale;

public class Drive {
    private long capacity;
    private long usedSpace;


    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getUsedSpace() {

        return usedSpace;
    }

    public void setUsedSpace(long usedSpace) {
        this.usedSpace = usedSpace;
    }

    @Override
    public String toString() {
        return ("Here are the drive parameters:" + "\n"
                + "Drive capacity: " + String.format(Locale.of("CS", "cz"), "%,d", getCapacity()) + " bytes" + "\n" +
                "Used space: " + String.format(Locale.of("CS", "cz"), "%,d", getUsedSpace()) + " bytes");
    }
}
