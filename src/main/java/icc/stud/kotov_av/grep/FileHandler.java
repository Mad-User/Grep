package icc.stud.kotov_av.grep;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FileHandler {
	ArrayList<String> lines;

	public FileHandler() {
		lines = new ArrayList<String>();
	}

	public void print() {
		for (String line : lines) {
			System.out.println(line);
		}
	}

	public String[] getLines() {
		return (String[]) lines.toArray();
	}

	public void execute(ArgumentsHolder ah, BufferedReader br) throws Exception {
		int flags = ah.caseIgnore ? Pattern.CASE_INSENSITIVE : 0;
		Pattern pattern = ah.regex ? Pattern.compile(ah.word, flags) : null;

		String search = ah.caseIgnore ? ah.word.toLowerCase() : ah.word;

		String line = null;
		while ((line = br.readLine()) != null) {
			if (pattern != null) {
				if (pattern.matcher(line).matches() ^ ah.inversion)
					lines.add(line);
			} else {
				if (ah.caseIgnore) {
					if (line.toLowerCase().contains(search) ^ ah.inversion)
						lines.add(line);
				} else {
					if (line.contains(search) ^ ah.inversion)
						lines.add(line);
				}
			}
		}
	}
}