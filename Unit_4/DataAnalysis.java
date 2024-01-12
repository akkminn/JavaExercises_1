import java.util.ArrayList;
import java.text.DecimalFormat;

public class DataAnalysis {

    public static void main(String[] args) {

        // Create a new array for stockPrices
        float[] stockPricesArray = new float[1000];
        // Create a new ArrayList for stockPrices
        ArrayList<Float> stockPricesArrayList = new ArrayList<>();
        // Create random prices
        
        // Add stockPrices to the array and ArrayList
        for (int i = 0; i < 1000; i++) {
            float price = (float) Math.random() * 100;
            // Round the pirce to two decimal places
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            float roundedPrice = Float.parseFloat(decimalFormat.format(price));
            stockPricesArray[i] = roundedPrice;
            stockPricesArrayList.add(roundedPrice);
            
        }

        // Measure time for calculating the average price with array
        long arrayStartTime = System.nanoTime();
        float averagePriceArray = calculateAveragePriceArray(stockPricesArray);
        long arrayEndTime = System.nanoTime();
        double arrayTime = arrayEndTime - arrayStartTime;
        
        System.out.printf("The average price with array is %.2f \n", averagePriceArray);
        System.out.println("Time taken by array (nanoseconds): " + arrayTime);
        
        // Measure time for calculating the average price with arrayList
        long arrayListStartTime = System.nanoTime();
        float averagePriceArrayList = calculateAveragePriceArrayList(stockPricesArrayList);
        long arrayListEndTime = System.nanoTime();
        double arrayListTime = arrayListEndTime - arrayListStartTime;

        System.out.printf("The average price with arrayList is %.2f \n", averagePriceArrayList);
        System.out.println("Time taken by arrayList (nanoseconds): " + arrayListTime);
       
        printDashes();

        // Measure time for finding the maximum price in an array
        arrayStartTime = System.nanoTime();
        float maxPriceArray = findMaximumPriceArray(stockPricesArray);
        arrayEndTime = System.nanoTime();
        arrayTime = arrayEndTime - arrayStartTime;
        
        System.out.printf("The maximum price in array is %.2f \n", maxPriceArray);
        System.out.println("Time taken by array (nanoseconds): " + arrayTime);
        
        // Measure time for finding the maximum price in an arrayList
        arrayListStartTime = System.nanoTime();
        float maxPriceArrayList = findMaximumPriceArrayList(stockPricesArrayList);
        arrayListEndTime = System.nanoTime();
        arrayListTime = arrayListEndTime - arrayListStartTime;

        System.out.printf("The maximum price in arrayList is %.2f \n", maxPriceArrayList);
        System.out.println("Time taken by arrayList (nanoseconds): " + arrayListTime);

        printDashes();

        // Initialize the target price
        float targetPrice = 22.1f;
        // Find the target price in an array
        int countOccuranceArray = countOccurancesArray(stockPricesArray, targetPrice);
        System.out.printf("The count occurance of price in an array is %d \n", countOccuranceArray);
        
        // Find the target price in an arrayList
        int countOccurancesArrayList = countOccurancesArrayList(stockPricesArrayList, targetPrice);
        System.out.printf("The count occurance of price in an arrayList is %d \n", countOccurancesArrayList);
       
        printDashes();

        // Find the toal sum
        ArrayList<Float> sumList = computeCumlativeSum(stockPricesArrayList);
        float totalPrice = sumList.get(sumList.size()-1);
        System.out.printf("The total price of the stock is %.2f", totalPrice);

    }

    /**
     * Create a static method called calculateAveragePriceArray, 
     * that takes the array of stock prices as input and 
     * returns the average price of the stocks.
     */
    private static float calculateAveragePriceArray(float[] stockPrizes) {

        // Inatialize variables
        float totalPrice = 0.0f;   
        int length = stockPrizes.length;

        // Use for loop to traversal the stockPrices array
        for (float price: stockPrizes) {
            totalPrice += price;
        }

        return totalPrice / length;
    }

    /**
     * Create a static method called calculateAveragePriceArrayList, 
     * that takes the ArrayList of stock prices as input and 
     * returns the average price of the stocks.
     */
    private static float calculateAveragePriceArrayList(ArrayList<Float> stockPrizes) {

        // Inatialize variables
        float totalPrice = 0.0f;   
        int length = stockPrizes.size();

        // Use for loop to traversal the stockPrices arrayList
        for (float price: stockPrizes) {
            totalPrice += price;
        }

        return totalPrice / length;
    }

    /**
     * Create a static method called findMaximumPriceArray, 
     * that takes the array of stock prices as input
     * and returns the maximum price among all the stocks.
     */
    private static float findMaximumPriceArray(float[] stockPrices) {
        
        // Inatialize variable
        float maxPrice = 0.0f;

        // Use for loop to traversal the stockPrices array
        for (int i = 0; i < stockPrices.length; i++) {
            // Check if the price is greater than maxPrice
            if (stockPrices[i] > maxPrice) {
                // If so, store the price in maxPrice
                maxPrice = stockPrices[i];
            }
        }
        return maxPrice;
    }

    /**
     * Create a static method called findMaximumPriceArrayList, 
     * that takes the arrayList of stock prices as input 
     * and returns the maximum price among all the stocks.
     */
    private static float findMaximumPriceArrayList(ArrayList<Float> stockPrices) {
        
        // Inatialize variable
        float maxPrice = 0.0f;

        // Use for loop to traversal the stockPrices arrayList
        for (int i = 0; i < stockPrices.size(); i++) {
            // Check if the price is greater than maxPrice
            if (stockPrices.get(i) > maxPrice) {
                // If so, store the price in maxPrice
                maxPrice = stockPrices.get(i);
            }
        }
        return maxPrice;
    }

    /**
     * Create a static method called countOccurrencesArray, that takes 
     * the array of stock prices and a target price as input and returns 
     * the number of times the target price occurs in the array.
     */
    private static int countOccurancesArray(float[] stockPrices, float targetPrice) {

        // Inatialize variable
        int count = 0;
        // Use for loop to traversal the stockPrices array
        for (float price:stockPrices) {
            // Check if the price is equal to the targetPrice
            if (price == targetPrice)
                // If so, increment the count by 1
                count++;
        }
        return count;
    }

    /**
     * Create a static method called countOccurrencesArrayList, that takes 
     * the arrayList of stock prices and a target price as input and returns 
     * the number of times the target price occurs in the arrayList.
     */
    private static int countOccurancesArrayList(ArrayList<Float> stockPrices, float targetPrice) {

        // Inatialize variable
        int count = 0;
        // Use for loop to traversal the stockPrices arrayList
        for (float price:stockPrices) {
            // Check if the price is equal to the targetPrice
            if (price == targetPrice)
                // If so, increment the count by 1
                count++;
        }
        return count;
    }

    /**
     * Create a static method called computeCumulativeSum, that takes 
     * the ArrayList of stock prices as input and returns a new ArrayList
     * containing the cumulative sum of prices at each position.
     */
    private static ArrayList<Float> computeCumlativeSum(ArrayList<Float> stockPrices) {

        // Creat a new arrayList
        ArrayList<Float> cumlativeSumArrayList = new ArrayList<>();
        float cumulativeSum = 0.0f;
        // Use for loop to traversal the stockPrices arrayList
        for (float price: stockPrices) {
            cumulativeSum += price;
            cumlativeSumArrayList.add(cumulativeSum);
        }
        return cumlativeSumArrayList;
    }

    /**
     * Create a dash-line
     */
    private static void printDashes() {
        for (int i = 0; i < 50; i++) {
                System.out.print("-");
            }
        System.out.println();
    }
}