package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Computer;
import cz.czechitas.ukol3.model.Memory;
import cz.czechitas.ukol3.model.Processor;
import cz.czechitas.ukol3.model.Drive;

public class HlavniProgram {

    public static void main(String... args) {
        Computer tynkaComp = new Computer();

        System.out.println(tynkaComp.toString());

        Processor mujMacCPU = new Processor();
        mujMacCPU.setProducer("Apple");
        mujMacCPU.setSpeed((3_490_000_000L));
        tynkaComp.setProcessor(mujMacCPU);

        System.out.println(mujMacCPU.toString());

        tynkaComp.turnOn();

        System.out.println(mujMacCPU.toString());

        Memory mujMacRAM = new Memory();
        mujMacRAM.setCapacity(8_000_000_000L);
        tynkaComp.setMemory(mujMacRAM);
        System.out.println(mujMacRAM.toString());

        tynkaComp.turnOn();

        System.out.println(mujMacCPU.toString());

        Drive mujMacDrive = new Drive();
//        mujMacDrive.setCapacity(245_107_195_904L);
        mujMacDrive.setCapacity(1000L);
        tynkaComp.setDrive(mujMacDrive);
        System.out.println(mujMacDrive.toString());

        Drive mujMacDriveSecondary = new Drive();
//        mujMacDriveSecondary.setCapacity(345_107_195_904L);
        mujMacDriveSecondary.setCapacity(1500L);
        tynkaComp.setSecondaryDrive(mujMacDriveSecondary);

        tynkaComp.turnOn();
        System.out.println(tynkaComp.toString());

        System.out.println("2600L");
        tynkaComp.createFileComplete(2600L);
        System.out.println(tynkaComp.toString());

        System.out.println("2500L");
        tynkaComp.createFileComplete(2500L);
        System.out.println(tynkaComp.toString());

        System.out.println("1100L");
        tynkaComp.createFileComplete(1100L);
        System.out.println(tynkaComp.toString());

        System.out.println("400L");
        tynkaComp.createFileComplete(400L);
        System.out.println(tynkaComp.toString());

        System.out.println("700L");
        tynkaComp.createFileComplete(700L);
        System.out.println(tynkaComp.toString());

        System.out.println("600L");
        tynkaComp.createFileComplete(600L);
        System.out.println(tynkaComp.toString());

        System.out.println("401L");
        tynkaComp.createFileComplete(401L);
        System.out.println(tynkaComp.toString());

        System.out.println("398L");
        tynkaComp.createFileComplete(398L);
        System.out.println(tynkaComp.toString());

        System.out.println("2L");
        tynkaComp.createFileComplete(2L);
        System.out.println(tynkaComp.toString());

        tynkaComp.turnOff();
        tynkaComp.turnOff();
        tynkaComp.turnOn();
        System.out.println(tynkaComp.toString());
        tynkaComp.turnOn();
    }
}
