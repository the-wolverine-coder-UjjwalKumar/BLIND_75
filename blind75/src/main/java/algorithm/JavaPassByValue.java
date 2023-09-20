package algorithm;

public class JavaPassByValue {
    static class CustomInteger {
        public int value;
        public CustomInteger(int value) {this.value = value;}
        public int getValue() {return this.value;}
    }
    public static void main(String[] args) {
        int a = 10;
        Integer b = 20;
        CustomInteger customInteger = new CustomInteger(30);
        int[] mutableDs = new int[]{0};

        modifyParams(a, b, customInteger, mutableDs);

//        In Java, all arguments, including object references, are passed by value.
//        When you pass an object reference as an argument to a method,
//        you are passing a copy of that reference, not the actual reference itself.
//        This means that changes to the object's state (i.e., modifying its fields or properties)
//        through that reference are reflected in the original object because both the original reference
//        and the copied reference still point to the same object in memory.
//        However, you cannot change what object the reference points to within the method.

        System.out.println("Inside main method :: ");

        System.out.println("primitive a : "+a);
        System.out.println("Wrapper Integer b: "+b);
        System.out.println("CustomInteger c: "+ customInteger.getValue());
        System.out.println("Mutable DS int d: "+mutableDs[0]);
    }

    private static void modifyParams(int a, Integer b, CustomInteger customInteger, int[] mutableDs) {
        a = 60;
        b = 70;
        customInteger.value = 90;
        mutableDs[0] = 100;

        System.out.println("Inside modifyParams method :: ");
        System.out.println("primitive a : "+a);
        System.out.println("Wrapper Integer b: "+b);
        System.out.println("CustomInteger c: "+ customInteger.getValue());
        System.out.println("Mutable DS int d: "+mutableDs[0]);
        System.out.println();

    }
}
