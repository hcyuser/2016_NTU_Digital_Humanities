import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class KeyinWord {
	static ArrayList<KeyWordYear> arr = new ArrayList<>();
	public static void main(String[] args){
		dealfile("外籍移工.txt");
		dealfile("泰國移工.txt");
		dealfile("菲律賓籍移工.txt");
		dealfile("菲籍移工.txt");
		dealfile("越南移工.txt");
		dealfile("越南籍移工.txt");




	}
	public static void dealfile(String txtname){
		try {
			FileReader fr=new FileReader(txtname);
			BufferedReader br=new BufferedReader(fr);
			arr.clear();
			while(br.ready()){
				String temp[] = br.readLine().split(" ");
				String temp2[] = temp[0].split("]");
				String temp3[] = temp2[0].split("-");
				temp3[0] = temp3[0].substring(1, 5);
				dealYear(temp3[0]);
			}
			br.close();
			Collections.sort(arr, new Comparator<KeyWordYear>(){
				@Override
				public int compare(KeyWordYear o1, KeyWordYear o2) {
					return o2.year-o1.year;
				}  
			});
			FileWriter fw = new FileWriter("output"+txtname);
			fw.write("年分:次數"+"\r\n");
			fw.flush();
			for(int i=0;i<arr.size();i++){
				fw.write(arr.get(i).getYear()+"\t"+arr.get(i).counter+"\r\n");

				fw.flush();
			}
			fw.close();
		} 
		catch (IOException e) {System.out.println(e);}


	}
	public static void dealYear(String year){
		boolean  isE=false;
		for(int i=0;i<arr.size();i++){
			if(year.equals(arr.get(i).getYear()+"")){
				arr.get(i).plusCounter();
				isE=true;
			}
		}
		if(!isE){
			arr.add(new KeyWordYear(Integer.parseInt(year),1));

		}
	}
}
