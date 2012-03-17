/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relativistic;

import java.io.*;
import java.text.*;

/**
 *
 * @author grammaticus
 */
public class Main {

    public Ship myShip = new Ship();
    public Terra myTerra = new Terra();
    public Formulae myFormulae = new Formulae();
    NumberFormat formatter = new DecimalFormat("#0.00");

    public void ShipMenu() {
        boolean done = false;
        String nomore = "";
        int choice;
        InputStreamReader info = new InputStreamReader(System.in);
        BufferedReader data = new BufferedReader(info);
        InputStreamReader finished = new InputStreamReader(System.in);
        BufferedReader fin = new BufferedReader(finished);
        while (done == false) {
            choice = 0;
            System.out.println("What information do you have?\n"
                    + "[1] Acceleration\n"
                    + "[2] Mass Ratio\n"
                    + "[3] Exhaust Velocity\n"
                    + "[4] Proper Time\n");

            try {
                choice = Integer.parseInt(data.readLine());
            } catch (IOException e) {
                System.out.println("Error! Exception: " + e);
            }
            if (choice == 1) {
                myShip.setA();
            } else if (choice == 2) {
                myShip.setMR();
            } else if (choice == 3) {
                myShip.setEV();
            } else if (choice == 4) {
                myShip.setPTime();
            } else {
                System.out.println("You have entered an invalid number; please"
                        + "try again.");
            }
            System.out.print("Do you have more data to enter? [Y] or [N]: ");
            try {
                nomore = fin.readLine();
            } catch (IOException f) {
                System.out.println("Error!  Exception: " + f);
            }
            if ((nomore == null ? "Y" == null : nomore.equals("Y"))
                    || (nomore == null ? "y" == null : nomore.equals("y"))) {
                continue;
            } else if ((nomore == null ? "N" == null : nomore.equals("N"))
                    || (nomore == null ? "n" == null : nomore.equals("n"))) {
                done = true;
            } else {
                System.out.println("You have entered an invalid choice.");
            }
        }
    }

    public void TerraMenu() {
        boolean done = false;
        String nomore = "";
        int choice;
        InputStreamReader info = new InputStreamReader(System.in);
        BufferedReader data = new BufferedReader(info);
        InputStreamReader finished = new InputStreamReader(System.in);
        BufferedReader fin = new BufferedReader(finished);
        while (done == false) {
            choice = 0;
            System.out.println("What information do you have?\n"
                    + "[1] Terra Time\n"
                    + "[2] Distance\n");

            try {
                choice = Integer.parseInt(data.readLine());
            } catch (IOException e) {
                System.out.println("Error! Exception: " + e);
            }
            if (choice == 1) {
                myTerra.setTTime();
            } else if (choice == 2) {
                myTerra.setD();
            } else {
                System.out.println("You have entered an invalid number; please"
                        + "try again.");
            }
            System.out.print("Do you have more data to enter? [Y] or [N]: ");
            try {
                nomore = fin.readLine();
            } catch (IOException f) {
                System.out.println("Error!  Exception: " + f);
            }
            if ((nomore == null ? "Y" == null : nomore.equals("Y"))
                    || (nomore == null ? "y" == null : nomore.equals("y"))) {
                continue;
            } else if ((nomore == null ? "N" == null : nomore.equals("N"))
                    || (nomore == null ? "n" == null : nomore.equals("n"))) {
                done = true;
            } else {
                System.out.println("You have entered an invalid choice.");
            }
        }
    }

    public void outputResults() {
        double accel = myShip.getA();
        double pTime = myShip.getPTime();
        double ev = myShip.getEV();
        double mr = myShip.getMR();
        double tTime = myTerra.getTTime();
        double d = myTerra.getD();
        double v;
        double gamma;

        /* Check that acceleration is > 0*/
        if (accel <= 0){
            System.out.println("You must have an acceleration greater than 0\n"
                    + "The program will now exit.");
            System.exit(1);
        }
        /*Terra Time*/
        if (tTime == -1) {
            double tt1 = myFormulae.tTime1(accel, pTime);
            double tt2 = myFormulae.tTime2(ev, mr, accel);
            double tt3 = myFormulae.tTime3(accel, d);

            if (Double.isNaN(tt1)) {
                System.out.println("tTime: " + formatter.format(tt2));
            } else if (Double.isNaN(tt3)) {
                System.out.println("tTime: " + formatter.format(tt1));
            } else {
                System.out.println("tTime: " + formatter.format(tt3));
            }
        } else {
            System.out.println("tTime: " + formatter.format(tTime));
        }

        /*Proper Time*/
        if (pTime == -1) {
            double pt1 = myFormulae.pTime1(accel, tTime);
            double pt2 = myFormulae.pTime2(accel, d);

            if (Double.isNaN(pt1)) {
                pTime = pt2;
            } else {
                pTime = pt1;
            }
        }
        System.out.println("pTime: " + formatter.format(pTime));

        /*Distance*/
        if (d == -1) {
            double d1 = myFormulae.tDist1(accel, pTime);
            double d2 = myFormulae.tDist2(ev, mr, accel);

            /*Included for completeness, but not actually used*/
            double d3 = myFormulae.tDist3(accel, tTime);
            if (Double.isNaN(d2)) {
                d = d1;
            } else {
                d = d2;
            }
        }
        System.out.println("tDist: " + formatter.format(d));


        /*Velocity*/
        double v1 = myFormulae.tVFin1(accel, pTime);
        double v2 = myFormulae.tVFin2(ev, mr);
        double v3 = myFormulae.tVFin3(accel, tTime);

        if (Double.isNaN(v2)) {
            v = v1;
        } else {
            v = v2;
        }
        System.out.println("vFin: " + formatter.format(v));

        /*Gamma*/
        double g1 = myFormulae.gamma1(accel, pTime);
        double g2 = myFormulae.gamma2(ev, mr);
        double g3 = myFormulae.gamma3(accel, tTime);
        double g4 = myFormulae.gamma4(accel, d);

        if (Double.isNaN(g2)) {
            gamma = g4;
        } else {
            gamma = g2;
        }
        System.out.println("gamma: " + formatter.format(gamma));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main myMain = new Main();
        myMain.ShipMenu();
        System.out.println("\n");
        myMain.TerraMenu();
        System.out.println("\n");
        myMain.outputResults();
        System.exit(0);
    }
}
