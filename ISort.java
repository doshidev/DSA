public class ISort {
    public static void main(String[] args) {
        test(new int[] {14, 11, 1, 3, 8, 5, 13}, new int[] {1, 3, 5, 8, 11, 13, 14});
        test(new int[] {13}, new int[] {13});
        test(new int[] {}, new int[] {});
        test(new int[] {1, 2, 3, 4, 5, 6}, new int[] {1, 2, 3, 4, 5, 6});
        test(new int[] {10, 9 , 8, 7, 6, 5}, new int[] {5, 6, 7, 8, 9, 10});
    }

    public static void test(int[] source, int[] expectedResult) {
        Helper.printArray(source);
        sortAscending(source);
        Helper.printArray(source);
        System.out.println(Helper.matchArray(source, expectedResult));
        System.out.println();
    }

    public static void sortAscending(int[] source) {
        if(source.length <= 1) return;
        for (int i = 1; i < source.length; i++) {
            int key = source[i];
            int j = i;
            while (j > 0 && key < source[j - 1]) {
                source[j] = source[j - 1];
                j--;
            }
            source[j] = key;
        }
    }

}
