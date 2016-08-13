import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Article {
	static ArrayList<Time> arr = new ArrayList<>();
	static ArrayList<YearData> yd = new ArrayList<>();
	public static void main(String[] args){
		for(int z=1;z<10;z++){
			String name1 = "article/"+"0"+z+""+".txt";
			dealfile(name1);
		}
		dealfile("article/10.txt");
		for(int w=11;w<=25;w++){
			String name2 = "article/"+w+""+".txt";
			dealfile(name2);
		}
		
		//dealfile("05.txt");
		for(int i=0;i<yd.size();i++){
			System.out.println("年分:"+yd.get(i).getYear()+"次數"+yd.get(i).counter);
		}
		
	}
	public static void dealfile(String txtname){
		try {
			FileReader fr=new FileReader(txtname);
			BufferedReader br=new BufferedReader(fr);
			String[] temp  = br.readLine().split(" ");
			int totalarticals =  Integer.parseInt(temp[2]);
			int cases = 1;
			System.out.println(txtname+"共"+totalarticals+"資料");
			while(br.ready()){
				String readline = br.readLine();
				String counter = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ #"+cases+" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
				if(readline.equals(counter)){
					String timeinfo = br.readLine();
					cases++;
					String timesplit1[] = timeinfo.split(" ");
					String time = timesplit1[1];
					String timesplit2[] = time.split("-");
					arr.add(new Time(Integer.parseInt(timesplit2[0]),Integer.parseInt(timesplit2[1]),Integer.parseInt(timesplit2[2])));
					dealyeardata(Integer.parseInt(timesplit2[0]),Integer.parseInt(timesplit2[1]));
				}
			}
			br.close();
		} 
		catch (IOException e) {System.out.println(e);}
	

	}
	public static void dealyeardata(int year,int month){
		boolean isIn = false;
		for(int i=0;i<yd.size();i++){
			if(yd.get(i).year==year){
				yd.get(i).counter++;
				isIn = true;
				break;
			}
		}
		if(!isIn){
			yd.add(new YearData(year,month));
			
		}
		Collections.sort(yd, new Comparator<YearData>(){
	   		 @Override
	   		 public int compare(YearData o1, YearData o2) {
	   		  return Integer.parseInt(o1.getYear()+"")-Integer.parseInt(o2.getYear()+"");
	   		 }  
	   		});
	}
}
