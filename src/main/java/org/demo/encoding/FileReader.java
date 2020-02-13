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

	public List<String> readFile(String filePath) {

		Path path = Paths.get(filePath);
		try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			return readLines(br);
		} catch (IOException e) {
			return null ;
		}
	}

	private List<String> readLines(BufferedReader br) throws IOException {
		List<String> lines = new LinkedList<>();
		String line;
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}
		return lines;
	}
}
