public class Helper {
    public static void printArray(int[] intArray) {
        System.out.print("[");
        for(int i = 0; i < intArray.length; i++){
            if(i == 0) {
                System.out.print(intArray[i]);
            } else {
                System.out.print("\t" + intArray[i]);
            }

        }
        System.out.println("]");
    }


    public static boolean matchArray(int[] a, int[] b) {
        if(a.length != b.length) return false;
        if(a.length <= 0 && b.length <= 0) return true;
        for (int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}
