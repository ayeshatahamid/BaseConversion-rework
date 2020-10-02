import java.util.Scanner;

public class NumConversion {
    public static Long hexStringDecode(String hex) {
        Long decodedHex = (long) 0;
        int power = 0;


        //go through entire string with for loop
        for(int i = hex.length() - 1; i >= 0; i--) { //starts at last integer
            if (hex.charAt(i) == 'x') {
                break;
            }

            else {
                decodedHex = hexCharDecode(hex.charAt(i)) * (long) Math.pow(16, power) + decodedHex;
                power++;
            }
        }

        return decodedHex;
    }


    public static short hexCharDecode(char digit) {
        short numberVers;

        switch (digit) {
            case 'a':
            case 'A':
                numberVers = 10;
                break;
            case 'b':
            case 'B':
                numberVers = 11;
                break;
            case 'c':
            case 'C':
                numberVers = 12;
                break;
            case 'd':
            case 'D':
                numberVers = 13;
                break;
            case 'e':
            case 'E':
                numberVers = 14;
                break;
            case 'f':
            case 'F':
                numberVers = 15;
                break;
            default:
                numberVers = Short.parseShort(Character.toString(digit));
                break;
        }
        return numberVers;
    }

    public static short binaryStringDecode(String binary) {
        short decodedBinary = (short) 0;
        short power = 0;

        //iterate through string
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == 'b') {
                break;
            }
            else {
                short intToShort = (short) Character.getNumericValue(binary.charAt(i));
                decodedBinary = (short) (intToShort * Math.pow(2, power) + decodedBinary);
                power++;
            }
        }
        return decodedBinary;
    }

    public static String binaryToHex(String binary) {
        int decimal = binaryStringDecode(binary);
        String result = "";
        int remainder;

        while (decimal > 0) {
            remainder = decimal % 16;
            if (remainder == 15) {
                result = "F".concat(result);
            }
            else if(remainder == 14) {
                result = "E".concat(result);
            }
            else if(remainder == 13) {
                result = "D".concat(result);
            }
            else if(remainder == 12) {
                result = "C".concat(result);
            }
            else if(remainder == 11) {
                result = "B".concat(result);
            }
            else if(remainder == 10) {
                result = "A".concat(result);
            }
            else {
                result = Integer.toString(remainder).concat(result);
            }
            decimal = decimal / 16;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scnr =  new Scanner(System.in);
        int menuItem = 0;

        while (menuItem != 4) {
            System.out.println("Decoding Menu\n------------- ");
            System.out.println("1. Decode hexadecimal\n2. Decode binary\n3. Convert binary to hexadecimal\n4. Quit ");
            System.out.print("\nPlease enter an option: ");
            menuItem = scnr.nextInt();

            if (menuItem != 4) { // Just so that this won't print after selecting menuItem 4
                System.out.print("\nPlease enter the numeric string to convert: ");
            }

            if (menuItem == 1) {
                String hex = scnr.next();

                Long result = hexStringDecode(hex);
                System.out.println("Result: " + result + "\n");
            }
            else if (menuItem == 2) {
                String binary = scnr.next();

                short result;
                result = binaryStringDecode(binary);
                System.out.println("Result: " + result + "\n");
            }
            else if (menuItem == 3) {
                String binary = scnr.next();

                String result;
                result = binaryToHex(binary);
                System.out.println("Result: " + result + "\n");
            }
            else if (menuItem == 4) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
