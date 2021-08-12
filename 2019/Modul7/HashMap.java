package Modul7;

public class HashMap {

//    public static void main(String[]args){
//        MyHashMap map = new MyHashMap();
//        map.put()
//        System.out.println(hashCodeForString("Test"));
//        System.out.println(args.hashCode());
//
//    }


    public static void main(String[] args) {
        createHashCode("tod");
        System.out.println(compressHashCode("tod"));
        System.out.println(compressHashCode("dot"));
        System.out.println(createHashCode("tod"));
        System.out.println(createHashCode("dot"));
        System.out.println(hashCodeForString("tod"));
        System.out.println(hashCodeForString("dot"));

    }
    public static long hashCodeForString(String s){ //polynomial Hashcode
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = hash*31 + s.charAt(i);
        }
        return hash;
    }

    private static long createHashCode(String s){ //position in memory hashcode
        return s.hashCode();
    }

    private static long compressHashCode(String s){
        long N = (long)Math.pow(2,2);
        long index = createHashCode(s) % N;
        return index;
    }


}
