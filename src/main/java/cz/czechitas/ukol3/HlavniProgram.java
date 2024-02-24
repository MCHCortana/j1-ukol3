package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Computer;
import cz.czechitas.ukol3.model.Memory;
import cz.czechitas.ukol3.model.Processor;
import cz.czechitas.ukol3.model.Drive;

public class HlavniProgram {

    public static void main(String... args) {
        Computer tynkaComp = new Computer();

        Processor mujMacCPU = new Processor();
        mujMacCPU.setCPUproducer("Apple");
        mujMacCPU.setCPUspeed((3_490_000_000L));
//        mujMacCPU.CPUstate();

        Memory mujMacRAM = new Memory();
        mujMacRAM.setMemoryCapacity(8_000_000_000L);
        mujMacRAM.getMemoryCapacity();
//        mujMacRAM.RAMstate();

        Drive mujMacDrive = new Drive();
        mujMacDrive.setDriveCapacity(245107195904L);
        mujMacDrive.setUsedSpace(245107195904L - 166623969280L); // initial used Drive value
        mujMacDrive.setDriveName("Céčko");
//        mujMacDrive.driveState();

        Drive mujMacDriveSecondary = new Drive();
        mujMacDriveSecondary.setDriveCapacity(345107195904L);
        mujMacDriveSecondary.setDriveName("Efko");
//        mujMacDriveSecondary.driveState();

        tynkaComp.turnOn(mujMacCPU, mujMacRAM, mujMacDrive, mujMacDriveSecondary);
        tynkaComp.computerState(1, mujMacCPU, mujMacRAM, mujMacDrive, mujMacDriveSecondary);

        tynkaComp.createFile(mujMacDrive, mujMacDriveSecondary, 166623969280L);

        tynkaComp.computerState(2, mujMacCPU, mujMacRAM, mujMacDrive, mujMacDriveSecondary);

        tynkaComp.deleteFile(mujMacDrive, mujMacDriveSecondary,245107195905L);


        tynkaComp.turnOff();
        tynkaComp.turnOff();
        tynkaComp.turnOn(mujMacCPU, mujMacRAM, mujMacDrive, mujMacDriveSecondary);
        tynkaComp.turnOn(mujMacCPU, mujMacRAM, mujMacDrive, mujMacDriveSecondary);
    }

}
