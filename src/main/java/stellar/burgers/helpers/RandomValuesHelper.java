package stellar.burgers.helpers;

import java.util.Random;

public class RandomValuesHelper {

    public static String generateRandomValueToMakeEmailUnique() {
        Random rand = new Random(); //instance of random class
        int upperbound = 9999;
        //generate random values from 0-9999
        int intRandom = rand.nextInt(upperbound);
        return String.valueOf(intRandom);
    }

}
