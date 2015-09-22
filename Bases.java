/**
 * Coding with bases
 *
 * @author Youssef Hammoud
 *
 */
public class Bases
{
	/**
	 * strdtoi - Decimal String to int
	 * Convert a string containing ASCII characters (in decimal) to an int.
	 * Example: strdtoi("123"); // => 123
	 */
	public static int strdtoi(String decimal)
	{
		int power = 1;
		int output = (decimal.charAt(decimal.length() - 1) - 48) * power;
		int integer;

		for (int i = decimal.length() - 2; i >= 0; i--) {
			power = power * 10;
			integer = decimal.charAt(i) - 48;
			output += power * integer;
		}

		return output;
	}

	/**
	 * strbtoi - Binary String to int
	 * Convert a string containing ASCII characters (in binary) to an int.
	 * Example: strbtoi("111"); // => 7
	 */
	public static int strbtoi(String binary)
	{
		int power = 0;
		int output = 0;
		int k = 0;

		for (int i = binary.length() - 1; i >= 0; i--) {
			k = binary.charAt(i) - '0';
			if (k == 1) {
				output += 0x1 << power;
			}
			power++;
		}

		return output;
	}

	/**
	 * strxtoi - Hexadecimal String to int
	 * Convert a string containing ASCII characters (in hex) to an int.
	 * Example: strxtoi("A6"); // => 166
	 */
	public static int strxtoi(String hex)
	{
		int current;
		int power = 0;
		int output = 0;

		for (int i = hex.length() - 1; i >= 0; i--) {
			current = hex.charAt(i) - '0';
			if (hex.charAt(i) > '9') {
                current -= 7;
            }
            output += current << power;
			power = power + 4;
		}

		return output;
	}

	/**
	 * itostrb - int to Binary String
	 * Convert a int into a String containing ASCII characters (in binary).
	 * Example: itostrb(7); // => "111"
	 */
	public static String itostrb(int binary)
	{
		String output = "";
		char current;

		while (binary != 0) {
			current = '0';
			if ((binary & 1) == 1) {
				current = '1';
			}
			output = current + output;
			binary = binary >> 1;
		}

		if (output.length() == 0) {
            output = "0";
        }

		return output;
	}

	/**
	 * itostrx - int to Hexadecimal String
	 * Convert a int into a String containing ASCII characters (in hexadecimal).
	 * Example: itostrx(166); // => "A6"
	 */
	public static String itostrx(int hex)
	{
		String output = "";
        int remainder = 0;
        char curHex;

        while (hex >= 1) {
            remainder = hex - ((hex >> 4) << 4);
            if (remainder > 9) {
                output = (char) (remainder + 55) + output;
            } else {
                output = remainder + output;
            }
            hex = hex >> 4;
        }

        if (output.length() == 0) {
            output = "0";
        }

        return output;
	}


}

