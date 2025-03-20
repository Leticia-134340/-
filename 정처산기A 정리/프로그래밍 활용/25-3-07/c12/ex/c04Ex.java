package c12.ex;

//[1번] 다음 main() 메소드와 실행 결과를 참고하여 TV를 상속받은 ColorTV 클래스를 작성하라.

class TV{
	int size;
	TV(int size){
		this.size = size;
	}
}
class ColorTV extends TV{
	int color;
	ColorTV(int size, int color){
		super(size);
		this.color = color;
		
	}
	void printProperty() {
		System.out.printf("%d인치 %d컬러\n", this.size, this.color);
	}
}

public class c04Ex {
	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
	}

}
