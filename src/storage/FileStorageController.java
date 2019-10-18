package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import model.SuperHero;

/**
 * FileStorageController.java 
 * Purpose: Store and read serializable objects
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.4
 * @since 07-10-2019
 */
public class FileStorageController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static FileStorageController instance;
	private static String SAVE_DIRECTORY = "../SaveTheWorldTD/";
	private static String SAVE_FILENAME = "saveTheWorld_";
	private static String SAVE_EXTENSION = ".ser";
	private int fileVersion;
	
	private FileStorageController() {
	}
	
	public static synchronized FileStorageController getInstance() {
		/*
		 * returns the instance of FileStorageController
		 */
		if(instance == null) {
			instance = new FileStorageController();
		}
		return instance;
	}
	
	public void pathCreator(SuperHero hero) {
		/*
		 * creates the path where the hero is going to be saved
		 */
		fileVersion = checkFileVersion();
		String savePath = SAVE_DIRECTORY 
						+ SAVE_FILENAME
						+ fileVersion
						+ SAVE_EXTENSION;
		File savedFile = new File(savePath);
		
		if(!savedFile.getParentFile().exists())
			savedFile.getParentFile().mkdir();
		
		try {
			System.out.println("saving to: "  + savePath);
			storeObject(hero, savePath);
		} catch (Exception errorWritingToFile){
			System.out.println("Error while writing file...");
		}
	}
	
	public synchronized int checkFileVersion() {
		/*
		 * checks the current file version
		 */
		int increase = 1;
		
		File file = new File(SAVE_DIRECTORY 
							+ SAVE_FILENAME
							+ increase
							+ SAVE_EXTENSION);
		
		while(file.exists()) {
			increase ++;
			file = new File(SAVE_DIRECTORY 
					+ SAVE_FILENAME
					+ increase
					+ SAVE_EXTENSION);
		}
		
		return increase;
	}
	
	public void storeObject(Object object, String filename) {
		/*
		 * stores an object as a serializable file
		 */
		try {
			FileOutputStream fileOutput = new FileOutputStream(filename);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			
			objectOutput.writeObject(object);
			objectOutput.close();
			fileOutput.close();
		} catch (IOException iOException) {
			storeObject(iOException, "IOException.ser");
		}
	}
	
	public Object readObject(String filename) {
		/*
		 * reads a serializable file and returns the object
		 */
		Object object = null;
		try {
			FileInputStream fileInput = new FileInputStream(filename);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			object = objectInput.readObject();
			objectInput.close();
			fileInput.close();
		} catch (FileNotFoundException fileNotFound) {
			System.out.println(fileNotFound.getMessage());
		} catch (IOException iOException) {
			System.out.println(iOException.getMessage());
		} catch (ClassNotFoundException classNotFound) {
			System.out.println(classNotFound.getMessage());
		}
		return object;
	}

}
