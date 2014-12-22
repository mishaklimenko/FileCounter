package net.filecounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import net.model.FolderData;
import net.util.FileUtils;
import net.writer.FileDataWriter;
import net.writer.impl.CsvDataWriter;
import net.writer.impl.TxtDataWriter;

public class FileCounterRunner {
	
	static public String FILE_WITH_PATH = "path.txt";//input file
	static public String RESULTING_TXT_FILE = "e:/result_txt.txt";// output file txt
	static public String RESULTING_CSV_FILE = "e:/result_csv.csv";// output file csv
	static public String RESULT_FILE_NAME = "result";
		
	public static void main(String[] args){

		List<String> pathsCollection = null;
		List<FolderData> foldersData = null;

		//System.out.println("How this programm works... \n");
		/*******************************************************************/
		if ((args != null) && (args.length == 2)) {
			
			File fileToRead = new File(args[0]);
				
			if (fileToRead.exists() && fileToRead.isFile() ) {
				
				
				System.out.println("File [" + args[0] + "] contains file paths");
				System.out.println("File ["+ args[1] + "] containt file count results");
				
				pathsCollection = FileUtils.getReadFile(args[0]);
				System.out.println("pathsCollection ");
				foldersData = FileUtils.getFilesCountCollectionFromPathsCollection(pathsCollection);
				
				FileDataWriter.writeFile(foldersData, args[1], new CsvDataWriter());
				
				System.out.println(FileUtils.folderDataPrinter(foldersData));
			}else{
				System.out.println("File ["+ args[0] + "] is nureadable!");
			}
		}
		else{
			System.out.println("Incorrect command line paramethers!");
		}
		/*******************************************************************/
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String txtCommand = "";
		
		
		try{
			while (true) {
				System.out.println("To quit the programm type \"q\"...");
				System.out.println("Or type correct file path to a file with paths to see file counts :");
				
				txtCommand = br.readLine();
				screenSkipper(1000);
								
				if (txtCommand.equals("q")) break;	
				
				File file = new File(txtCommand);
				if ((file.exists()) && (file.isFile())) {
									
					pathsCollection = FileUtils.getReadFile(txtCommand);//ГЏГ ГЇГЄГ ГЁ, ГЄГ®ГІГ®Г°Г»ГҐ ГІГ°ГҐГЎГіГѕГІ ГЇГ®Г¤Г±Г·ГҐГІГ  Гў Г­ГҐГ© ГґГ Г©Г«Г®Гў.
					
					foldersData = FileUtils.getFilesCountCollectionFromPathsCollection(pathsCollection);
									
					System.out.println(FileUtils.folderDataPrinter(foldersData));
					
				}else {
					System.out.println("Incorrect File path! Try again... \n");
				}			
			}
				
		}
		catch(Exception e){	
		}
	}
		
	private static void screenSkipper(int linesCount) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < linesCount; i++){
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}