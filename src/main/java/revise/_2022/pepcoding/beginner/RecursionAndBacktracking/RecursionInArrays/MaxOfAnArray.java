// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MaxOfAnArray.java

package revise._2022.pepcoding.beginner.RecursionAndBacktracking.RecursionInArrays;

import java.io.PrintStream;
import java.util.Scanner;

public class MaxOfAnArray
{

    public MaxOfAnArray()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        System.out.println(maxOfArray(a, 0));
    }

    public static int maxOfArray(int arr[], int idx)
    {
        if(idx == arr.length - 1)
            return arr[idx];
        int nxtVal = maxOfArray(arr, idx + 1);
        if(arr[idx] >= nxtVal)
            return arr[idx];
        else
            return nxtVal;
    }
}
