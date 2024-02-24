package cz.czechitas.ukol3.model;

import java.util.Locale;
import java.util.Objects;

public class Computer {
    public boolean isOn;
    public Processor processor;
    public Memory memory;
    public Drive drive;

    public void turnOn(Processor processor, Memory memory, Drive drive, Drive secondaryDrive) {
        processorCheck(processor);
        memoryCheck(memory);
        driveCheck(drive);
        driveCheck(secondaryDrive);

        if (isOn) {
            System.err.println("Computer is already ON.");
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

    public void computerState(int paragraph, Processor processor, Memory memory, Drive drive, Drive secondaryDrive) {
        if (isOn) {
            System.out.println(paragraph);
            System.out.println("Your Computer is ON");
            computerHardwareInfo(processor, memory, drive, secondaryDrive);
        } else {
            System.out.println("Your computer is OFF");
        }
    }

    ;

    public void computerHardwareInfo(Processor processor, Memory memory, Drive drive, Drive secondaryDrive) {
        System.out.println("System information:");
        System.out.println("Processor  information: ");
        System.out.println("CPU producer: " + processor.getCPUproducer());
        System.out.println("CPU speed: " + String.format(Locale.of("CS", "cz"), "%,d", processor.getCPUspeed()) + " Hz");
        System.out.println(" ");
        System.out.println("Memory  information: ");
        System.out.println("RAM capacity: " + String.format(Locale.of("CS", "cz"), "%,d", memory.getMemoryCapacity()) + " bytes");
        System.out.println(" ");
        System.out.println("Drive: " + drive.getDriveName());
        System.out.println("Drive capacity: " + String.format(Locale.of("CS", "cz"), "%,d", drive.getDriveCapacity()) + " bytes");
        System.out.println("Used space: " + String.format(Locale.of("CS", "cz"), "%,d", drive.getUsedSpace()) + " bytes");
        System.out.println(" ");
        System.out.println("Drive: " + secondaryDrive.getDriveName());
        System.out.println("Secondary drive capacity: " + String.format(Locale.of("CS", "cz"), "%,d", secondaryDrive.getDriveCapacity()) + " bytes");
        System.out.println("Used space: " + String.format(Locale.of("CS", "cz"), "%,d", secondaryDrive.getUsedSpace()) + " bytes");
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

    public void createFile(Drive drive, Drive secondaryDrive, long fileSize) {
        if (isOn) {
            int driveFileFit = checkFileSize(true, drive, fileSize);
            if (driveFileFit == 2) {
                int driveFileFitSecondary = checkFileSize(true, secondaryDrive, fileSize);
                if (driveFileFitSecondary == 2) {
                    throw new IllegalStateException("ERROR! The file you are trying to create is bigger than both drives' individual capacity.");
                } else if (driveFileFitSecondary == 0) {
                    drive.setUsedSpace(secondaryDrive.getDriveCapacity());

                    System.out.println("WARNING! The file you are creating has depleted the second drive's capacity. Delete files using method drive.deleteFile(), or extend your drive capacity.");
                    System.out.println("File was created on secondary drive.");
                    System.out.println("WARNING! Both drives are full.");
                } else {
                    long newSecondaryDriveUsedSpace = secondaryDrive.getUsedSpace() + fileSize;
                    secondaryDrive.setUsedSpace(newSecondaryDriveUsedSpace);
                    System.out.println("File was created on secondary drive.");
                    System.out.println("New USED secondary drive space is: " + newSecondaryDriveUsedSpace + "bytes");
                }
            } else if (driveFileFit == 0) {
                drive.setUsedSpace(drive.getDriveCapacity());
                System.out.println("WARNING! The file you are creating has depleted the primary drive's capacity. Delete files using method drive.deleteFile(), or extend your drive capacity.");
                System.out.println("File was created on primary drive.");
                System.out.println("WARNING!  Primary drive is full.");
            } else {
                long newPrimaryDriveUsedSpace = drive.getUsedSpace() + fileSize;
                drive.setUsedSpace(newPrimaryDriveUsedSpace);
                System.out.println("File was created on primary drive.");
                System.out.println("New USED primary drive space is: " + newPrimaryDriveUsedSpace + "bytes");
            }
            ;

        } else {
            throw new IllegalStateException("You cannot be creating files while the computer is OFF. Turn on your computer!");
        }
    }

    ;

    public void deleteFile(Drive drive, Drive secondaryDrive, long fileSize) {
        if (isOn) {
            int driveFileFit = checkFileSize(false, drive, fileSize);
            if (driveFileFit == 2) { //case when the file is bigger than primary drive capacity
                int driveFitSecondary = checkFileSize(false, secondaryDrive, fileSize);
                if (driveFitSecondary == 2) { // case when the file is too big to delete even from the secondary drive
                    throw new IllegalStateException("ERROR! NON existent file! The file you are trying to delete is bigger than both drives' individual used space.");
                } else if (driveFitSecondary == 0) { // case when the file cannot be on drive as it is bigger than the used space, but is just big enough to be found on the secondary drive.
                    secondaryDrive.setUsedSpace(0);
                    System.out.println("File was deleted from secondary drive. ");
                    System.out.println("HURRAY! Your secondary drive is as new, completely empty. Have fun creating new files here");
                } else {
                    long newSecondaryDriveUsedSpace = secondaryDrive.getUsedSpace() - fileSize;
                    secondaryDrive.setUsedSpace(newSecondaryDriveUsedSpace);
                    System.out.println("File was deleted from secondary drive. ");
                    System.out.println(("New USED space on drive is: ") + newSecondaryDriveUsedSpace + "bytes");
                }
                ; //this covers all the possibilities when the file is too big for the first drive
            } else if (driveFileFit == 0) {
                drive.setUsedSpace(0);
                System.out.println("File was deleted from primary drive. ");
                System.out.println("HURRAY! Your primary drive is as new, completely empty. Have fun creating new files.");
            } else {
                long newPrimaryDriveUsedSpace = drive.getUsedSpace() - fileSize;
                drive.setUsedSpace(newPrimaryDriveUsedSpace);
                System.out.println("File was deleted from primary drive.");
                System.out.println("New USED primary drive space is: " + newPrimaryDriveUsedSpace + "bytes");
            }
        } else {
            throw new IllegalStateException("You cannot be creating files while the computer is OFF. Turn on your computer!");
        }
    }

    ;

    public int checkFileSize(boolean creating, Drive drive, long fileSize) {
        long driveFileFit;
        if (creating) {
            driveFileFit = drive.getDriveCapacity() - (drive.getUsedSpace() + fileSize);
        } else {
            driveFileFit = drive.getUsedSpace() - fileSize;
        }
        if (driveFileFit < 0) {
            return 2;
        } else if (driveFileFit == 0) {
            return 0;
        }
        return 1;
    }

    ;

}

;



