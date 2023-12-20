package striver_atoz_dsa.array;

public class BuyChocolatesLC2706 {

    public static void main(String[] args) {
        int[] prices = {41, 1, 28, 2, 92, 97, 1, 87};
        int money = 68;
        int[] prices1 = {1,2,2};
        int money1 = 3;
        int leftOverMoney = buyChoco(prices1, money1);
        System.out.println("LeftOverMoney :: " + leftOverMoney);
    }

    public static int buyChoco(int[] prices, int money) {

        int size = prices.length;

        if (size < 2) return money;

        int priceOne = Integer.MAX_VALUE;
        int priceTwo = Integer.MAX_VALUE;
        int p1Occ = -1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < priceOne) {
                priceTwo = priceOne;
                p1Occ = i;
                priceOne = prices[i];
            } else if (prices[i] < priceTwo) {
                int tmp = Integer.min(priceTwo, prices[i]);
                if (i!=p1Occ || tmp!=priceOne) {
                    priceTwo = tmp;
                }
            }
        }

//        for (int i = 0; i < prices.length; i++) {
//            int tmp = Integer.min(priceTwo, prices[i]);
//            if (i!=p1Occ || tmp!=priceOne) {
//                priceTwo = tmp;
//            }
//        }

        System.out.println("p1 "+priceOne+", p2 "+priceTwo);
        return priceOne+priceTwo <= money ? money - (priceOne+priceTwo) : money;
    }

    public static int buyChoco1(int[] prices, int money) {

        int size = prices.length;

        if (size < 2) return money;

        int priceOne = Integer.MAX_VALUE;
        int priceTwo = Integer.MAX_VALUE;
        int p1Occ = -1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < priceOne) {
                priceTwo = priceOne;
                priceOne = prices[i];
                p1Occ = i;
            } else if (prices[i] < priceTwo && i != p1Occ) {
                priceTwo = prices[i];
            }
        }

        return priceOne+priceTwo <= money ? money - (priceOne+priceTwo) : money;
    }
}
