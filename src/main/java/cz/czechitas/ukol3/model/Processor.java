package cz.czechitas.ukol3.model;

import java.util.Locale;

public class Processor {
    private String producer;
    private long speed;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Here are the CPU parameters:" + "\n" +
                "CPU producer: " + getProducer() + "\n" +
                "CPU speed in Hz: " + String.format(Locale.of("CS", "cz"), "%,d", getSpeed());
    }
}
