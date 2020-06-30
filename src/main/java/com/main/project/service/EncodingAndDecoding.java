package com.main.project.service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncodingAndDecoding {
    public static void encodingAndDecoding(String text) throws UnsupportedEncodingException{
        final String textString = text;
        String encodeText = Base64.getEncoder().encodeToString(textString.getBytes("UTF-8"));
        byte[] decodeArr = Base64.getDecoder().decode(encodeText);
        String decodeText = new String(decodeArr, "UTF-8");
    }
}
