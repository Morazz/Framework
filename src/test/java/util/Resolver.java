package util;

public class Resolver {

    public static String resolvePrice(int price){
        return  String.join(" ", Integer.toString(price), "$");
    }

    public static int resolvePrice(String price){
        return  Integer.parseInt(price.substring(price.length()-1));
    }

    public static String resolveTemplate(String template, int data){
        return String.format(template, data);
    }

    public static String resolveTemplate(String template, String data){
        return String.format(template, data);
    }

}
