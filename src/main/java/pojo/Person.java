package pojo;

public class Person {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("111");
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void initPerson(){
		System.out.println("你大爷我来啦");
	}

	public void destroyPerson(){
		System.out.println("你大爷我走了");
	}

	public void  talk(){
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
