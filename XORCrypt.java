import java.io.*;
import java.util.Scanner;

import javax.swing.JFrame;

/*
 * (c) 2013 Lord Voldemort Tyrannus Farquad
 * Fellow sentient beings you are free to use this software freely in anything forever as long as you or I live throughout the universe
 * regardless of species and of location in time or space even if you happen to murder someone and the cops are after you.
 */
public class XORCrypt {

	// encrypt up to 27 characters
	short[] key = {2,5,3,1,0,0,8,5,8,9,2,0,5,3,4,4,8,9,2,1};
	
	
	
	public String xorcrypt(String s){
		String res=""; int n = 0;
		for(int i=0; i<s.length(); i++){
			n++;
			if(n >= key.length) n = 0;
			char c = s.charAt(i);
			char r = (char) ((int) c ^ key[n]);
			res += r;
		}
		return res;
	}
	
	public void xorcryptFile(String fName, String outFile) throws IOException{
		Scanner in = new Scanner(new File(fName));
		PrintWriter p = new PrintWriter(new FileWriter(outFile));
		while(in.hasNextLine())
			p.println(xorcrypt(in.nextLine()));	
		p.flush();
		p.close();
	}
	
	
}
