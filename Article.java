import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Article {
	static ArrayList<News> news = new ArrayList<>();
	static ArrayList<YearData> yd = new ArrayList<>();
	public static void main(String[] args){
		dealfile("article/01.txt");
		//dealfile("article/02.txt");
		//dealfile("article/03.txt");
		//dealfile("article/04.txt");
		//dealfile("article/05.txt");
		//dealfile("article/06.txt");
		//dealfile("article/07.txt");
		//dealfile("article/08.txt");

		for(int i=0;i<yd.size();i++){
			System.out.println("年分:"+yd.get(i).getYear()+"次數:"+yd.get(i).counter);
		}
		for(int i=0;i<news.size();i++){
			System.out.println("媒體:"+news.get(i).getName()+"次數:"+news.get(i).counter);
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
					dealNews(timesplit1[3]);
					String time = timesplit1[1];
					String timesplit2[] = time.split("-");
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
	public static void dealNews(String nename){
		boolean isAdd = false; 
		for(int i=0;i<news.size();i++){
			if(news.get(i).name.equals(nename)){
				news.get(i).counter++;
				isAdd = true;
			}
		}
		if(!isAdd){
			news.add(new News(nename));
		}
		Collections.sort(news, new Comparator<News>(){
	   		 @Override
	   		 public int compare(News o1, News o2) {
	   		  return o2.counter-o1.counter;
	   		 }  
	   		});
		
	}
}
