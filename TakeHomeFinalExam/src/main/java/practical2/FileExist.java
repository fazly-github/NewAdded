package practical2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileExist {
	FileReader fileReader;

	public static void main(String[] args) {

		FileExist obj = new FileExist();
		boolean fileExist = obj.doesFileExist("src/dictionary/wordsPlusMeaningData.txt");
		if (fileExist == true) {
			obj.getData();
		} else {
			System.out.println("Try again the file is not exist !!!");
		}

	}

	public boolean doesFileExist(String path) {
		boolean result = true;
		File file = new File(path);
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found please enter correct file path");
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public void getData() {
		BufferedReader br = new BufferedReader(fileReader);
		String line;
		String word = "";
		String meaning = "";

		try {
			while ((line = br.readLine()) != null) {
				word = line.substring(0, line.indexOf(" "));
				meaning = line.substring(line.indexOf("- ") + 1);// get substring after "- "(hyphen space) and since this index will be included therefore specifying indexOf("- ")+1

				System.out.println(word);
				String[] meaningArray = meaning.split(",");
				for (int i = 0; i < meaningArray.length; i++) {
					System.out.println(meaningArray[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
