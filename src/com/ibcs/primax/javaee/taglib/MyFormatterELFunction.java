package com.ibcs.primax.javaee.taglib;

/**
 * @author Abdullah Al Mamun Oronno
 *         Email: mr.oronno@gmail.com
 */

/**
 * This class demonstrate EL Function calling via Public Static method
 */
public class MyFormatterELFunction {

    public static String formatName(String name) {
        String formattedName = "Mr. " + name.toLowerCase();
        return formattedName;
    }

}
