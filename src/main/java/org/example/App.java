/* Gabriel Fernandez
 * COP3330 - Summer CV01
 * "Motivated" Practice Exercises
 * Exercise 20 - Multistate Sales Tax Calculator
 */

package org.example;

// Import necessary libraries
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class App 
{

    // Main function
    public static void main( String[] args )
    {
        // Initialize constants and variables
        final double WI_TAX = 5;
        final double EAU_C_TAX = .005;
        final double DUNN_C_TAX = .004;
        final double IL_TAX = 8;
        double tax;
        double total;
        int flag = 0;
        String wi = "wi";
        String wisconsin = "wisconsin";
        String ecc = "eau claire county";
        String ec = "eau claire";
        String dc = "dunn county";
        String d = "d";
        String il = "il";
        String illinois = "illinois";

        // Prompt user for the order amount and the state they live in
        // and store these values
        System.out.println("What is the order amount?");
        Scanner orderIn = new Scanner(System.in);
        int order = orderIn.nextInt();

        System.out.println("What state do you live in?");
        Scanner stateIn = new Scanner(System.in);
        String state = stateIn.next();

        // If the state is Wisconsin, we need to prompt user for their county,
        // I used a nested if statement to do this
        if (wi.equals(state.toLowerCase()) ||
                wisconsin.equals(state.toLowerCase())) {
            System.out.println("What county do you live in?");
            Scanner countyIn = new Scanner(System.in);
            // Scan the string until the next line is reached
            String county = countyIn.nextLine();

            // If the county equals Eau Claire, add a tax of 0.005 in addition to the 5%
            // state tax
            if (ecc.equals(county.toLowerCase()) ||
                    ec.equals(county.toLowerCase())) {
                tax = order * ((WI_TAX + EAU_C_TAX) / 100);
                total = order + tax;
            }
            // If it is Dunn county, add a tax of 0.004 instead
            else if (dc.equals(county.toLowerCase()) ||
                    d.equals(county.toLowerCase())) {
                tax = order * ((WI_TAX + DUNN_C_TAX) / 100);
                total = order + tax;
            }
            // If the input is neither Eau Claire or Dunn, then just use the 5% state tax
            else {
                tax = order * (WI_TAX / 100);
                total = order + tax;
            }
        }
        // If the state inputted is Illinois, apply the 8% state tax
        else if (il.equals(state.toLowerCase()) ||
                illinois.equals(state.toLowerCase())) {
            tax = order * (IL_TAX / 100);
            total = order + tax;
        }
        // If the state is neither Wisconsin or Illinois, then no tax needs to
        // be applied
        else {
            tax = 0;
            total = order;
            flag = 1;
        }

        // Limit the following numbers to two decimal places
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.CEILING);

        // If the flag remains to be 0, that means either Wisconsin
        // or Illinois was selected as the state, so we print both
        // the tax and total; if the flag is 1, only print the total
        String msg = flag == 0
                ? "The tax is $" + df.format(tax) + ".\n" +
                "The total is $" + df.format(total) + ".\n"
                : "The total is $" + df.format(total) + ".";

        // Print the output message
        System.out.println(msg);
    }
}
