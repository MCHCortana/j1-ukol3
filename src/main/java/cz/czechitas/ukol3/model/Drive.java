package cz.czechitas.ukol3.model;

import java.util.Objects;
import java.util.Locale;

public class Drive {
    private long driveCapacity; // in bites
    private long driveUsed; // in bites

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
        if (driveUsed == 0) {
            throw new IllegalStateException("Sorry I need to know how much space on the drive is used!");
        }
        ;
        return driveUsed;
    }

    public void setUsedSpace(long usedSpace) {
        this.driveUsed = usedSpace;
    }

    public void driveState() {
        System.out.println("Here are the drive parameters:");
        System.out.println("Drive capacity: " + String.format(Locale.of("CS", "cz"), "%,d", getDriveCapacity()) + " bytes");
        System.out.println("Used space: " + String.format(Locale.of("CS", "cz"), "%,d",getUsedSpace()) + " bytes");
    }
}
