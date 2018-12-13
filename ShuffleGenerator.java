package com.zycus;


import java.util.ArrayList;

public class ShuffleGenerator implements ShuffleFaced {
	
	
    private static final int[] PRIMES = new int[]{ 941083987, 776531401, 573259391};
    private final int size;
    private final int actualSize;
    private final int prime;
    private int currentIndex;

    public ShuffleGenerator(int aSeed, int aSize ){
        actualSize = aSize;
        size = 2*3*4*aSize; // Make sure size is not prime

        // TODO: Make sure size < prime
        prime = PRIMES[aSeed % PRIMES.length];
        currentIndex = ((prime + aSeed)*aSize) % size;
    }

    /**    @return the next index.*/
    @Override
    public int getNext(){
        do{
            currentIndex = (currentIndex + prime) % size;
        }while(currentIndex >= actualSize);
        return currentIndex;
    }

    //@return the previous index.
     
    @Override
    public int getPrevious(){
        do{
            // parenthesis are needed to floor.
            currentIndex = size * ((prime - currentIndex + size - 1)/size) + currentIndex - prime;
        }while(currentIndex >= actualSize);
        return currentIndex;
    }

    
}
