package org.demo.encoding;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FileReaderTest {

	@Test
	public void test1() {
		
		FileReader fileReader = new FileReader();
		List<String> lines = fileReader.readFile("src/test/resources/file1.txt");

		Assert.assertNotNull(lines);
		Assert.assertEquals(3, lines.size());
		int i=0;
		Assert.assertEquals("abc", lines.get(i++));
		Assert.assertEquals("def", lines.get(i++));
		Assert.assertEquals("GHI", lines.get(i++));
	}

	@Test
	public void test2() {
		
		FileReader fileReader = new FileReader();
		List<String> lines = fileReader.readFile("src/test/resources/file2.txt");

		Assert.assertNotNull(lines);
		Assert.assertEquals(3, lines.size());
		int i=0;
		Assert.assertEquals("abc", lines.get(i++));
		Assert.assertEquals("prénom", lines.get(i++));
		Assert.assertEquals("employé", lines.get(i++));
	}

}
