package net.writer.impl;

import java.io.PrintWriter;
import java.util.List;

import net.model.FolderData;
import net.writer.DataWriter;

public class TxtDataWriter implements DataWriter{
	@Override
	public void writeData(List<FolderData> foldersDataCollection, String path) throws Exception {
		String tmpString = null;
		PrintWriter pw = null; 
		try {
			pw = new PrintWriter(path);
			
			for (FolderData singleFolderData : foldersDataCollection) {
				tmpString = String.format("%s :: %s :: %s", 
											singleFolderData.getFullPath(), 
											singleFolderData.getFileCount(),
											singleFolderData.getPathDescription());
				pw.println(tmpString);
			}			
		} finally {
			pw.close();	
		}
						
	}
}