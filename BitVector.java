/**
 * Coding a bit vector
 *
 * @author Youssef Hammoud
 *
 */
public class HW2BitVector
{
	/**
	 * 32-bit data initialized to all zeros. Here is what you will be using to represent
	 * the Bit Vector.
	 */
	private int bits;

	/**
	 * Sets the bit (sets to 1) pointed to by index.
	 * @param index index of which bit to set.
	 *        0 for the least significant bit (right most bit).
	 *        31 for the most significant bit.
	 */
	public void set(int index)
	{
		bits = bits | 0x1 << index;
	}

	/**
	 * Clears the bit (sets to 0) pointed to by index.
	 * @param index index of which bit to set.
	 * 	      0 for the least significant bit (right most bit).
	 * 	      31 for the most significant bit.
	 */
	public void clear(int index)
	{
		bits = bits & ~(0x1 << index);
	}

	/**
	 * Toggles the bit (sets to the opposite of its current value) pointed to by index.
	 * @param index index of which bit to set.
	 * 	      0 for the least significant bit (right most bit).
	 * 	      31 for the most significant bit.
	 */
	public void toggle(int index)
	{
		bits = bits ^ 0x1 << index;
	}

	/**
	 * Returns true if the bit pointed to by index is currently set.
	 * @param index index of which bit to check.
	 * 	      0 for the least significant bit (right-most bit).
	 * 	      31 for the most significant bit.
	 * @return true if the bit is set, false if the bit is clear.
	 *         If the index is out of range (index >= 32), then return false.
	 */
	public boolean isSet(int index)
	{
		if (index >= 32) {
			return false;
		}

		else if ((bits & (0x1 << index)) ==
			(0x1 << index)) {
			return true;
		}

		return false;
	}

	/**
	 * Returns true if the bit pointed to by index is currently clear.
	 * @param index index of which bit to check.
	 * 	      0 for the least significant bit (right-most bit).
	 * 	      31 for the most significant bit.
	 * @return true if the bit is clear, false if the bit is set.
	 *         If the index is out of range (index >= 32), then return true.
	 */
	public boolean isClear(int index)
	{
		if (index >= 32) {
			return true;
		}

		return ((bits & (0x1 << index)) == 0);
	}

	/**
	 * Returns a string representation of this object.
	 * Return a string with the binary representation of the bit vector.
	 * Returns a 32-bit string representation.
	 * i.e if the bits field was 2, then return "00000000000000000000000000000010"
	 */
	public String toString()
	{
		String output = "";
		for (int i = 0; i < 32; i++) {
			if ((bits & (0x1 << i)) == 0) {
				output = "0" + output;
			} else {
				output = "1" + output;
			}
		}
		return output;
	}

	/**
	 * Returns the number of bits currently set (=1) in this bit vector.
	 */
	public int onesCount()
	{
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((bits & (0x1 << i)) != 0) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Returns the number of bits currently clear (=0) in this bit vector.
	 */
	public int zerosCount()
	{
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((bits & (0x1 << i)) == 0) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Returns the "size" of this BitVector. The size of this bit vector is defined
	 * to be the minimum number of bits that will represent all of the ones.
	 * For example, the size of the bit vector 00010000 will be 5.
	 */
	public int size()
	{
		int minimum = 32;
		for (int i = 31; i > -1 && minimum > 1; i--) {
			if ((bits & (0x1 << i)) != 0) {
				return minimum;
			}
			minimum--;
		}
		return minimum;
	}
}

