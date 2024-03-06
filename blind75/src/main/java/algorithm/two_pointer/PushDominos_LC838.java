package algorithm.two_pointer;

import java.util.Arrays;

public class PushDominos_LC838 {
    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        String ans = getFinalState(dominoes);
        System.out.println(ans);
    }

    private static String getFinalState(String dominoes) {
        int n = dominoes.length();

        int[] leftForces = new int[n];
        int[] rightForces = new int[n];

        for (int i = 0; i < n; i++) {
            // fill right
            if (dominoes.charAt(i) == 'R') {
                rightForces[i] = i;
            } else {
                rightForces[i] = -1;
            }

            if (dominoes.charAt(n - i - 1) == 'L') {
                leftForces[n - i - 1] = n - i - 1;
            } else {
                leftForces[n - i - 1] = -1;
            }
        }

        System.out.println("Left arr :: " + Arrays.toString(leftForces));
        System.out.println("Right arr :: " + Arrays.toString(rightForces));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (leftForces[i] == -1 && rightForces[i] == -1)
                sb.append(".");
            else if (leftForces[i] != -1 && rightForces[i] == -1) {
                sb.append(dominoes.charAt(leftForces[i]));
            } else if (rightForces[i] != -1 && leftForces[i] == -1) {
                sb.append(dominoes.charAt(rightForces[i]));
            } else {
                int left = Math.abs(i - leftForces[i]);
                int right = Math.abs(i - rightForces[i]);

                if (left == right) {
                    if (leftForces[i] > rightForces[i]) {
                        sb.append(dominoes.charAt(rightForces[i]));
                    } else {
                        sb.append(dominoes.charAt(leftForces[i]));
                    }
                } else if (left > right) {
                    sb.append(dominoes.charAt(rightForces[i]));
                } else {
                    sb.append(dominoes.charAt(leftForces[i]));
                }
            }
        }
        return sb.toString();

    }

    public String pushDominoes(String dominoes) {
        char[] a = dominoes.toCharArray();
        for (int i = 0, L = -1, R = -1; i <= dominoes.length(); i++)
            if (i == a.length || a[i] == 'R') {
                if (R > L)//R..R, turn all to R
                    while (R < i)
                        a[R++] = 'R';
                R = i;
            } else if (a[i] == 'L')
                if (L > R || R == -1)//L..L, turn all to L
                    while (++L < i)
                        a[L] = 'L';
                else { //R...L
                    L = i;
                    for (int lo = R + 1, hi = L - 1; lo < hi; ) {//one in the middle stays '.'
                        a[lo++] = 'R';
                        a[hi--] = 'L';
                    }
                }
        return new String(a);
    }

    public String pushDominoes1(String dominoes) {
        char[] domi = dominoes.toCharArray();
        int n = dominoes.length();
        int[] forces = new int[n];

        int force = 0;
        for(int i=0; i<n; i++){
            if(domi[i] == 'R'){
                force = n;
            }else if(domi[i] == 'L'){
                force = 0;
            }else {
                force = Math.max(force-1, 0);
            }
            forces[i] += force;
        }

        force = 0;
        for(int i=n-1; i>=0; i--){
            if(domi[i] == 'L'){
                force = n;
            }else if(domi[i] == 'R'){
                force = 0;
            }else {
                force = Math.max(force-1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder result = new StringBuilder();

        for(int f : forces){
            if(f > 0){
                result.append('R');
            }else if(f < 0){
                result.append('L');
            }else{
                result.append('.');
            }
        }

        return result.toString();
    }

}
