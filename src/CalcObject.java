/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Calculator.CalcPOA;
import org.omg.CORBA.ORB;

/**
 *
 * @author Zhaowei
 */
public class CalcObject extends CalcPOA{
    private ORB orb;
    
    public void setORB(ORB orb) {
        this.orb = orb; 
    }
    
    /** Calculate
    * @param type the type of the operation, 1 -> +, 2 -> -, 3 -> *, 4 -> /, 5 -> pow
	* @param a first number
	* @param b second number
	* @return calculation result
	*/
    //@Override
    public double calculate(int type, double a, double b) {
        double result = 0.0;
        
        if (type == 1) {
            result = (double) a + b;
        }
        else if (type == 2) {
            result = (double) a - b;
        }
        else if (type == 3) {
            result = (double) a * b;
        }
        else if (type == 4) {
            result = (double) a / b;
        } else if (type == 5) {
            result = (double) Math.pow(a, b); // Do mathematical powers
        }
        
        if (result >= Double.MAX_VALUE) {
            return Double.MAX_VALUE;
        }
        else if (result <= Double.MIN_VALUE) {
            return Double.MIN_VALUE;
        }
        else {
            return (double) result;
        }
    }
    
    @Override
    public void exit() {
        orb.shutdown(false);
    }
}
