package Task1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;

        int[][] arr = new int[rows][columns];
        Random random = new Random();

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = (int) (Math.random() * ((100 - 0) + 1)) + 0;
            }
        }

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.println(arr[row][col]);
            }
        }

        System.out.println("----------------------------------");

        int maxValue = arr[0][0];
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[j].length; i++) {
                if (arr[j][i] > maxValue) {
                    maxValue = arr[j][i];
                }
            }
        }
        System.out.println(maxValue);

        System.out.println("----------------------------------");

        int minValue = arr[0][0];
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[j].length; i++) {
                if (arr[j][i] < minValue) {
                    minValue = arr[j][i];
                }
            }
        }
        System.out.println(minValue);

        System.out.println("----------------------------------");


        int counter=0;
        double sum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                sum = sum+arr[i][j];
                counter++;
            }
        }
        double average = sum / counter;

        System.out.println(average);


    }
}
