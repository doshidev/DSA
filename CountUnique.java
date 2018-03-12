import java.util.Arrays;

/**
 * Created by ddoshi on 3/12/18.
 */
public class CountUnique {

    public static void main(String[] args) {
        System.out.println(count(new int[] {0,0,0,0}));
        System.out.println(count(new int[] {0,1,0,1}));
        System.out.println(count(new int[] {1,2,3,4}));
        System.out.println(count(new int[] {0}));


    }



    public static int count(int[] circles){



        // Count unique circles
        Arrays.sort(circles);
        int unique = 1;
        int current = circles[0];
        for(int i = 1; i < circles.length; i++){
            if(circles[i] != current) {
                current = circles[i];
                unique++;
            }
        }
        return unique;
    }
}
