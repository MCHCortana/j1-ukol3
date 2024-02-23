package cz.czechitas.ukol3.model;

import java.util.Locale;

public class Memory {
    private long memoryCapacity; // in bytes

    public void setMemoryCapacity(long memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public long getMemoryCapacity() {
        if (memoryCapacity == 0){
            throw new IllegalStateException(("Sorry you need to set RAM capacity. "));
        }
        return memoryCapacity;
    }

    public void RAMstate() {

        System.out.println("Computer memory capacity is: " + String.format(Locale.of("CS", "cz"), "%,d", getMemoryCapacity()));
    }
}
