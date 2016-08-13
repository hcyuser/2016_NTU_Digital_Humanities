import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class weapon {
	public static void main(String[] args){
		try {
    		FileReader fr=new FileReader("weapon.txt");
			BufferedReader br=new BufferedReader(fr);
			while(br.ready()){
				String[] temp  = br.readLine().split(" ");
				System.out.println(temp[0]);
			}
			br.close();
		} 
		catch (IOException e) {System.out.println(e);}
	}
}
