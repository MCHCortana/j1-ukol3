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
        mujMacDrive.setCapacity(245_107_195_904L);
        tynkaComp.setDrive(mujMacDrive);
        System.out.println(mujMacDrive.toString());

        Drive mujMacDriveSecondary = new Drive();
        mujMacDriveSecondary.setCapacity(345107195904L);

        tynkaComp.turnOn();
        System.out.println(tynkaComp.toString());

        tynkaComp.turnOff();
        tynkaComp.turnOff();
        tynkaComp.turnOn();
        System.out.println(tynkaComp.toString());
        tynkaComp.turnOn();
    }
}
