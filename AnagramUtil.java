package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AnagramUtil {

    // Reads words from a file (assumed to contain one word per line)
    // Returns the words as an array of strings.
    public static SortedString[] readFile(String filename) {
        ArrayList<SortedString> results = new ArrayList<SortedString>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            while (input.ready()) {
                results.add(new SortedString(input.readLine()));
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SortedString[] retval = new SortedString[1];
        return results.toArray(retval);
    }

    public static String[] getLargestAnagramGroup(String filename) {
        SortedString[] words = readFile(filename);
        String[] toReturn = getLargestAnagramGroup(words);
        return toReturn;
    }

    public static String[] getLargestAnagramGroup(SortedString[] stringList) {

        /*
         * Initialize a sorting algorithm of type SortedString using either MergeSort or
         * InsertionSort
         */
        MergeSort<SortedString> sortingAlgorithm = new MergeSort<>();

        /* sort the input string list */
        stringList = sortingAlgorithm.sort(stringList);

        /* The case where stringList is of size 1 or less */

        if (stringList.length <= 1) {
            return new String[0];
        }

        /* The variables for the logic following */
        int end = 0, length = 1, i = 0, maxLength = 0;
        /*
         * Loop through stringList.
         * 
         * If stringList[i] and stringList[i + 1] are anagrams, increment the length of
         * this anagram group.
         * 
         * Otherwise, check to see if the length of this anagram group is longer than
         * the currently known maximum group length. Update variables accordingly (see
         * end, length, i, and MaxLength).
         * 
         */

        for (; i < stringList.length - 1; i++) {

            /*
             * If the current string is anagrams, increment the length of this anagram
             * group.
             */
            if (stringList[i].compareTo(stringList[i + 1]) == 0) {
                length++;
            } else {
                /*
                 * If the current string is not anagrams, check to see if the length of
                 * this anagram group is longer than the currently known maximum group
                 * length.
                 */
                if (length > maxLength) {
                    maxLength = length;
                    end = i;
                }
                length = 1;
            }
        }

        /*
         * Don't forget one last check for the end: if the longest list is the last
         * group. As before, update variables accordingly.
         */
        if (length > maxLength) {
            maxLength = length;
            end = stringList.length - 1;
        }

        // if end of anagram group is 0, then there are no anagrams
        if (end == 0) {
            return new String[0];
        }

        /*
         * Prepare to return. The following is almost the answer except for one thing...
         */
        String[] toReturn = new String[maxLength];
        for (int j = 0; j < maxLength; j++) {

            toReturn[j] = stringList[j + end - maxLength + 1].getUnsorted();

        }
        return toReturn; // return the right thing
    }

    public static boolean areAnagrams(SortedString str1, SortedString str2) {

        return str1.compareTo(str2) == 0;
    }

}
