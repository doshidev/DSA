public class SecondMax {
    public static void main(String[] args) {
        test(new int[]{1,2,3,4,5,6,7}, 6, false);
        test(new int[]{}, -1, true);
        test(new int[]{1}, -1, true);
        test(new int[]{9,9,9}, 9, false);
        test(new int[]{8,11,27}, 11, false);
        test(new int[]{11,23}, 11, false);
        test(new int[]{23,11}, 11, false);
        test(new int[]{23,23}, -1, true);
    }


    static int findSecondMax(int[] input) {
        if(input.length < 2) throw new IllegalArgumentException("Invalid Input");

        int max = input[0], secondMax = 0;

        boolean found = false;

        for (int i = 1; i < input.length; i++) {
            if(input[i] > max) {
                secondMax = max;
                found = true;
                max = input[i];
            } else if(!found && input[i] < max) {
                secondMax = input[i];
                found = true;
            }
        }
        if(!found) throw new IllegalArgumentException("No Second Max");
        return secondMax;
    }


    static void test(int[] input, int expectedResult, boolean shouldThrow) {
        printArray(input);
        try{
            int result = findSecondMax(input);
            System.out.println("2nd Max: " + result + " " + (expectedResult == result && !shouldThrow));
        } catch(IllegalArgumentException ex) {
            System.out.println("2nd Max: Exception " + " " + shouldThrow);
        }
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
