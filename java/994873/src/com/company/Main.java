package com.company;

public class Main {

    public static void main(String[] args) {

        int[] input = new int[]{2, 1, 2, 3, 1, 5, 7};
	    int[] lens = new int[input.length];

	    int max = 0;

	    for(int i=1; i<input.length; i++)
        {
            if (input[i]>input[i-1])
                lens[i] = lens[i-1]+1;
            else lens[i] = 0;
            max = Math.max(lens[i], max);
        }

	    System.out.println(max + 1);

        for(int i=0; i<input.length; i++)
        {
            if (lens[i] == max)
            {
                for(int j=i-lens[i]; j<=i; j++)
                    System.out.print(input[j] + " ");
                System.out.println();
            }
        }
    }
}
