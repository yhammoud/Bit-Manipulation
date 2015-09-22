/**
 * Coding with bitwise operators
 *
 * @author Youssef Hammoud
 *
 * Definitions of types:
 * nibble - 4 bits
 * byte   - 8 bits
 * short  - 16 bits
 * int    - 32 bits
 */
public class Operations
{
	/**
	 * Set an 8-bit byte in an int.
	 *
	 * Ints are made of four bytes, numbered like so:
	 *   B3 B2 B1 B0
	 *
	 * For a graphical representation of the bits:
	 *   3322222222221111111111
	 *   10987654321098765432109876543210 <= starting with bit 0
	 *   -------+-------+-------+-------+
	 *    Byte 3| Byte 2| Byte 1| Byte 0|
	 *
	 * Examples:
	 *     setByte(0xAAA5BBC6, 0x17, 1); // => 0xAAA517C6
	 *     setByte(0x56B218F9, 0x44, 3); // => 0x44B218F9
	 *
	 * @param num The int that will be modified.
	 * @param byte The byte to insert into the integer.
	 * @param which Selects which byte to modify - 0 for least-significant byte.
	 *
	 * @return The modified int.
	 */
	public static int setByte(int num, int a_byte, int which)
	{
		return (a_byte << (which << 3)) | (num & (~(0xFF << (which << 3))));
	}

	/**
	 * Get a 4-bit nibble from an int.
	 *
	 * Ints are made of 8 nibbles, numbered like so:
	 *   N7 N6 N5 N4 N3 N2 N1 N0
	 *
	 * For a graphical representation of the bits:
	 *   3322222222221111111111
	 *   10987654321098765432109876543210 <= starting with bit 0
	 *   ---+---+---+---+---+---+---+---+
	 *    N7| N6| N5| N4| N3| N2| N1| N0|
	 *
	 * Examples:
	 *     getNibble(0x56781234, 3); // => 0x1
	 *     getNibble(0xFF254545, 7); // => 0xF
     *
	 * @param num The int to get a nibble from.
	 * @param which Determines which nibble gets returned - 0 for least-significant nibble.
	 *
	 * @return A nibble corresponding to the "which" parameter from num.
	 */
	public static int getNibble(int num, int which)
	{
		return (num & (0xF << (which << 2)))
			>> (which << 2);
	}

	/**
	 * Pack 4 bytes into an int.
	 *
	 * The bytes should be placed consecutively in the 32-bit int in the order
	 * specified by the parameters.
	 *
	 * Example:
	 *     pack(0x12, 0x34, 0x56, 0x78); // => 0x12345678
	 *     pack(0xDE, 0xAD, 0xBE, 0xEF); // => 0xDEADBEEF
	 *
	 * @param b3 Most significant byte (will always be an 8-bit number).
	 * @param b2 2nd byte (will always be an 8-bit number).
	 * @param b1 3rd byte (will always be an 8-bit number).
	 * @param b0 Least significant byte (will always be an 8-bit number).
	 *
	 * @return a 32-bit value formatted like so: b3b2b1b0
	 */
	public static int pack(int b3, int b2, int b1, int b0)
	{
		return (b0 << (0 << 3))
			| (b1 << (1 << 3))
			| (b2 << (2 << 3))
			| (b3 << (3 << 3));
	}

	/**
	 * Extract a range of bits from a number.
	 *
	 * Examples:
	 *     bitRange(0x00001234, 0, 4);  // => 0x00000004
	 *     bitRange(0x00001234, 4, 8);  // => 0x00000023
	 *     bitRange(0x12345678, 0, 28); // => 0x02345678
	 *     bitRange(0x55555555, 5, 7);  // => 0x0000002A
	 *
	 * Note: We will only pass in values 1 to 31 for n.
	 *
	 * @param num An n-bit 2's complement number.
	 * @param s The starting bit to grab
	 * @param n The number of bits to return.
	 * @return The n-bit number num[s:s+n-1].
	 */
	public static int bitRange(int num, int s, int n)
	{
		return num << ((0x1 << 5) - (n + s)) >> ((0x1 << 5) - n);
	}

	/**
	 * NOTE: For this method, you may only use &, |, and ~.
	 *
	 * Perform an exclusive-or on two 32-bit ints.
	 *
	 * Examples:
	 *     xor(0xFF00FF00, 0x00FF00FF); // => 0xFFFFFFFF
	 *     xor(0x12345678, 0x87654321); // => 0x95511559
	 *
	 * @param num1 An int
	 * @param num2 Another int
	 *
	 * @return num1 ^ num2
	 */
	public static int xor(int num1, int num2)
	{
		return (num1 & ~num2) | (~num1 & num2);
	}

	/**
	 * Return true if the given number is a power of 2.
	 *
	 * Examples:
	 *     powerOf2(1024); // => true
	 *     powerOf2(23);   // => false
	 *
	 * @param Num a 32-bit int. Since this is an int, it is SIGNED!
	 * @return true if num is a power of 2.
	 */
	public static boolean powerOf2(int num)
	{
		return ((num >= 1) &&
			((num & (num - 1)) == 0));
	}

}

