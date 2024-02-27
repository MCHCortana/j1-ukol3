package cz.czechitas.ukol3.model;

import java.util.Locale;

public class Memory {
    private long capacity;

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Computer memory capacity is: " + String.format(Locale.of("CS", "cz"), "%,d", capacity);
    }
}
