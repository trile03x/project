/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package billmanage;

import java.io.Serializable;
import java.util.*;

public class Bill implements Serializable{

    String code;
    String type;
    double oldindex;
    double newindex;

    Bill() {

    }

    public Bill(String code, String type, double oldindex, double newindex) {
        this.code = code;
        this.type = type;
        this.oldindex = oldindex;
        this.newindex = newindex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getOldindex() {
        return oldindex;
    }

    public void setOldindex(double oldindex) {
        this.oldindex = oldindex;
    }

    public double getNewindex() {
        return newindex;
    }

    public void setNewindex(double newindex) {
        this.newindex = newindex;
    }

    public double UsedElectricalEnergy() {
        return getNewindex() - getOldindex();
    }

    public int Norm() {
        if (getType().equals("NN")) {
            return 500;
        } else if (getType().equals("SX") || getType().equals("KD")) {
            return 400;
        } else {
            return 300;
        }
    }

    public void display() {
        System.out.println("- Code of customer : " + getCode()
                + "\n- Type of customer: " + getType()
                + "\n- Old index of electricity meter :" + getOldindex()
                + "\n- New index of electricity meter :" + getNewindex()
                + "\n- Payment of customer : " + Payment());
    }

    public double Payment() {
        if (UsedElectricalEnergy() <= Norm()) {
            return UsedElectricalEnergy() * 550;
        } else {
            return UsedElectricalEnergy() * 1100;
        }
    }
    public String toString()
    {
        return code+";"+type+";"+oldindex+";"+newindex;
    }
}
