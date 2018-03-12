public class RelativePath {
    public static void main(String[] args) {
        test("/F1/F2/", "/F1/F3", "../F3");
        test("/F1/F2", "/F1/F2/F3", "F3");
        test("/F1", "/F1", ".");
        test("/F1/F2", "/F2/F3", "<NO PATH>");
        test("/", "/", ".");
        test("", "", "ERROR!");
        test("F1 F2", "F2 F3", "ERROR!");

    }


    public static void test (String pathSrc, String pathDest, String expectedResult) {
        String result = relativePath(pathSrc, pathDest);
        System.out.println(pathSrc);
        System.out.println(pathDest);
        System.out.println(result);
        System.out.println(result.equals(expectedResult));
        System.out.println();
    }

    public static String relativePath(String src, String dest) {
        if(src.length() <= 0 || dest.length() <= 0) return "ERROR!";
        if(src.equals(dest)) return ".";

        String[] srcToken = src.split("/");
        String[] destToken = dest.split("/");

        //Cases where there are no slashes in the path
        if(srcToken.length <= 1 || destToken.length <= 1) return "ERROR!";

        int size = Math.min(srcToken.length, destToken.length);

        // Find out prefix
        int prefix = -1;
        for (int i = 0; i < size; i++) {
            if(srcToken[i].equals(destToken[i])) {
                prefix = i;
            } else {
                break;
            }
        }

        if(prefix < 1) return "<NO PATH>";
        String result = "";

        // For all levels in source path that does not match, add ../
        for (int i = prefix + 1; i < srcToken.length; i++) {
            result += "../";
        }

        for (int i = prefix + 1; i < destToken.length; i++) {
            result += destToken[i];
        }

        return result;
    }

}
