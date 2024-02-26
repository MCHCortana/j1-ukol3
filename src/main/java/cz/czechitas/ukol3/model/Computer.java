package cz.czechitas.ukol3.model;

public class Computer {
    private boolean isOn;
    private Processor processor;
    private Memory memory;
    private Drive drive;

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public void turnOn() {
        if (processor == null || memory == null || drive == null) {
            System.out.println("ERROR! Missing CPU, RAM, or Drive");
            return;
        }
        if (isOn) {
            System.out.println("ERROR! Computer is already ON.");
            return;
        }
        isOn = true;
        System.out.println("Computer turned ON.");
    }

    public void turnOff() {
        if (!isOn) {
            return;
        }
        isOn = false;
        System.out.println("Computer turned OFF");
    }

    public boolean isON() {
        return isOn;
    }

    public void createFile(Drive drive, Drive secondaryDrive, long fileSize) {
        if (isOn) {
            int driveFileFit = checkFileSize(true, drive, fileSize);
            if (driveFileFit == 2) {
                int driveFileFitSecondary = checkFileSize(true, secondaryDrive, fileSize);
                if (driveFileFitSecondary == 2) {
                    throw new IllegalStateException("ERROR! The file you are trying to create is bigger than both drives' individual capacity.");
                } else if (driveFileFitSecondary == 0) {
                    drive.setUsedSpace(secondaryDrive.getCapacity());

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
                drive.setUsedSpace(drive.getCapacity());
                System.out.println("WARNING! The file you are creating has depleted the primary drive's capacity. Delete files using method drive.deleteFile(), or extend your drive capacity.");
                System.out.println("File was created on primary drive.");
                System.out.println("WARNING!  Primary drive is full.");
            } else {
                long newPrimaryDriveUsedSpace = drive.getUsedSpace() + fileSize;
                drive.setUsedSpace(newPrimaryDriveUsedSpace);
                System.out.println("File was created on primary drive.");
                System.out.println("New USED primary drive space is: " + newPrimaryDriveUsedSpace + "bytes");
            }

        } else {
            throw new IllegalStateException("You cannot be creating files while the computer is OFF. Turn on your computer!");
        }
    }

    public void deleteFile(Drive drive, Drive secondaryDrive, long fileSize) {
        if (isOn) {
            int driveFileFit = checkFileSize(false, drive, fileSize);
            if (driveFileFit == 2) { //case when the file is bigger than primary drive capacity
                int driveFitSecondary = checkFileSize(false, secondaryDrive, fileSize);
                if (driveFitSecondary == 2) {
                    throw new IllegalStateException("ERROR! NON existent file! The file you are trying to delete is bigger than both drives' individual used space.");
                } else if (driveFitSecondary == 0) {
                    secondaryDrive.setUsedSpace(0);
                    System.out.println("File was deleted from secondary drive. ");
                    System.out.println("HURRAY! Your secondary drive is as new, completely empty. Have fun creating new files here");
                } else {
                    long newSecondaryDriveUsedSpace = secondaryDrive.getUsedSpace() - fileSize;
                    secondaryDrive.setUsedSpace(newSecondaryDriveUsedSpace);
                    System.out.println("File was deleted from secondary drive. ");
                    System.out.println(("New USED space on drive is: ") + newSecondaryDriveUsedSpace + "bytes");
                }

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

    public int checkFileSize(boolean creating, Drive drive, long fileSize) {
        long driveFileFit;
        if (creating) {
            driveFileFit = drive.getCapacity() - (drive.getUsedSpace() + fileSize);
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

    @Override
    public String toString() {
        return "Computer{" +
                "isOn=" + isOn +
                ", processor=" + processor +
                ", memory=" + memory +
                ", drive=" + drive +
                '}';
    }
}





