package cz.czechitas.ukol3.model;

import java.util.Objects;
import java.util.Locale;

public class Drive {
    private long driveCapacity; // in bites
    private long driveUsed; // in bites
    private String driveName;

    public long getDriveCapacity() {
        if (driveCapacity == 0) {
            throw new IllegalStateException("Sorry I need to know the drive's capacity!");
        }
        ;
        return driveCapacity;
    }

    public void setDriveCapacity(long driveCapacity) {
        this.driveCapacity = driveCapacity;
    }

    public long getUsedSpace() {
//        if (driveUsed == 0) {
//            throw new IllegalStateException("Sorry I need to know how much space on the drive is used!");
//        } used drive information 0 value possible when drive is empty. Conditions not necessary.
        ;
        return driveUsed;
    }

    public void setUsedSpace(long usedSpace) {
        this.driveUsed = usedSpace;
    }

    public String getDriveName() {
        return driveName;
    }

    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }

    public void driveState() {
        System.out.println("Here are the drive parameters:");
        System.out.println("Drive name" + getDriveName());
        System.out.println("Drive capacity: " + String.format(Locale.of("CS", "cz"), "%,d", getDriveCapacity()) + " bytes");
        System.out.println("Used space: " + String.format(Locale.of("CS", "cz"), "%,d",getUsedSpace()) + " bytes");
        }
}
