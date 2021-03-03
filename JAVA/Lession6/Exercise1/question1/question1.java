package question1;

public class question1 {
	public static void main(String[] args) {

		int[] numbers = { -1, 1, 3, 5, -5, -8 };
		int maxValue = getMaxValue(numbers);
		int minValue = getMinValue(numbers);

		System.out.println("Max Value: " + maxValue);
		System.out.println("Min Value: " + minValue);
	}

	public static int getMaxValue(int[] numbers) {
		int maxValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > maxValue) {				// sai dấu <, thay bằng >
				maxValue = numbers[i];
			}
		}
		return maxValue;
	}

	public static int getMinValue(int[] numbers) {
		int minValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {	// sai number.length - 1, b�? -1
			if (numbers[i] < minValue) {				// sai dấu >, thay bằng <
				minValue = numbers[i];
			}
		}
		return minValue;
	}
}
