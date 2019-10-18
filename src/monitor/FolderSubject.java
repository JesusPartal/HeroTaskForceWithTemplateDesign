package monitor;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * FolderSubject.java 
 * Purpose: Notifies Observers of changes on a subject, BattleZoneFolder folder
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.2
 * @since 09-10-2019
 */
public class FolderSubject implements Subject, Serializable {
	
	private static final long serialVersionUID = 1L;
	private static String SPAWNED_DIRECTORY = "../BattleZoneFolder/";
	private List<Observer> observers= new ArrayList<>();
	
	public FolderSubject() {
	}

	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notify(String filename) {
		for(Observer o: observers) {
			o.update(filename);
		}
	}
	
	public void folderReader(int cadency) throws IOException, InterruptedException {
		/*
		 * Checks the BattleZoneFolder directory for new files
		 */
		File directory = new File(SPAWNED_DIRECTORY);
		
		File[] fList = directory.listFiles();
		
		for (File file : fList) {
			if (file.isFile()) {
				notify(file.getCanonicalPath());
				Thread.sleep(cadency * 1000);
			}
		}
	}
}
