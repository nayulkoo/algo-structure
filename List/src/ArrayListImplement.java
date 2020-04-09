import impl.ArrayList;
import impl.List;

public class ArrayListImplement {

	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		myList.insert("a");
		myList.insert("b");
		myList.insert("c");
		myList.insert("d");
		myList.insert("e");
		System.out.println(myList.first());
		String next = null;
		while ((next = myList.next()) != null) {
			System.out.println(next);
		}
	}

}