package lab06;

public class Tester {

	public static void main(String[] args) {
		SortedString zeb = new SortedString("zebra");
		System.out.println("SprtedString zebra" + zeb);

		SortedString joy = new SortedString("joy");
		SortedString ski = new SortedString("ski");
		SortedString bel = new SortedString("below");
		SortedString Elb = new SortedString("Elbow");
		SortedString elb = new SortedString("elbow");

		System.out.println("joy.compareTo(ski): " + joy.compareTo(ski));
		System.out.println("bel.compareTo(Elbow): " + bel.compareTo(Elb));
		System.out.println("bel.compareTo(elbow): " + bel.compareTo(elb));
		System.out.println("zeb.compareTo(ski): " + zeb.compareTo(ski));

		System.out.println("----------------------------------------");

		SortedString empty = new SortedString("");
		System.out.println("AnagramUtil.areAnagrams( , zebra)" + AnagramUtil.areAnagrams(empty, zeb));
		System.out.println("AnagramUtil.areAnagrams(zebra ,zebra)" + AnagramUtil.areAnagrams(zeb, zeb));
		System.out.println("AnagramUtil.areAnagrams(below ,elbow)" + AnagramUtil.areAnagrams(bel, elb));
		System.out.println("AnagramUtil.areAnagrams(zebra ,elbow)" + AnagramUtil.areAnagrams(zeb, elb));
		System.out.println("AnagramUtil.areAnagrams(below ,Elbow)" + AnagramUtil.areAnagrams(bel, Elb));

		System.out.println("----------------------------------------");

		InsertionSort<Integer> intIS = new InsertionSort<Integer>();
		Integer[] one = { 1 };
		Integer[] two = { 8, 7 };
		Integer[] alreadySorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer[] random = new Integer[10];
		for (int i = 0; i < random.length; i++) {
			random[i] = (int) (Math.random() * 100);
		}

		Integer[] sortedInts = intIS.sort(one);
		String str = "[";
		for (Integer i : sortedInts) {
			str += i + " ";
		}
		str += "]";
		System.out.println("Sorted One: " + str);

		sortedInts = intIS.sort(two);
		str = "[";
		for (Integer i : sortedInts) {
			str += i + " ";
		}
		str += "]";
		System.out.println("Sorted Two: " + str);

		sortedInts = intIS.sort(alreadySorted);
		str = "[";
		for (Integer i : sortedInts) {
			str += i + " ";
		}
		str += "]";
		System.out.println("Sorted alreadySorted: " + str);

		sortedInts = intIS.sort(random);
		str = "[";
		for (Integer i : sortedInts) {
			str += i + " ";
		}
		str += "]";
		System.out.println("Sorted Random: " + str);

		System.out.println("----------------------------------------");

		InsertionSort<SortedString> ssIS = new InsertionSort<SortedString>();
		String[] strArr = { "joy, ski, fed, cat" };
		SortedString[] sortStrArr = SortedString.toSortedString(strArr);
		SortedString[] sortedSS = ssIS.sort(sortStrArr);
		str = "[";
		for (SortedString i : sortedSS) {
			str += i.getUnsorted() + " ";
		}
		str += "]";
		System.out.println("Sorted Sorted Strings: " + str);

		System.out.println("----------------------------------------");

		intIS.fit(random);
		;
		System.out.println(
				"It will take " + intIS.predict(1000000) + " microseconds to sort an array of 100000 elements");

		Integer[] longRandom = new Integer[100000];
		for (int i = 0; i < longRandom.length; i++) {
			longRandom[i] = (int) (Math.random() * 1000000000);
		}
		long start = System.nanoTime();
		intIS.sort(longRandom);
		long end = System.nanoTime();
		System.out.println((end - start) / 1000.0);

	}

}
