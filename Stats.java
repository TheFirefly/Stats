public class Stats {
	
	public static void main(String[] args) {
		int[] a = {7, 5, 3, 3, 1};
		int[] b = {1, 3, 2, 5, 6, 7};

		System.out.println("Max of a: " + max(a));
		System.out.println("Min of a: " + min(a));
		System.out.println("Mean of a: " + mean(a));
		System.out.println("Mean of b: " + mean(b));
		System.out.println("Median of a: " + median(a));
		System.out.println("Median of b: " + median(b));
		System.out.println("Quartile 1 of a: " + quartile1(a));
		System.out.println("Quartile 1 of b: " + quartile1(b));
		System.out.println("Quartile 3 of a: " + quartile3(a));
		System.out.println("Quartile 3 of b: " + quartile3(b));
		System.out.println("Mode of a: " + mode(a));
		System.out.println("Mode of b: " + mode(b));
		System.out.println("Standard deviation of a: " + standardDeviation(a));
		System.out.println("Standard deviation of b: " + standardDeviation(b));
	}

	private static void printArray(int[] a) {
		for (int i = 0 ; i < a.length ; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static int max(int[] a) {
		int last = a[0];

		for (int i = 0 ; i < a.length ; i++) {
			last = Math.max(last, a[i]);
		}

		return last;
	}

	private static int min(int[] a) {
		int last = a[0];

		for (int i = 0 ; i < a.length ; i++) {
			last = Math.min(last, a[i]);
		}

		return last;
	}

	private static double sum(int[] a) {
		double sum = 0;

		for (int i = 0 ; i < a.length ; i++) {
			sum += a[i];
		}

		return sum;
	}

	private static double mean(int[] a) {
		return sum(a) / a.length;
	}

	public static int getSmallest(int[] a, int startingIndex) {
		int smallest = a[startingIndex];
		int index = startingIndex;
		for (int i = startingIndex ; i < a.length ; i++) {
			if (a[i] < smallest) {
				smallest = a[i];
				index = i;
			}
		}

		return index;
	}

	private static int[] sortA(int[] a) {
		int start = 0;
		for (int i = start ; i < a.length ; i++) {
			int index = getSmallest(a, start);
			int temp = a[start];
			a[start] = a[index];
			a[index] = temp;
			start++;
		}

		return a;
	}

	private static double median(int[] a) {
		return median(a, 0 , a.length - 1);
	}

	private static double median(int[] a, int startIndex, int endIndex) {
		a = sortA(a);
		int length = (endIndex - startIndex) + 1;
		if (length % 2 == 0) {
			//Even
			return ((a[startIndex + (length / 2) - 1] + a[startIndex + (length / 2)]) / 2);
		} else {
			return a[startIndex + (length / 2)];
		}
	}

	private static double quartile1(int[] a) {
		return median(a, 0, (a.length / 4) + 1);
	}

	private static double quartile3(int[] a) {
		return median(a, (a.length / 2), (a.length));
	}

	private static int mode(int[] a) {
		int max = a[0];
		int lastCount = 0;

		for (int i = 0 ; i < a.length ; i++) {
			int count = 0;
			for (int j = 0 ; j < a.length ; j++) {
				if (a[j] == a[i]) {
					count++;
				}
			}
			if (count > lastCount) {
				lastCount = count;
				max = a[i];
			}
		}

		return max;
	}

	private static double standardDeviation(int[] a) {
		double sum = 0;
		double mean = mean(a);

		for (int i = 0 ; i < a.length ; i++) {
			sum += Math.pow(mean - a[i], 2);
		}

		sum /= a.length - 1;

		return Math.sqrt(sum);
	}
}