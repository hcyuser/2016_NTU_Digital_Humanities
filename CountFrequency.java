import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class CountFrequency {
	static ArrayList<Fre> fre = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		dealfile("01.csv");
		dealfile("02.csv");
		dealfile("03.csv");
		dealfile("04.csv");
		dealfile("05.csv");
		dealfile("06.csv");
		dealfile("07.csv");
		dealfile("08.csv");
		Collections.sort(fre, new Comparator<Fre>(){
			@Override
			public int compare(Fre o1, Fre o2) {
				return o2.counter-o1.counter;
			}  
		});
		FileWriter fw = new FileWriter("output.txt");
		writefile(fw,"詞彙:次數\r\n");
		for(int i=0;i<fre.size();i++){
			if(fre.get(i).getCounter()>=4){
				String temp = fre.get(i).name+","+fre.get(i).counter;
				writefile(fw,temp+"\r\n");
			}
		}
		fw.close();
		System.out.println("系統完成");
	}
	public static void dealfile(String txtname){
		try {
			FileReader fr=new FileReader(txtname);
			BufferedReader br=new BufferedReader(fr);
			while(br.ready()){
				String temp[] = br.readLine().split(",");
				dealfre(temp);

			}
			br.close();
		} 
		catch (IOException e) {System.out.println(e);}


	}
	public static void dealfre(String[] temp){
		boolean isAdd = false;
		for(int i=0;i<fre.size();i++){
			if(fre.get(i).getName().equals(temp[0])){
				fre.get(i).setCounter((fre.get(i).getCounter()+Integer.parseInt(temp[1])));
				isAdd = true;
			}

		}
		if(!isAdd){

			fre.add(new Fre(temp[0],Integer.parseInt(temp[1])));

		}

	}
	public static void writefile(FileWriter fw,String bar) throws IOException{
		fw.write(bar);
		fw.flush();
	}

}
