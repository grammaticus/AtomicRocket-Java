/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relativistic;

import java.io.*;

/**
 *
 * @author grammaticus
 */
public class Ship {

    /*
     * Class Variables
     * a = Acceleration (m/s^2)
     * mr = Mass Ratio (dimensionless number)
     * ev = Exhaust Velocity (m/s)
     * pTime = Proper Time (spaceship's frame of reference)
     */
    double a;
    double mr;
    double ev;
    double pTime;

    public Ship() {
        this.a = -1;
        this.mr = -1;
        this.ev = -1;
        this.pTime = -1;
    }

    void setA() {
        System.out.print("Please enter the acceleration in m/s^2\n"
                + "(1g ~ 10 m/s^2): ");
        double acceleration = -1;
        InputStreamReader acc = new InputStreamReader(System.in);
        BufferedReader accel = new BufferedReader(acc);
        try {
            acceleration = Double.parseDouble(accel.readLine());
        } catch (IOException e) {
            System.out.println("Error! Exception: " + e);
        }
        this.a = acceleration;
    }

    double getA() {
        return this.a;
    }

    void setMR() {
        System.out.print("Please enter the mass ratio: ");
        double massratio = -1;
        InputStreamReader massr = new InputStreamReader(System.in);
        BufferedReader mratio = new BufferedReader(massr);
        try {
            massratio = Double.parseDouble(mratio.readLine());
        } catch (IOException e) {
            System.out.println("Error! Exception: " + e);
        }
        this.mr = massratio;
    }

    double getMR() {
        return this.mr;
    }

    void setEV() {
        System.out.print("Please enter the exhaust velocity in m/s: ");
        double exhaustv = -1;
        InputStreamReader evel = new InputStreamReader(System.in);
        BufferedReader exvelocity = new BufferedReader(evel);
        try {
            exhaustv = Double.parseDouble(exvelocity.readLine());
        } catch (IOException e) {
            System.out.println("Error! Exception: " + e);
        }
        this.ev = exhaustv;
    }

    double getEV() {
        return this.ev;
    }

    void setPTime() {
        System.out.print("Please enter the Proper Time in years: ");
        double proptime = -1;
        InputStreamReader prtime = new InputStreamReader(System.in);
        BufferedReader propert = new BufferedReader(prtime);
        try {
            proptime = Double.parseDouble(propert.readLine());
        } catch (IOException e) {
            System.out.println("Error! Exception: " + e);
        }
        this.pTime = proptime;
    }

    double getPTime() {
        return this.pTime;
    }
}
