package org.demo.encoding;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FileReaderTest {

	@Test
	public void test1() {
		
		FileReader fileReader = new FileReader();
		List<String> lines = fileReader.readAllLines("src/test/resources/file1.txt");

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
		List<String> lines = fileReader.readAllLines("src/test/resources/file2.txt");

		Assert.assertNotNull(lines);
		Assert.assertEquals(3, lines.size());
		int i=0;
		Assert.assertEquals("abc", lines.get(i++));
		Assert.assertEquals("prénom", lines.get(i++));  // line in file : prÃ©nom  ( 'é' is encoded with 2 bytes : c3 a9 )
		Assert.assertEquals("employé", lines.get(i++)); // line in file : employÃ© ( 'é' is encoded with 2 bytes : c3 a9 )
	}

	@Test
	public void testAllContent1() {
		
		FileReader fileReader = new FileReader();
		String content = fileReader.readAllContentInString("src/test/resources/file1.txt");

		// file content : 13 char
		//  abc\r\n  ( 5 char )
		//  def\r\n  ( 5 char )
		//  GHI      ( 3 char )
		
		Assert.assertNotNull(content);
		Assert.assertEquals(13, content.length());
		String[] parts = content.split("\n");
		Assert.assertEquals(3, parts.length);
		int i=0;
		Assert.assertEquals("abc\r", parts[i++] ); 
		Assert.assertEquals("def\r", parts[i++] );
		Assert.assertEquals("GHI", parts[i++] );
	}

	@Test
	public void testAllContent2() {
		
		FileReader fileReader = new FileReader();
		String content = fileReader.readAllContentInString("src/test/resources/file2.txt");

		Assert.assertNotNull(content);
		Assert.assertEquals(20, content.length());
		String[] parts = content.split("\n");
		Assert.assertEquals(3, parts.length);
		int i=0;
		Assert.assertEquals("abc\r", parts[i++] );   
		Assert.assertEquals("prénom\r", parts[i++] );
		Assert.assertEquals("employé", parts[i++] );
	}

}
