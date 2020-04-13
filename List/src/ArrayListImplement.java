import impl.ArrayList;
import impl.List;

public class ArrayListImplement {

	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");
		java.util.List<String> addList = new java.util.ArrayList<String>();
		addList.add("6");
		addList.add("7");
		addList.add("8");
		addList.add("9");
		myList.addAll(5, addList);
		System.out.println(myList);
		myList.clear();
		System.out.println(myList);
	}

}