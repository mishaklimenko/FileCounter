package net.writer;

import java.util.List;

import net.model.FolderData;

public interface DataWriter {
	public void writeData(List<FolderData> foldersDataCollection, String path) throws Exception;
}