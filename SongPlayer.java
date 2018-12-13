package com.zycus;
import java.util.ArrayList;


/**
 * @author Urvashi Rana
 * Output of this program will print two list of songs.
 * 1.Forward
 * 2.Backward
 * If We create JSP page for this, It will have two buttons: Next and Previous.
 * if you click on NEXT button,song of the forward list should be played and
 * if you click on PREVIOUS button,song of the backward list should be played.
 
*/

public class SongPlayer {

	public static void main(String[] args) {
		
		ShuffleFaced sf = new ShuffleGenerator(0, 100);
        
        ArrayList<String> alist = new ArrayList<>();
        for(int i=0;i<100;i++) {
        	alist.add("Song "+i);
        
        }
        System.out.println("\n\nForward Song list ");
        for(String s: alist) {
        	           
        	System.out.println(alist.get(sf.getNext()));
        
        }
       
        System.out.println("\n\nBackword Song list ");
        for(String s: alist) {
        	           
        	System.out.println(alist.get(sf.getPrevious()));
        
        }

	}

}
