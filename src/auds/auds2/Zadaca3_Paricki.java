package auds.auds2;
/*
Дадени се парички со одредена вредност
(постојат парички од 50, 10, 5, 2 и 1 денар), и
притоа бројот на парички од секоја вредност е
неограничен. За дадена сума да се определи
најмалиот број на парички кои се потребни да
се формира таа сума.
*/
public class Zadaca3_Paricki {
    static class Greedy {
        void sortiraj_paricki(int[] coins, int n) {
            int i, j, tmp;
            for (i = 0; i < n; i++) {
                for (j = i + 1; j < n; j++) {
                    if (coins[i] < coins[j]) {
                        tmp = coins[i];
                        coins[i] = coins[j];
                        coins[j] = tmp;
                    }
                }
            }
        }
        // coins e niza so vrednostite na parickite koi se dadeni
        // n e brojot na paricki
        // sum e dadenata suma
        // coinsNum e niza za resenieto so brojot na paricki od sekoja golemina na paricka
        int greedyCoins(int[] coins, int n, int sum, int[] coinsNum) {
            sortiraj_paricki(coins, n);
            int i = 0;
            int br = 0; // vkupniot broj na paricki za da se formira dadenata suma
            while (sum > 0) {
                coinsNum[i] = sum / coins[i];
                sum -= coinsNum[i] * coins[i];
                br += coinsNum[i];
                i++;
            }

            while (i < n) {
                coinsNum[i] = 0;
                i++;
            }
            return br;
        }
    }
}
