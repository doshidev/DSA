public class SieveGoldbach {
    public static void main(String[] args)  {
        int[] array = new int[10000];
        sieve(array);

        System.out.println("Prime as per the sieve of eratosthenes");
        printArray(array);
        System.out.println();

        goldbach(array);
    } // End Main


    // The Sieve of Eratosthenes
    public static void sieve(int[] array) {
        //Initialize the array
        array[0] = 0;
        array[1] = 0;
        for(int i=2; i < array.length; i++) {
            array[i] = i;
        }

        //Find Composites and make them zero
        int j = (int)Math.sqrt(array.length)+1;
        for(int i=2; i < j; i++){
            if(array[i] > 0){
                for(int k = i+i; k < array.length; k+=i) {
                    array[k] = 0;
                }
            }
        }
    } // End sieve


    // Goldbach's Conjecture
    public static void goldbach(int[] array) {
        System.out.println("Goldbach's Conjecture");
        for(int i=4; i < array.length; i+=2) {
            for(int j = 2; j < i; j++){
                if(i == array[j] + (array[i-j])) {
                    System.out.println(i + " = " + j + " + " + (i-j));
                    break;
                }
            }
        }
    } // End goldbach


    //Print integer array
    public static void printArray(int[] array) {
        for(int i=0; i < array.length; i++) {
            if(array[i] >0)
                System.out.println(array[i]);
        }
    } // End printArray

} // End SieveGoldbach