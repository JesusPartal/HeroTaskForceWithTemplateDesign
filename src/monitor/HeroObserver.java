package monitor;

import java.io.Serializable;
import thread.ThreadHeroCreator;

/**
 * HeroObserver.java 
 * Purpose: after receiving update, it will create a thread for hero creation
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.2
 * @since 09-10-2019
 */
public class HeroObserver implements Serializable, Observer {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void update(String fileString) {
		Thread thread = new ThreadHeroCreator(fileString);
		thread.start();
	}

}
