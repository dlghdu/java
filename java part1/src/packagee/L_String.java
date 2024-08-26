package packagee;

public class L_String {

    public static void exam1() {
        String str = "Hello";
        for (int i =0; i < str.length(); ++i) {
            char c = str.charAt(i);
            System.out.println(c);
        }
    }

    public static void exam2() {
        String str = "Hello";
        String sub = str.substring(0, 3);
        System.out.println(sub);

        String aa = "12344321";
        String y = aa.substring(0, 4);
        String m = aa.substring(4, 6);
        String d = aa.substring(6, 8);
        System.out.println(y);
        System.out.println(m);
        System.out.println(d);
    }

    public static void exam3() {
        String str = "one two three four five six";
        String[] strss = str.split(" ");
        System.out.println(strss[0]);
        System.out.println(strss[1]);
        System.out.println(strss[2]);
        System.out.println(strss[3]);
        System.out.println(strss[4]);
        System.out.println(strss[5]);
    }

    public static void exam4() {
        String str = "Hello";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    public static void exam5() {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "def";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
    }

    public static void exam6() {
        String str = "Hello World!";
        boolean result = str.contains("World");
        System.out.println(result);
    }

    public static void exam7() {
        String str = "Hello";
        String newStr = str.replace('l', 'p');
        System.out.println(newStr);
    }

    public static void exam8() {
        String str = "Hello";
        int idx = str.indexOf("1");
        System.out.println(idx);
        idx = str.lastIndexOf("1");
        System.out.println(idx);
    }

    public static void exam9() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append("World");
        String result = sb.toString();
        System.out.println(result);
    }

    public static void exam10() {
        String str = "Hello";
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        System.out.println(reversed);

        System.out.println(new StringBuilder(str).reverse());
    }

    public static void exam11() {
        String str1 = "apple";
        String str2 = "banana";
        int result = str1.compareTo(str2);
        System.out.println(result);
    }

    public static void exam12() {
        String str = "Hello World!";
        String lower = str.toLowerCase();
        String upper = str.toUpperCase();
        System.out.println(lower);
        System.out.println(upper);
    }

    public static void main(String[] args) {
        exam12();

    }
}
