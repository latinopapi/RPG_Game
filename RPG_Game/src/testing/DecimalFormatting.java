package testing;

import java.text.DecimalFormat;

public class DecimalFormatting {
  /*  public static void main(String args[]) {
        double d = 9.4568982982989;
        String pattern = "#.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formattedDouble = decimalFormat.format(d);
        System.out.println("Formatted double d = " + formattedDouble);
        double bro = Double.parseDouble(formattedDouble);
        System.out.println(bro + 12);
    }


    public static void main(String[] args) {
        double d = 6.3546;
        DecimalFormat df = new DecimalFormat("#.##");
        String n=df.format(d);
        double j= Double.valueOf(n);
        System.out.print(j+1.2);

    }
*/

    public static void main(String[] args) {
        double d=0.23423;
        double j = Math.floor(d*100)/100;
        System.out.println(j);
        homie();
    }

    public static void homie(){
        double f = 0.343524234;
        String t = String.format("%.2f",f);
        f = Double.valueOf(t);
        System.out.print(f);
    }


}