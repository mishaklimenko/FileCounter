package net.writer.impl;

import java.io.PrintWriter;
import java.util.List;

import net.model.FolderData;
import net.writer.DataWriter;


public class CsvDataWriter implements DataWriter{
	@Override
	public void writeData(List<FolderData> foldersDataCollection, String path) throws Exception {
		PrintWriter pw = new PrintWriter(path);
		String tmpStr = String.format("Подсчет количества файлов в папках%n");
		try {
			pw.print(tmpStr);
			for (FolderData singleFolderData : foldersDataCollection) {
				tmpStr = String.format("%s;%s;%s%n", 
							singleFolderData.getFullPath(),
							((singleFolderData.getFileCount())>0) ? singleFolderData.getFileCount() : 0,
							singleFolderData.getPathDescription());
				pw.print(tmpStr);
				pw.flush();
			}
		} finally {
			pw.close();
		}	
	}
}