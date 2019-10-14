package com.stackroute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Exercise01StudentNameSortTest {

	private static final String MSG_01 = "The returned sorted array should not be null";
	private static final String MSG_02 = "The names are not sorted as per the requirement. Check the expected output for the method";
	private static final String MSG_03 = "There is no output printed from the main method. Check the Sample output section"
			+ "in the problem for expected output";

	private static final String MSG_04 = "The output is not as expected. Check the Sample output format in the problem description";

	private PrintStream out;
	private ByteArrayOutputStream myOutStream;
	private InputStream in;
	private ByteArrayInputStream myInputStream;

	@Before
	public void setUp() {
		in = System.in;
		out = System.out;
		myOutStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOutStream));
	}

	@After
	public void teardown() {
		System.setIn(in);
		System.setOut(out);
	}

	@Test
	public void test_01_sortStudents() {
		String[] studentNames = { "Max", "Rahul", "Girish", "John" };
		int[] percentages = { 90, 75, 65, 80 };

		String[] sortedStudents = Exercise01StudentNameSort.sortStudents(studentNames, percentages);

		String actual = Arrays.toString(sortedStudents);
		String expected = "[Girish, Rahul, John, Max]";

		assertNotNull(MSG_01, sortedStudents);
		assertEquals(MSG_02, expected, actual);
	}

	@Test
	public void test_02_sortStudents_main() {
		String input = "Rahul:75;Girish:65;John:80;";
		myInputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(myInputStream);

		Exercise01StudentNameSort.main(null);

		String actual = myOutStream.toString().replaceAll("\\s+", "");
		String expected = "[Girish, Rahul, John]".replaceAll("\\s+", "");

		assertFalse(MSG_03, actual.isEmpty());
		assertEquals(MSG_04, expected, actual);
	}
}