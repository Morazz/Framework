package util;

public class Resolver {

    public static String resolvePrice(double price){
        return  String.join(" ", Double.toString(price), "$");
    }

    public static double resolvePrice(String price){
        return  Double.parseDouble(price.substring(price.length()-1));
    }

    public static String resolveTemplate(String template, int data){
        return String.format(template, data);
    }

    public static String resolveTemplate(String template, String data){
        return String.format(template, data);
    }

}
