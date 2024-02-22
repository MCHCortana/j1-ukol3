package cz.czechitas.ukol3.model;

public class Processor {
    private String CPUproducer;
    private long CPUspeed; //in Hz

    public String getCPUproducer() {
        return CPUproducer;
    }

    public void setCPUproducer(String CPUproducer) {
        this.CPUproducer = CPUproducer;
    }

    public long getCPUspeed() {
        return CPUspeed;
    }

    public void setCPUspeed(long CPUspeed) {
        this.CPUspeed = CPUspeed;
    }
}
