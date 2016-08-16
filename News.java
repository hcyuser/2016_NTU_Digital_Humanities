
public class News {
	int counter = 1;
	String name;
	News(String name){
		this.name = name;
	}
	public int  getCounter(){
		return counter;
	}
	public void setCounter(int c){
		counter = c;
	}
	public String getName(){
		return name;
	}
}
