package ohm.softa.a02.tests;

import ohm.softa.a02.SimpleFilter;
import ohm.softa.a02.SimpleList;
import ohm.softa.a02.SimpleListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListTest {

	private SimpleListImpl<Integer> testList;

	@BeforeEach
	void setup(){
		testList = new SimpleListImpl<>();

		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
	}

	@Test
	void testAddElements(){
		int counter = 0;
		for(Object o : testList){
			counter++;
		}
		assertEquals(5, counter);
	}

	@Test
	void testSize(){
		assertEquals(5, testList.size());
	}

	@Test
	void testFilterAnonymousClass(){
		SimpleListImpl<Integer> result = (SimpleListImpl<Integer>) testList.filter(new SimpleFilter<Integer>() {
			@Override
			public boolean include(Integer item) {
				int current = item;
				return current > 2;
			}
		});

		for(Object o : result){
			int i = (int)o;
			assertTrue(i > 2);
		}
	}

	@Test
	void testFilterLambda(){
		SimpleListImpl<Integer> result = (SimpleListImpl<Integer>) testList.filter(o -> (o) % 2 == 0);
		for(Integer o : result){
			int i = o;
			assertTrue(i % 2 == 0);
		}
	}

	@Test
	void testFilterEvenNumbersLambda() {
		SimpleListImpl<Integer> result = (SimpleListImpl<Integer>) testList.filter(o -> (o) % 2 == 0);
		for (Integer o : result){
			assertTrue(o % 2 == 0);
		}
	}
}
