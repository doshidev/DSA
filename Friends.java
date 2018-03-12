import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ddoshi on 3/12/18.
 */
public class Friends {

    /*
     * Complete the function below.
     */
    static int friendCircles(String[] friends) {
        if(friends.length == 0) return 0;
        int count = friends.length;
        int[] circles = new int[count];
        // initialize all circles to self
        for(int i = 0; i < count; i++) {
            circles[i] = i;
        }

        // loop through the string and find circles
        for(int i = 0; i < count; i++) {
            for(int j = i + 1; j < count; j++) {
                if(friends[i].charAt(j) == 'Y') {
                    int iRoot = findRoot(circles, i); // 0
                    int jRoot = findRoot(circles, j); // 3
                    if(iRoot < jRoot) {
                        circles[j] = iRoot;
                    }
                    if(jRoot < iRoot) {
                        circles[i] = jRoot;
                    }
                }
            }
        }

        for(int i = 0; i < circles.length; i++) {
            findRoot(circles, i);
        }

        // Count unique circles
        Arrays.sort(circles);

        int unique = 1;
        int current = circles[0];
        for(int i = 1; i < count; i++){
            if(circles[i] != current) {
                current = circles[i];
                unique++;
            }
        }
        return unique;

    }

    static int findRoot(int[] circles, int i) {
        if(circles[i] != i) {
            circles[i] = findRoot(circles, circles[i]);
        }
        return circles[i];
    }


    public static void main(String[] args) {
        HashSet<Integer>[] sets = new HashSet[6];

    }
}
