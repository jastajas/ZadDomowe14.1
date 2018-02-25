import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Converters {

    public static ArrayList<Double> metricConverter (HttpServletRequest request){

        String a = request.getParameter("metry");
        String b = request.getParameter("centymetry");
        String c = request.getParameter("milimetry");

        double meters = 0;
        double centimeters = 0;
        double milimeters = 0;
        double errorInput = 0;

        try{
        if(a != ""){
            meters = Double.valueOf(a);
        } else if(b != ""){
            centimeters = Double.valueOf(b);
        } else if(c != ""){
            milimeters = Double.valueOf(c);
        }} catch (NumberFormatException e){
            System.out.println("Podano niewłaściwy typ danych.");
            errorInput = 1;
        }

        if(meters != 0){
            centimeters = meters*100;
            milimeters = meters*1000;
        } else if (centimeters != 0){
            meters = centimeters/100;
            milimeters = centimeters*10;
        }else if (milimeters != 0){
            meters = milimeters/1000;
            centimeters = milimeters/10;
        }
        ArrayList<Double> metricValues = new ArrayList<>();
        metricValues.add(meters);
        metricValues.add(centimeters);
        metricValues.add(milimeters);
        metricValues.add(errorInput);

        return metricValues;
    }

    public static ArrayList<Double> weightConverter (HttpServletRequest req){

        String a = req.getParameter("kilogramy");
        String b = req.getParameter("gramy");
        String c = req.getParameter("miligramy");

        double kilograms = 0;
        double grams = 0;
        double miligrams = 0;
        double errorInput = 0;

        try{
            if(a != ""){
                kilograms = Double.valueOf(a);
            } else if(b != ""){
                grams = Double.valueOf(b);
            } else if(c != ""){
                miligrams = Double.valueOf(c);
            }} catch (NumberFormatException e){
            System.out.println("Podano niewłaściwy typ danych.");
            errorInput = 1;
        }

        if(kilograms != 0){
            grams = kilograms*1000;
            miligrams = kilograms*1000000;
        } else if (grams != 0){
            kilograms = grams/1000;
            miligrams = grams*1000;
        }else if (miligrams != 0){
            kilograms = miligrams/1000000;
            grams = miligrams/1000;
        }
        ArrayList<Double> metricValues = new ArrayList<>();
        metricValues.add(kilograms);
        metricValues.add(grams);
        metricValues.add(miligrams);
        metricValues.add(errorInput);

        return metricValues;
    }
}
