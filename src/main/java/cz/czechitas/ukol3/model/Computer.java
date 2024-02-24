package cz.czechitas.ukol3.model;

import java.util.Locale;
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
        System.out.println("Computer turned ON.");
    }

    ;

    public void turnOff() {
        if (!isOn) {
            return;
        } else {
            this.isOn = false;
            System.out.println("Turned OFF");
        }
        ;
    }

    ;

    public void computerState(Processor processor, Memory memory, Drive drive) {
        if (isOn) {
            System.out.println("Your Computer is ON");
            computerHardwareInfo(processor, memory, drive);
        } else {
            System.out.println("Your computer is OFF");
        }
    }

    ;

    public void computerHardwareInfo(Processor processor, Memory memory, Drive drive) {
        System.out.println("System information:");
        System.out.println("Processor  information: ");
        System.out.println("CPU producer: " + processor.getCPUproducer());
        System.out.println("CPU speed: " + String.format(Locale.of("CS", "cz"), "%,d", processor.getCPUspeed()));
        System.out.println(" ");
        System.out.println("Memory  information: ");
        System.out.println("RAM capacity: " + String.format(Locale.of("CS", "cz"), "%,d", memory.getMemoryCapacity()));
        System.out.println(" ");
        System.out.println("Drive capacity: " + String.format(Locale.of("CS", "cz"), "%,d", drive.getDriveCapacity()) + " bytes");
        System.out.println("Used space: " + String.format(Locale.of("CS", "cz"), "%,d", drive.getUsedSpace()) + " bytes");
        System.out.println(" ");
    }

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

    public void createFile(Drive drive, long fileSize) {
        long newUsedDrive = drive.getUsedSpace() + fileSize;
        if (newUsedDrive > drive.getDriveCapacity()) {
            throw new IllegalStateException("ERROR! The file you are trying to create is bigger than drive capacity.");
        } else if (newUsedDrive == drive.getDriveCapacity()) {
            System.out.println("WARNING! The file you are creating has depleted the drive's capacity. Delete files using method drive.deleteFile(), or extend your drive capacity.");
        }
        ;
        drive.setUsedSpace(newUsedDrive);
        System.out.println("File was created. ");
        System.out.println(("New used space on drive is: ") + newUsedDrive);
    }

    ;

    public void deleteFile(Drive drive, long fileSize) {
        long newUsedDrive = drive.getUsedSpace() - fileSize;
        if (newUsedDrive < 0) {
            throw new IllegalStateException("ERROR! The file you are trying to delete is most likely non existent as it is too big.");
        } else if (newUsedDrive == drive.getDriveCapacity()) {
            System.out.println("HURRAY! Your drive is as new, completely empty. Time to create some files.");
        }
        ;
        drive.setUsedSpace(newUsedDrive);
        System.out.println("File was deleted. ");
        System.out.println(("New used space on drive is: ") + newUsedDrive);
    }

    ;

};



