package striver_atoz_dsa.array;

public class Patterns {
    public static void main(String[] args) {
        int row = 5, col = 5;
        printPattern1(row, col);
        System.out.println();
        printPattern2(row, col);
        System.out.println();
        printPattern3(row, col);
        System.out.println();
        printPattern4(row, col);
        System.out.println();
        printPattern5(row, col);
        System.out.println();
        printPattern6(row, col);
        System.out.println();
        printPattern7(row, col);
        System.out.println();
        printPattern8(row, col);
        System.out.println();
        printPattern9(row, col);
        System.out.println();
        printPattern10(row, col);
        System.out.println();
        printPattern11(row, col);
        System.out.println();
        printPattern12(row, col);
        System.out.println();
        printPattern14(row, col);
        System.out.println();
        printPattern15(row, col);
        System.out.println();
        printPattern16(row, col);
        System.out.println();
        printPattern17(row, col);

    }

    private static void printPattern17(int row, int col) {

        for (int i = 0; i < row; i++) {
            char currentVal = 'A';
            // print space
            for (int j = 0; j < (row-i); j++) {
                System.out.print(" ");
            }

            // print char
            char ch = 'A';
            int breakpoint = (2*i+1)/2;
            for(int j=1;j<=2*i+1;j++){

                System.out.print(ch);
                if(j <= breakpoint) ch++;
                else ch--;
            }

            // print spaces
            for (int j = 0; j < (row-i); j++) {
                System.out.print(" ");
            }

            System.out.println();

        }
    }

    private static void printPattern16(int row, int col) {
        char currentVal = 'A';
        for (int i = 0; i < row; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print((currentVal)+" ");
            }
            currentVal++;
            System.out.println();

        }
    }

    private static void printPattern15(int row, int col) {

        for (int i = 0; i < row; i++) {
            char currentVal = 'A';
            for (int j = 0; j < (row-i); j++) {
                System.out.print((currentVal++)+" ");
            }

            System.out.println();

        }
    }

    private static void printPattern14(int row, int col) {

        for (int i = 0; i < row; i++) {
            char currentVal = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print((currentVal++)+" ");
            }

            System.out.println();

        }
    }

    private static void printPattern13(int row, int col) {
        int currentVal = 1;
        for (int i = 0; i < row; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print((currentVal++)+" ");
            }

            System.out.println();

        }
    }

    private static void printPattern12(int row, int col) {
        for (int i = 0; i < row; i++) {
            int currentVal = 1;
            for (int j = 0; j<= i; j++) {
                System.out.print(currentVal);
                currentVal++;
            }

            // print spaces
            for (int j = 0; j < 2*(row-i-1); j++) {
                System.out.print(" ");
            }

            // print again number
            for (int j = 0; j <= i; j++) {
                currentVal--;
                System.out.print(currentVal);
            }

            System.out.println();

        }
    }

    private static void printPattern11(int row, int col) {
        int currentValue;

        for (int i = 0; i < row; i++) {
            if (i%2==0)
                currentValue = 1;
            else
                currentValue = 0;

            for (int k = 0; k <= i; k++) {
                System.out.print(currentValue);
                currentValue = currentValue == 1 ? 0 : 1;
            }

            System.out.println();
        }

    }

    private static void printPattern10(int row, int col) {

        for (int i = 0; i < (2*row-1); i++) {
            int j = i;
            if (i > row) j = 2*row - i;

            for (int k = 1; k < j; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    private static void printPattern9(int row, int col) {
        printPattern7(row,col);
        printPattern8(row,col);

    }

    private static void printPattern8(int row, int col) {
        // print the * in right-angled triangle
        for (int i = 0; i < row; i++) {

            // print space
            for (int space = 0; space <= i ; space++) {
                System.out.print(" ");
            }

            // print star
            for (int j = 0; j < (2*(row-i)-1) ; j++) {
                System.out.print("*");
            }

            // print after spaces
            for (int j =0; j < i; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    private static void printPattern7(int row, int col) {
        // print the * in triangle
        for (int i = 0; i < row; i++) {
            // print space
            for (int space = 0; space < (row-i) ; space++) {
                System.out.print(" ");
            }
            // print star
            for (int j = 0; j < (2*i+1) ; j++) {
                System.out.print("*");
            }

            // print after spaces
            for (int j =0; j < (row-i); j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    private static void printPattern6(int row, int col) {
        // print the * in right-angled triangle
        for (int i = 0; i < row; i++) {
            for (int j = 0; j<(col-i) ; j++) {
                System.out.print(" "+(j+1)+" ");
            }
            System.out.println();
        }
    }

    private static void printPattern5(int row, int col) {
        // print the * in right-angled triangle
        for (int i = 0; i < row; i++) {
            for (int j = col - 1 - i; j >= 0; j--) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void printPattern4(int row, int col) {
        // print the n -> 1 to n in right-angled triangle
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + (i + 1) + " ");
            }
            System.out.println();
        }
    }

    private static void printPattern3(int row, int col) {
        // print the n -> 1 to n in right-angled triangle
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + (j + 1) + " ");
            }
            System.out.println();
        }
    }

    private static void printPattern2(int row, int col) {
        // print the * in right-angled triangle
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void printPattern1(int row, int col) {
        // square matrix having * in each cell
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
