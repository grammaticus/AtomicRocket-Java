/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relativistic;

/**
 *
 * @author grammaticus
 */
public class Formulae {

    /*
     * CONSTANTS
     */
    /*Speed of Light in m/s*/
    static final double C = 299792458;
    /*Seconds in a year*/
    static final double SECS = 31556926;
    /*Light Year in Meters*/
    static final double LY = 9.46 * Math.pow(10, 15);


    /*
     * Hyperbolic Arc-Trig Functions
     */
    static double asinh(double x) {
        return Math.log(x + Math.sqrt(x * x + 1.0));
    }

    static double acosh(double x) {
        return Math.log(x + Math.sqrt(x * x - 1.0));
    }

    static double atanh(double x) {
        return 0.5 * Math.log((x + 1.0) / (x - 1.0));
    }

    /*
     * Unit Conversions
     */
    /*seconds to years*/
    double years(double t){
        return t/SECS;
    }

    /*years to seconds*/
    double seconds(double t){
        return t*SECS;
    }

    /*light years to meters*/
    double meters(double d){
        return d*LY;
    }

    /*meters to light years*/
    double lightyears(double d){
        return d/LY;
    }

    /*PSL*/
    double psl(double v){
        return v/C;
    }

    /*
     * Terra's Frame of Reference
     */

    /*given accel and proper time (spaceship's frame of reference)*/
    double tTime1(double a, double pTime) {
        return years((C/a)*Math.sinh(a*seconds(pTime)/C));
    }


    /*to expend all propellant, given acceleration, exhaust velocity and
     mass ratio*/
    double tTime2(double ev, double mr, double a){
        return (C/a)*Math.sinh((ev/C)*Math.log(mr));
    }

    /*given accel and distance*/
    double tTime3(double a, double d){
        return years(Math.sqrt(Math.pow(meters(d)/C, 2) + (2*meters(d)/a)));
    }

    /*given accel and proper time (spaceship's frame of reference)*/
    double tDist1(double a, double pTime){
        return lightyears((Math.pow(C, 2)/a)*(Math.cosh(a*seconds(pTime)/C)-1));
    }

    /*given acceleration, exhaust velocity and mass ratio, after all propellant
     expended*/
    double tDist2(double ev, double mr, double a){
        return lightyears((Math.pow(C, 2)/a)*(Math.cosh((ev/C)*Math.log(mr)-1)));
    }

    /*given acceleration and Terra time*/
    double tDist3(double a, double tTime){
        return lightyears((Math.pow(C, 2)/a)*(Math.sqrt(1 +
                Math.pow(a*seconds(tTime)/C, 2))-1));
    }

    /*given accel and proper time (spaceship's frame of reference)*/
    double tVFin1(double a, double pTime){
        return psl(C*Math.tanh(a*seconds(pTime)/C));
    }

    /*given exhaust velocity and mass ratio*/
    double tVFin2(double ev, double mr){
        return psl(C*Math.tanh((ev/C)*Math.log(mr)));
    }

    /*given accel and Terra time*/
    double tVFin3(double a, double tTime){
        return psl((a*seconds(tTime))/(Math.sqrt(1 +
                Math.pow(a*seconds(tTime)/C, 2))));
    }


    /*
     * Ship's Frame of Reference
     */

    /*given a and Terra time*/
    double pTime1(double a, double tTime) {
        return years((C / a) * asinh(a * seconds(tTime) / C));
    }

    /*given acceleration and distance*/
    double pTime2(double a, double d) {
        return years((C / a) * acosh(a * meters(d) / (Math.pow(C, 2)) + 1));
    }

    /*
     * Time Dilation
     */

    /*given accel and proper time (spaceship's frame of reference)*/
    double gamma1(double a, double pTime){
        return Math.cosh(a*seconds(pTime)/C);
    }

    /*given exhaust velocity and mass ratio*/
    double gamma2(double ev, double mr){
        return Math.cosh((ev/C)*Math.log(mr));
    }

    /*given accel and Terra time*/
    double gamma3(double a, double tTime){
        return Math.sqrt(1+Math.pow(a*seconds(tTime)/C, 2));
    }

    /*given accel and distance*/
    double gamma4(double a, double d){
        return a*meters(d)/Math.pow(C,2)+1;
    }
}
