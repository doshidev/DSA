public class SecondMax {
    static void main(String[] args) {
        test(new int[]{1,2,3,4,5,6,7});
        test(new int[]{});
        test(new int[]{1});
        test(new int[]{9,9,9});
    }


    static int findSecondMax(int[] input) {
        if(input.length < 2) return -1;
        int max = input[0];
        int secondMax = 0;
        for (int i = 1; i < input.length; i++) {
            if(input[i] >= max) {
                secondMax = max;
                max = input[i];
            }
        }
        return secondMax;
    }


    static void test(int[] input) {
        printArray(input);
        System.out.println("2nd Max: " + findSecondMax(input));
        System.out.println();
    }

    //Print integer array
    public static void printArray(int[] array) {
        for(int i=0; i < array.length; i++) {
            if(array[i] >0)
                System.out.print(array[i] + " ");
        }
        System.out.println();
    } // End printArray
}
