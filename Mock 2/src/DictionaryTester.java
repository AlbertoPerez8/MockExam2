import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;


public class DictionaryTester {

	ArrayList dic1 = new ArrayList<>(); 
	ArrayList dic2 = new ArrayList<>();
	ArrayList dic3 = new ArrayList<>();
	ArrayList dic4 = new ArrayList<>();
	ArrayList dic5 = new ArrayList<>(); //empty

	Dictionary d1 = new Dictionary(dic1);
	Dictionary d2 = new Dictionary(dic2);
	Dictionary d3 = new Dictionary(dic3);
	Dictionary d4 = new Dictionary(dic4);
	Dictionary d5 = new Dictionary(dic5);
	

	public void addWords() {

		d1.getDictionary().add("for");
		d1.getDictionary().add("nand");
		d1.getDictionary().add("queue");
		d1.getDictionary().add("for");
		d1.getDictionary().add("polymorphism");
		d1.getDictionary().add("while");
		d1.getDictionary().add("for");
		d1.getDictionary().add("superclass");
		d1.getDictionary().add("protected");

	}

	public void addWordsR(){

		d3.getDictionary().add("protected");
		d3.getDictionary().add("superclass");
		d3.getDictionary().add("for");
		d3.getDictionary().add("while");
		d3.getDictionary().add("polymorphism");
		d3.getDictionary().add("for");
		d3.getDictionary().add("queue");
		d3.getDictionary().add("nand");
		d3.getDictionary().add("for");

	}

	public void addWords1() {

		d4.getDictionary().add("nand");
		d4.getDictionary().add("queue");
		d4.getDictionary().add("polymorphism");
		d4.getDictionary().add("while");
		d4.getDictionary().add("for");
		d4.getDictionary().add("superclass");
		d4.getDictionary().add("protected");

	}

	public void addWords2() {

		d2.getDictionary().add("nand");
		d2.getDictionary().add("IndexOutOfBoundsException");
		d2.getDictionary().add("queue");
		d2.getDictionary().add("polymorphism");
		d2.getDictionary().add("IndexOutOfBoundsException");
		d2.getDictionary().add("IndexOutOfBoundsException");
		d2.getDictionary().add("IndexOutOfBoundsException");
		d2.getDictionary().add("while");
		d2.getDictionary().add("for");
		d2.getDictionary().add("superclass");
		d2.getDictionary().add("protected");
		d2.getDictionary().add("IndexOutOfBoundsException");

	}

	@Test
	public void testPS1() {

		addWords();
		assertTrue("Must return -1", d2.pageSearch("") == -1);
		assertTrue("Doesn't exist", d1.pageSearch("exception") == -1);
		assertTrue("Returns incorrect page", d1.pageSearch("while") == 5);
		assertFalse("Returns the correct page", d1.pageSearch("protected") != dic1.size() - 1);

	}

	@Test

	public void testED() {

		addWords();

		addWords1();

		addWords2();



		assertTrue("Word doesn't exist", d1.eliminateDuplicates("exception") == 0);

		assertFalse("Correct return", d1.eliminateDuplicates("for") != 3);

		assertTrue("Wrong return", d2.eliminateDuplicates("IndexOutOfBoundsException") == 5);

		assertTrue("Incorrect return", d1.eliminateDuplicates("while") == 1);

		assertTrue("Wrong Dictionary", d1.equals(d4));

	}

	@Test
	public void testRD() {

		addWords();

		addWordsR();

		addWords1();

		assertTrue("Dictionary is Empty", d5.reverseDictionary() == null);

		assertTrue("Dictionary is not Empty", d1.reverseDictionary() != null);

		assertFalse("Correct Dictionary", d1.reverseDictionary().equals(d1));

		assertNotEquals(d3 , d1.reverseDictionary());	

	}
}