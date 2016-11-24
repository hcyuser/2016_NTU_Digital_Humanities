public class KeyWordYear {
	int year=0;
	int counter=0;
	KeyWordYear(int year, int counter){
		this.year=year;
		this.counter=counter;
	}
	public void setCounter(int counter){
		this.counter=counter;
	}
	public void plusCounter(){
		this.counter++;
	}
	public int getYear(){
		return year;
	}
}
