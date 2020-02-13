package org.demo.encoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class FileReader {

	public List<String> readAllLines(String filePath) {

		Path path = Paths.get(filePath); // Paths : "nio" since Java 1.7
		try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) { // Files & StandardCharsets :
																							// "nio" since Java 1.7
			return readAllLines(br);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private List<String> readAllLines(BufferedReader br) throws IOException {
		List<String> lines = new LinkedList<>();
		String line;
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}
		return lines;
	}

	public String readAllContentInString(String filePath) {
		try {
			byte[] bytesFromFile = Files.readAllBytes(Paths.get(filePath));
			return new String(bytesFromFile, StandardCharsets.UTF_8); // UTF-8 = charset to be used to decode the bytes
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
