package com.itebd.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Solution 1
        int [] arr1 = new int [] {6, 4, 3, 4, 1, 7, 5, 5};

        System.out.println("Duplicate numbers: ");
        for(int i = 0; i < arr1.length; i++) {
            for(int j = i + 1; j < arr1.length; j++) {
                if(arr1[i] == arr1[j])
                    System.out.println(arr1[j]);
            }
        }

        //Solution 2
        int[] arr = new int[]{1, 3, 1, 4, 2, 3, 5, 4};

        System.out.println("FrogRiverWithHashmap: " + solution(5, arr));
        System.out.println("FrogRiverWithoutHashmap: " + solution1(5, arr));

        //Solution 3
        int a = 10;
        int b = 5;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping:" + " a = " + a + ", b = " + b);

        //Solution 4
        String str = "Hello I am Ashfaq";
        System.out.println("Total No. of words : " + countWords(str));

    }

    public int solution(int X, int[] A) {
        HashSet<Integer> position = new HashSet<>();

        try {
            for (int x = 0; x < A.length; x++) {
                position.add(A[x]);
                if (position.size() == X) {
                    return x;
                }
            }
        } catch (Exception e) {
            return -1;
        }

        return -1;
    }

    public static int solution1(int X, int[] A) {

        int jumpCount = X;
        int[] position = new int[X + 1];

        for (int i = 0; i < A.length; i++) {

            if (position.length >= A[i]) {

                if (position[A[i]] == 0)
                    jumpCount--;

                if (jumpCount == 0)
                    return i;

                position[A[i]]++;
            }
        }
        return -1;
    }

    public static int countWords(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        String[] words = inputString.split("\\s+");
        return words.length;
    }
}