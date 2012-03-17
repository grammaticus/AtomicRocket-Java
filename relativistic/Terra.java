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
public class Terra {

    /*
     * Class Variables
     * tTime = Terra Time
     * d = distance (Terra's frame of reference; in Light Years)
     */
    double tTime;
    double d;

    public Terra() {
        this.tTime = -1;
        this.d = -1;
    }

    void setTTime() {
        System.out.print("Please enter the Terra Time in years: ");
        double terratime = -1;
        InputStreamReader trtime = new InputStreamReader(System.in);
        BufferedReader terrat = new BufferedReader(trtime);
        try {
            terratime = Double.parseDouble(terrat.readLine());
        } catch (IOException e) {
            System.out.println("Error! Exception: " + e);
        }
        this.tTime = terratime;
        //
    }

    double getTTime() {
        return this.tTime;
    }

    void setD() {
        System.out.print("Please enter the distance in Light Years: ");
        double distance = -1;
        InputStreamReader dist = new InputStreamReader(System.in);
        BufferedReader dly = new BufferedReader(dist);
        try {
            distance = Double.parseDouble(dly.readLine());
        } catch (IOException e) {
            System.out.println("Error! Exception: " + e);
        }
        this.d = distance;
    }

    double getD() {
        return this.d;
    }

}
