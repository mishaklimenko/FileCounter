package net.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.model.*;
import net.util.*;


public class FileUtils{
	 
	public static long getFilesCount(String path){
		long filesCounter = 0;

		return fileCount(path, filesCounter);

	}
	
	private static long fileCount(String path, long filesCounter){
		
		File singleFolder = new File(path);
		
		if (singleFolder.isFile()) {
			filesCounter = -1;
		} else if (!singleFolder.isDirectory()) {
			filesCounter = -2;
		} else {
		
			File[] filesInTheFolder = null;
			try {
				filesInTheFolder = singleFolder.listFiles();
				
				for (File singleFile : filesInTheFolder) {
					if (singleFile.isDirectory()) {
						filesCounter = fileCount(singleFile.getPath(), filesCounter);
					}
					filesCounter++;
				}
			} catch (SecurityException se) {
				filesCounter = -3;
			}
		}
		return filesCounter;	
	}
	
	public static List<FolderData> getFilesCountCollectionFromPathsCollection(List<String> pathsCollection) {
		
		List<FolderData> foldersData = new ArrayList<FolderData>();
		
		for (String singlePath : pathsCollection) {
			long filesCount = getFilesCount(singlePath);

			FolderData singleFolderData = new FolderData(singlePath, filesCount, descriptionGenerator(filesCount));
			
			foldersData.add( singleFolderData );
			/*
			System.out.printf("[Log Data] %s %s %s %n%n",
								singleFolderData.getFullPath(),
								singleFolderData.getFileCount(), 
								singleFolderData.getPathDescription());
								*/
		}
		return foldersData;
	}
	
	private static String descriptionGenerator(long value) {
		String result = null;
		
		switch ((int)value) {
			case 0 : result = "Empty folder"; break;
			case -1 : result = "File"; break;
			case -2 : result = "Incorrect file path"; break;
			case -3 : result = "Processing error"; break;
			
			default: result = "Folder Containing Files"; break;
		}
		return result;
	}
	
    public static List<String> getReadFile(String fileToRead) {		
		
		List<String> pathsCollection = new ArrayList<String>();
		
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileToRead));
    		
	        String line = null;
	        while ((line = bufferedReader.readLine()) != null) {
	            pathsCollection.add(line) ;
	        }
	        
	        bufferedReader.close();
			
		}catch (Exception e) {
			pathsCollection = null;
			//error message
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
        return pathsCollection;
    }
    
    public static String folderDataPrinter(List<FolderData> foldersData) {
    	StringBuilder sb = new StringBuilder();
    	int i = 1;
    	for (FolderData fd : foldersData) {
    		
    		sb.append(String.format("%s. Initial search path        ::: %s;%n"+
									"   Files found in the folder  ::: %s;%n"+
									"   Folder description         ::: %s;%n%n",
									i,
				    				fd.getFullPath(),
				    				((fd.getFileCount())>0) ? fd.getFileCount() : 0,
				    				fd.getPathDescription()));
    		i++;
    	}
    	return sb.toString();
    }
}