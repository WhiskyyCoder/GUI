/**
 *
 *  @author Domański Jan S14038
 *
 */

package zad2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
	String path;

	public Finder(String path) {

		this.path = path;

	}

	public int getIfCount() {
		int amount = 0;
		FileReader file = null;
		try {
			file = new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(file);
		StringBuffer wczyt = new StringBuffer();
		String line = null;
		String first = "test";
		String end = "test";
		try {
			while ((line = br.readLine()) != null) {
				first = line.replaceAll("\\s+", "");
				if ((first.length() > 1)) {
					first = first.substring(0, 2);
					if (first.equalsIgnoreCase("/*")) {

						while ((line = br.readLine()) != null) {
							end = line.replace("\\s", "");
							if ((end.length() > 1)) {
								end = end.substring(end.length() - 2);
							}
							if (end.equalsIgnoreCase("*/")) {
								break;
							}

						}

					}

					if (!(first.equalsIgnoreCase("//"))) {
						if (line != null) {
							Pattern pattern = Pattern.compile("if\\(.*?\\)");
							Matcher matcher = pattern.matcher(line);
							while (matcher.find()) {

								amount++;

							}
						}
					}

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return amount;

	}

	public int getStringCount(String szukane) {
		int amount = 0;
		FileReader file = null;
		try {
			file = new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(file);
		StringBuffer wczyt = new StringBuffer();
		String line = null;
		String first = "test";
		String end = "test";
		try {
			while ((line = br.readLine()) != null) {
				boolean cont=line.contains("*/");
				first = line.replaceAll("\\s+", "");
				if ((first.length() > 1)) {
					first = first.substring(0, 2);
					if (first.equalsIgnoreCase("/*")) {
if(!cont){
						while ((line = br.readLine()) != null) {

							end = line.replace("\\s", "");
							if ((end.length() > 1)) {
								
								end = end.substring(end.length() - 2);
							}
							if (end.equalsIgnoreCase("*/")) {
								break;
							}

						}
}
					}
					if (!(first.equalsIgnoreCase("//"))) {
						if (line != null) {
							Pattern pattern = Pattern.compile("\"(.*)\"");
							Matcher matcher = pattern.matcher(line);
							while (matcher.find()) {

								pattern = Pattern.compile(".*?" + szukane+ ".*?");
								matcher = pattern.matcher(matcher.group(1));
								while (matcher.find()) {

									amount++;

								}

							}
							 pattern = Pattern.compile("\\//(.*)");
							 matcher = pattern.matcher(line);
							 int count=0;
							while (matcher.find()) {

								pattern = Pattern.compile(".*" + szukane+ ".*");
								matcher = pattern.matcher(matcher.group(1));
								while (matcher.find()) {

									amount++;
count++;
								}

							}
							if(count==0){
							 pattern = Pattern.compile("\\/*(.*)\\*/");
							 matcher = pattern.matcher(line);
							while (matcher.find()) {

								pattern = Pattern.compile(".*" + szukane+ ".*");
								matcher = pattern.matcher(matcher.group(1));
								while (matcher.find()) {

									amount++;

								}

							}
						}
							
						}
						
						
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return amount;

	}
}
