package com.zycus;


import java.util.ArrayList;

public class ShuffleGenerator {
	
	 // Add more here
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

    /**
     * @return the next index.
     */
    public int getNext(){
        do{
            currentIndex = (currentIndex + prime) % size;
        }while(currentIndex >= actualSize);
        return currentIndex;
    }

    /**
     * @return the previous index.
     */
    public int getPrevious(){
        do{
            // Yes, parenthesis are needed to floor.
            currentIndex = size * ((prime - currentIndex + size - 1)/size) + currentIndex - prime;
        }while(currentIndex >= actualSize);
        return currentIndex;
    }

    public static void main(String[] args){
        
        ShuffleGenerator sg = new ShuffleGenerator(0, 100);
        
        ArrayList<String> alist = new ArrayList<>();
        for(int i=0;i<100;i++) {
        	alist.add("Song "+i);
        
        }
        System.out.println("\n\n Forward Song list ");
        for(String s: alist) {
        	           
        	System.out.println(alist.get(sg.getNext()));
        
        }
       
        System.out.println("\n\n Backword Song list ");
        for(String s: alist) {
        	           
        	System.out.println(alist.get(sg.getPrevious()));
        
        }
    }

}
