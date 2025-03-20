package c31;

import java.util.ArrayList;
import java.util.List;

class Person{
	
	private String name;
	private int age;
	
	Person(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}

public class c01LAMDA {

	public static void main(String[] args) {
		
		//람다식
		//자바 스크립트 : ()=>{}
		//자바 : ()->{}
		
		List<Person> list = new ArrayList<>();
		list.add(new Person("jong",55));
		list.add(new Person("hong",22));
		list.add(new Person("bob",33));
		
		list.forEach(System.out::println);
		System.out.println("--");
		
		// 정렬
		list.sort((a,b)->{return b.getAge()-a.getAge();}); 		//나이 내림차순 
		//
		list.forEach((item)->{System.out.println(item);});

	}

}
