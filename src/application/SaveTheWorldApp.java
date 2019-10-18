package application;

import java.io.IOException;
import thread.ThreadFolderObserver;

/**
 * SaveTheWorldApp.java 
 * Purpose: An app that monitors a folder for Villain class objects and creates the 
 * appropriate SuperHero, deleting the file and creating a new one in another folder
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.0
 * @since 07-10-2019
 */
public class SaveTheWorldApp {
	private static final int CADENCY = 2;
	private static final int DURATION = 20;
	
	public static void main(String[] args) throws IOException {
		Thread thread = new ThreadFolderObserver(DURATION, CADENCY);
		thread.start();
	}
}
