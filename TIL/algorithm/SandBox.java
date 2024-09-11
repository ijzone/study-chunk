public class SandBox {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        var str = "a: ";
//        for (int i = 0; i < 100000; i++) {
//            if (i < 99999)
//                str += i + ", ";
//            else
//                str += i;
//        }
//        System.out.println("str = " + str);
        StringBuilder sb = new StringBuilder("b: ");
        for (int i = 0; i < 100000; i++) {
            if (i < 99999) {
                sb.append(i);
                sb.append(", ");
            }else
                sb.append(i);

        }
        System.out.println("sb = " + sb);
        long end = System.currentTimeMillis();
        System.out.println("TIME CONSUMPTION: " + (end - start) / 1000);
    }
}
