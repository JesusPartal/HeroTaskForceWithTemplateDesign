package model;

import java.io.Serializable;

/**
 * SuperHero.java 
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.0
 * @since 08-10-2019
 */
public class SuperHero extends SuperThing implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int goodness;
	
	public SuperHero(int goodness) {
		super();
		this.goodness = goodness;
	}
	
	public int getGoodness() {
		return goodness;
	}
	
	@Override
	public String getStats() {
		return "Goodness Points: " + getGoodness();
	}
	
	public void heroSpeech() {};
	
	public void usePower() {};
	
	public void restoreOrder() {};
	
	public void beingHero() {
		heroSpeech();
		usePower();
		restoreOrder();
	}

}
