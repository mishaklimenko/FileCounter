package net.writer;

import java.util.List;

import net.model.FolderData;

public class FileDataWriter {
	public static void writeFile(List<FolderData> foldersDataCollection, String path, DataWriter dataWriter) {
		try {
			dataWriter.writeData(foldersDataCollection, path);	
		} catch (Exception e) {
			//exception info
		}
		
	}
}

