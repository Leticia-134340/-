package c09;

class Profile{
	//속성
	String name;
	String addr;
	String job;
	String major;
	//생성자
	//1)디폴트생성자 삽입
	public Profile() {
	}
	//2)모든 인자 받는 생성자 삽입 -> 각멤버에 대입
	public Profile(String name, String addr, String job, String major) {
		
	}
	
	//3)모든 인자 받는 생성자 삽입(가변인자사용할것) -> , 를기준으로 잘라내어 각속성에 저장
	public Profile(String ...args) {
		this.name = args[0];
		this.addr = args[1];
		this.job = args[2];
		this.major = args[3];
	}
	public Profile(String all) {
		String [] arr = all.split(",");
		this.name = arr[0];
		this.addr = arr[1];
		this.job = arr[2];
		this.major = arr[3];
	}
	
	
	//ex, "홍길동,대구,프로그래머,컴퓨터공학" ->[홍길동,대구,프로그래머,컴퓨터공학]
	
	
//		String name;
//		String addr;
//		String job;
//		String major;
//		//디폴트
//		Profile(String name){
//			this.name = name;
//		}
//		Profile(String addr){
//			this.addr = addr;
//		}
//		Profile(String job){
//			this.job = job;
//		}
//		Profile(String major){
//			this.major = major;
//		}
	//기능
	//1) getter and setter 삽입

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	//2) toString  재정의 
	
	@Override
	public String toString() {
		return "Profile [name=" + name + ", addr=" + addr + ", job=" + job + ", major=" + major + "]";
		}
	
	//3) boolean isContain(String findstr) 함수 완성하기
	boolean isContain(String findstr) {
		
		if(this.name.contains(findstr)) {
			return true;
		}else if(this.addr.contains(findstr)) {
			return true;
		}else if(this.job.contains(findstr)) {
			return true;
		}else if(this.major.contains(findstr)) {
			return true;
		}else {
			return false;
		}

		
	}
	
	//4)
	boolean isEquals(String str) {
		//all로 받은 문자열을 , 단위로 잘라내어(split(",")) 각각 나눠진 문자열이
		//name,addr,job,major 와 일치 하면 true
		//아니면 false 를 리턴
		
		String[] arr = str.split(",");

			if(
				arr[0].equals(this.name) &&
				arr[1].equals(this.addr) &&
				arr[2].equals(this.job) &&
				arr[3].equals(this.major) 
					
					) {
				return true;
			}
			return false;
		
			
	
	}

public class C06Ex {

	public static void main(String[] args) {
		Profile hong = new Profile("홍길동,대구,프로그래머,컴퓨터공학");
		System.out.println(hong.toString());
		System.out.println("길동 포함여부 : " + hong.isContain("길동"));	//true
		System.out.println("컴퓨터 포함여부 : " + hong.isContain("컴퓨터"));	//true
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,대구,프로그래머,컴퓨터공학"));//false
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,울산,프로그래머,컴퓨터공학"));//false

	}

}}
