package cz.czechitas.ukol3.model;

import java.util.Objects;

public class Computer {
    public boolean isOn;
    public Processor processor;
    public Memory memory;
    public Drive drive;


    public void turnOn(Processor processor, Memory memory, Drive drive) {
        processorCheck(processor);
        memoryCheck(memory);
        driveCheck(drive);
        if (isOn) {
            System.err.println("Počítač je již zapnutý.");
            return;
        }
        this.isOn = true;
        System.out.println("Počítač se zapnul.");
    }

    ;

    public void turnOff() {
        if (!isOn) {
            return;
        } else {
            this.isOn = false;
            System.out.println("Počítač se vypnul");
        }
        ;
    }

    ;

    public String computerState() {
        if (isOn) {
            return "Počítač je zapnutý";
        } else {
            return "Počítač je vypnutý";
        }
    }

    ;

    public void processorCheck(Processor processor) {
        Objects.requireNonNull(processor);
        processor.getCPUproducer();
        processor.getCPUspeed();
    }

    ;

    public void memoryCheck(Memory memory) {
        Objects.requireNonNull(memory);
        memory.getMemoryCapacity();
    }

    ;

    public void driveCheck(Drive drive) {
        Objects.requireNonNull(drive);
        drive.getDriveCapacity();
        drive.getUsedSpace();
    }
};



