// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintAllPermutationsOfAStringIteratively.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.StringStringBuilderAndArraylist;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintAllPermutationsOfAStringIteratively
{

    public PrintAllPermutationsOfAStringIteratively()
    {
    }

    public static void solution(String str)
    {
        int n = str.length();
        int f = factorial(n);
        for(int i = 0; i < f; i++)
        {
            StringBuilder sb = new StringBuilder(str);
            int temp = i;
            for(int d = n; d >= 1; d--)
            {
                int q = temp / d;
                int r = temp % d;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }

            System.out.println();
        }

    }

    private static int factorial(int n)
    {
        int val = 1;
        for(int i = 2; i <= n; i++)
            val *= i;

        return val;
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }
}
