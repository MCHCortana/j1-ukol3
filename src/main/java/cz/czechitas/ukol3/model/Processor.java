package cz.czechitas.ukol3.model;

import java.util.Locale;
import java.util.Objects;

public class Processor {
    private String CPUproducer;
    private long CPUspeed; //in Hz

    public String getCPUproducer() {
        Objects.requireNonNull(CPUproducer, "Sorry, set the processor producer first!");
        return CPUproducer;
    }

    public void setCPUproducer(String CPUproducer) {
        this.CPUproducer = CPUproducer;
    }

    public long getCPUspeed() {
        if (CPUspeed == 0) {
            throw new IllegalStateException("CPU speed cannot be 0.");
        }
        return CPUspeed;
    }

    public void setCPUspeed(long CPUspeed) {
        this.CPUspeed = CPUspeed;
    }

    public void CPUstate() {
        System.out.println("Here are the CPU parameters:");
        System.out.println("CPU producer: " + getCPUproducer());
        System.out.println("CPU speed in Hz: " + String.format(Locale.of("CS", "cz"), "%,d",getCPUspeed()));
    }
}
