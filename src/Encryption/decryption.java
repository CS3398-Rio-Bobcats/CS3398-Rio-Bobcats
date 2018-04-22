/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encryption;

/**
 *
 * @author Zach Sotak
 */
public class decryption {
    
    public static String decrypt(String key) {
        String result = "";
        int l = key.length(); //get length of the string
        char ch;
        for(int i = 0; i < l; i++){
            ch = key.charAt(i);
            ch -= 10;
            result += ch;
        }
        return result;
    }
    
}
