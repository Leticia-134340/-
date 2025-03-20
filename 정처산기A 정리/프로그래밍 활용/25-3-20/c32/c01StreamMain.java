package c32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
	public String name;
	public int age;
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

class Employee extends Person{
	String company;
	String depart;
	String role;
	Employee(){}
	
	Employee(Person person){
		this.name = person.getName();
		this.age = person.getAge();
	}
	public Employee(String name, int age) {
		super(name,age);
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Employee(String company, String depart, String role) {
		super();
		this.company = company;
		this.depart = depart;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [company=" + company + ", depart=" + depart + ", role=" + role + ", getName()=" + getName()
				+ ", getAge()=" + getAge() + "]";
	}

	

	
	
	
}

public class c01StreamMain {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
		
		//filter
		List<Integer> list2 =
		list.stream().filter((item)->{return item%2==0;})
					 .collect(Collectors.toList());
		System.out.println("짝수필터링 : "+ list2);
		
		//map
		List<Integer> list3 =
		list.stream().filter((item)->{return item%2==0;})
					 .map((item)->{return item*item;})
					 .collect(Collectors.toList());
		
		System.out.println("MAP적용 :"+ list3 );
		
		//
		List<Person> list4 = Arrays.asList(
					new Person("제갈길동",35),
					new Person("황길동무가되어",45),
					new Person("백길동대문점",25),
					new Person("홍길동전길",55)
				);
		List<Integer> list5=
		list4.stream()
//					.map((person)->{return person.getAge();})
//					.map (person->person.getAge())
					.map (Person::getAge)			//단일의 경우 메서드 참조(::)로 줄이기 가능
					.sorted((a,b)->{return b-a;})	//내림차순
		
					.collect(Collectors.toList());
		
		System.out.println(list5);
		
		List<Integer> list6=
		list4.stream()
				.map(Person::getName)
				.map(String::length)
				.sorted((a,b)->b-a)
				.collect(Collectors.toList());
		System.out.println(list6);

		List<Employee> list7=
		list4.stream()
//				.map((person)->{return new Employee(person.getName(),person.getAge());})
				.map(Employee::new)		//person을 받는 생성자가 있어야 오류가 생기지 않는다 40번째 줄
				.collect(Collectors.toList());
		
		list7.forEach(System.out::println);
		
	}

}
