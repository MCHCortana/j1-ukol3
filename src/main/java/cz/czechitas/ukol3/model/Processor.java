package cz.czechitas.ukol3.model;

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
        return "Processor{" +
                "producer='" + producer + '\'' +
                ", speed=" + speed +
                '}';
    }
}
