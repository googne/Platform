// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintFibonacciNumbersTillN.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintFibonacciNumbersTillN
{

    public PrintFibonacciNumbersTillN()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);
        int c = 0;
        for(; n - 2 > 0; n--)
        {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }

    }
}
