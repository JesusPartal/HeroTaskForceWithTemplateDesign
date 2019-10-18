package thread;

import java.io.IOException;
import monitor.FolderSubject;
import monitor.HeroObserver;

/**
 * ThreadFolderObserver.java 
 * Purpose: checks a folder for changes
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.5
 * @since 10-10-2019
 */
public class ThreadFolderObserver extends Thread {
	
	private int duration, cadency;
	
	public ThreadFolderObserver(int duration, int cadency) {
		this.duration = duration;
		this.cadency = cadency;
	}
	@Override
	public void run() {
		HeroObserver heroCreatorObserver = new HeroObserver();
		FolderSubject folderMonitorSubject = new FolderSubject();
		folderMonitorSubject.attach(heroCreatorObserver);
		
		for (int time = 0; time <= duration; time = time + cadency) {
			try {
				folderMonitorSubject.folderReader(cadency);
				Thread.sleep(cadency * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
