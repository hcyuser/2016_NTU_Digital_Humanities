import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class CountFrequency {
	static ArrayList<Fre> fre = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		dealfile("01.txt");
		dealfile("02.txt");
		dealfile("03.txt");
		dealfile("04.txt");
		dealfile("05.txt");
		dealfile("06.txt");
		Collections.sort(fre, new Comparator<Fre>(){
			@Override
			public int compare(Fre o1, Fre o2) {
				return o2.counter-o1.counter;
			}  
		});
		FileWriter fw = new FileWriter("output.txt");
		writefile(fw,"時間:次數\r\n");
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
				String temp[] = br.readLine().split("\t");
				//System.out.println(temp[0]+":"+temp[1]);
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
