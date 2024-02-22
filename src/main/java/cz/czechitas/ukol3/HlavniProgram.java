package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Computer;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        Computer mujMac = new Computer();
        //TODO tady bude váš kód - vytvoření instance třídy Pocitac, zapnutí, vpynutí, výpis hodnot.

        System.out.println("Program spuštěn.");
        System.out.println(mujMac.stateComputer());
        mujMac.turnOn();
        System.out.println(mujMac.stateComputer());
//        mujMac.turnOn();
        mujMac.turnOff();
        mujMac.turnOff();

    }

}
