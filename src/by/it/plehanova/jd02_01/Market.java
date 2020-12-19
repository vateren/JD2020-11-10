package by.it.plehanova.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();

        int n = 0;
        for (int t = 1; t <= 120; t++) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++n);
                if (n % 4 == 0) {
                    buyer.setPensioner(true);
                }
                buyers.add(buyer);
                buyer.start();
            }
            //System.out.println("Buyers in Market " + Dispatcher.getBuyersInMarket());
            Helper.sleep(1000);
        }
        try {
            for (Buyer buyer : buyers) {
                buyer.join();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Market closed");

    }
}

