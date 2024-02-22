package cz.czechitas.ukol3.model;

import java.util.Objects;

public class Computer {
    public boolean isOn;

    public void turnOn() {
        if (isOn) {
            System.err.println("Počítač je již zapnutý.");
            return;
        }
        this.isOn = true;
    }

    ;

    public void turnOff() {
        if(!isOn){return ;} else{
        this.isOn = false;
        System.out.println("Počítač je vypnutý");};
    }

    ;

    public String stateComputer() {
        if (isOn) {
            return "Počítač je zapnutý";
        } else {
            return "Počítač je vypnutý";
        }
    }

    ;
}

