package model;

import java.io.Serializable;
import java.util.Random;

/**
 * SuperVillain.java 
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.0
 * @since 08-10-2019
 */
public class SuperVillain extends SuperThing implements Serializable {

	private static final long serialVersionUID = 1L;
	private int badness;
	
	public SuperVillain() {
		Random random = new Random();
		badness = random.nextInt(100) + 1;
	}
	
	public int getBadness() {
		return badness;
	}
	
	public void usePower() {};

	public void evilLaugh() {};
	
	public void createChaos() {};
	
	public void beingEvil() {
		evilLaugh();
		usePower();
		createChaos();
	}
	
	@Override
	public String getStats() {
		return "Badness Points: " + this.getBadness();
	}

}
