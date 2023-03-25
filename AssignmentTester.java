package lab06;

import java.util.Arrays;

public class AssignmentTester {
    public static void main(String[] args) {
        String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("sample_word_list.txt: " + Arrays.toString(s3));
        String[] empty = AnagramUtil.getLargestAnagramGroup("empty_list.txt");
        System.out.println("Empty file: " + Arrays.toString(empty));
        String[] oneWordFile = AnagramUtil.getLargestAnagramGroup("one_word_list.txt");
        System.out.println("One word file: " + Arrays.toString(oneWordFile));
        String[] twoWordsFileWithAnagrams = AnagramUtil.getLargestAnagramGroup("two_words_list_with_anagrams.txt");
        System.out.println("Two words file with anagrams: " + Arrays.toString(twoWordsFileWithAnagrams));
        String[] twoWordsFileWithoutAnagrams = AnagramUtil
                .getLargestAnagramGroup("two_words_list_without_anagrams.txt");
        System.out.println("Two words file without anagrams: " + Arrays.toString(twoWordsFileWithoutAnagrams));
        String[] noAnagramsFile = AnagramUtil.getLargestAnagramGroup("no_anagrams_list.txt");
        System.out.println("No anagrams file: " + Arrays.toString(noAnagramsFile));
        String[] anagramsInTheMiddle = AnagramUtil.getLargestAnagramGroup("anagrams_in_the_middle_list.txt");
        System.out.println("Anagrams in the middle of the file: " + Arrays.toString(anagramsInTheMiddle));
        String[] anagramsAtTheEnd = AnagramUtil.getLargestAnagramGroup("anagrams_at_the_end_list.txt");
        System.out.println("Anagrams at the end of the file: " + Arrays.toString(anagramsAtTheEnd));

        System.out.println("----------------------------------------");

        MergeSort<Integer> intMS = new MergeSort<Integer>();
        Integer[] zero = {};
        Integer[] one = { 1 };
        Integer[] two = { 8, 7 };
        Integer[] alreadySorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Integer[] random = new Integer[10];
        for (int i = 0; i < random.length; i++) {
            random[i] = (int) (Math.random() * 100);
        }

        Integer[] sortedInts = intMS.sort(zero);
        System.out.println("Sorted Zero: " + Arrays.toString(sortedInts));

        sortedInts = intMS.sort(one);
        System.out.println("Sorted One: " + Arrays.toString(sortedInts));

        sortedInts = intMS.sort(two);
        System.out.println("Sorted Two: " + Arrays.toString(sortedInts));

        sortedInts = intMS.sort(alreadySorted);
        System.out.println("Sorted alreadySorted: " + Arrays.toString(sortedInts));

        sortedInts = intMS.sort(random);
        System.out.println("Sorted Random: " + Arrays.toString(sortedInts));

        System.out.println("----------------------------------------");

        Integer[] tenElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        intMS.fit(tenElements);
        System.out.println(
                "It will take " + intMS.predict(10) + " microseconds to sort an array of 10 elements");

        long start = System.nanoTime();
        intMS.sort(tenElements);
        long end = System.nanoTime();
        System.out.println("Actual execution time to sort an array of 10 elements: " + (end - start) / 1000.0);

        System.out.println("****************************************");
        intMS.fit(random);

        System.out.println(
                "It will take " + intMS.predict(1000000) + " microseconds to sort an array of 100000 elements");

        Integer[] longRandom = new Integer[100000];
        for (int i = 0; i < longRandom.length; i++) {
            longRandom[i] = (int) (Math.random() * 1000000000);
        }
        start = System.nanoTime();
        intMS.sort(longRandom);
        end = System.nanoTime();
        System.out.println("Actual execution time to sort an array of 100000 elements: " + (end - start) / 1000.0);
    }
}
