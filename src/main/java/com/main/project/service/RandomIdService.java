package com.main.project.service;

public class RandomIdService {
    public static String returnRandomId(String nameProduct){
        String defaultFirstTwoCharacter = nameProduct.substring(0,2);
        String AlphaNumericString1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder s = new StringBuilder();
        int x;
        for( x = 0; x < 5; x++) {
            int index = (int) (AlphaNumericString1.length() * Math.random());
            s.append(AlphaNumericString1.charAt(index));
        }
        return defaultFirstTwoCharacter + s.toString();
    }

    public static String returnRandomId(){
        String defaultOrder = "pet";
        String AlphaNumericString2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder s = new StringBuilder();
        int x;
        for( x = 0; x < 5; x++) {
            int index = (int) (AlphaNumericString2.length() * Math.random());
            s.append(AlphaNumericString2.charAt(index));
        }
        return defaultOrder + s.toString();
    }
    public void test(){
        System.out.println("test");
    }
}
