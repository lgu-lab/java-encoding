package org.demo.encoding;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodingStrings {
	
	/*
	 * REMINDER : 
	 * 
     * 'char' : from '\u0000' to '\uffff' inclusive, that is, from 0 to 65535 (2^16 -1)
     *          Characters are specifically for data representing the building blocks of strings
     *          A character is stored on 16 bits ( 2 bytes )
     *           
     * 'byte' : from -128 to 127 inclusive 
     *          Bytes are intended for arbitrary binary data
     *           
	 * Source code for class "String" :
	 * 
	 *   public final class String {
     *     private final char value[]; // used for character storage (16 bits for each character)
     *   }
     *  
	 */
	public static void main(String[] args) {
		String s1 = "ab" ;
		String s2 = "aé" ;
		testString(s1);
		testString(s2);

		StringBuilder sb = new StringBuilder();
		sb.append('a'); // can only append 'char' (no 'byte')
		sb.append('\u00E9'); // accentuated 'e'
		String s3 = sb.toString();
		testString(s3);
		
		String s4 = "a\u00E9" ;
		testString(s4);
		
		System.out.println();
		System.out.println("s2 equals s3 : " + s2.equals(s3));
		System.out.println("s3 equals s4 : " + s3.equals(s4));
	}
	
	private static void testString(String s) {
	    System.out.println();
		System.out.println("--- Test with string '" + s + "'");
		printCharacters(s);
		printBytes(s, null); // default charset
		printBytes(s, StandardCharsets.US_ASCII);
		printBytes(s, StandardCharsets.ISO_8859_1);
		printBytes(s, StandardCharsets.UTF_8);
		printBytes(s, StandardCharsets.UTF_16);
	}
	
	private static void printBytes(String s, Charset charset) {
		byte[] bytes ;
		String charsetName ;
		if ( charset != null ) {
			bytes = s.getBytes(charset);
			charsetName = charset.name();
		}
		else {
			bytes = s.getBytes(); // default charset 
			charsetName = "default charset : " + Charset.defaultCharset() ;
		}
	    System.out.println();
		//System.out.println("String = '" + s + "' : string length = " + s.length() + " (number of 'char' in the string)");
		System.out.print("  getBytes(" + charsetName + ") : " );
		printBytes(bytes);
		System.out.println("  bytes.length = " + bytes.length );
	}
	
	public static void printBytes(byte[] bytes) {
	    for (int i = 0; i < bytes.length; i++) {
	        System.out.print(" 0x" + UnicodeFormatter.byteToHex(bytes[i]));
	    }
	    System.out.println();
	}

	public static void printCharacters(String s) {
		System.out.print("String = '" + s + "' (length=" + s.length() + ") : characters = " );
		printCharacters(getCharacters(s));
	}
	private static char[] getCharacters(String s) {
		char[] characters = new char[s.length()] ;
		s.getChars(0, s.length(), characters, 0);
		return characters;
	}
	
	public static void printCharacters(char[] characters) {
	    for (int i = 0; i < characters.length; i++) {
	        System.out.print(" [" + characters[i] + "]" );
	    }
	    System.out.println();
	}
}
