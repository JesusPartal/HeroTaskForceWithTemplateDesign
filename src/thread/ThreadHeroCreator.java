package thread;

import java.io.File;
import factory.SuperHeroFactory;
import model.BadFlyPerson;
import model.BadStrongMan;
import model.SuperHero;
import model.SuperHeroType;
import model.SuperVillain;
import storage.FileStorageController;

/**
 * ThreadHeroCreator.java 
 * Purpose: thread that creates different types of heros
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.4
 * @since 11-10-2019
 */
public class ThreadHeroCreator extends Thread {
	
	private String fileString;
	private FileStorageController fileStorageController;
	private int cadency = 2;
	
	public ThreadHeroCreator(String fileString) {
		this.fileString = fileString;
		fileStorageController = FileStorageController.getInstance();
	}
	@Override
	public void run() {
		try {
			System.out.println("Loading: " + fileString);
			
			SuperVillain superVillain = (SuperVillain) fileStorageController.readObject(fileString);
			System.out.println(superVillain.getClass() + " - " + superVillain.getStats());
			
			SuperHero superHero = null;
			if (BadFlyPerson.class.isInstance(superVillain)) {
				superHero = SuperHeroFactory.buildHero(SuperHeroType.GOODFLYPERSON, superVillain.getBadness() + 1);
			}
			else if (BadStrongMan.class.isInstance(superVillain)) {
				superHero = SuperHeroFactory.buildHero(SuperHeroType.GOODSTRONGMAN, superVillain.getBadness() + 1);
			}
			
			superHero.beingHero();
			System.out.println(superHero.getClass().getName() + " / " + superHero.getStats());
			fileStorageController.pathCreator(superHero);
			System.out.println("--------------------------");
			
			File file = new File(fileString);
			file.delete();
	
			Thread.sleep(cadency * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
