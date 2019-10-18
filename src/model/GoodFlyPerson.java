package model;

import java.io.Serializable;

/**
 * GoodFlyPerson.java 
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.0
 * @since 08-10-2019
 */
public class GoodFlyPerson extends SuperHero implements FlyInterface, Serializable {
	
	private static final long serialVersionUID = 1L;

	public GoodFlyPerson(int goodness) {
		super(goodness);
	}

	@Override
	public void fly() {
		System.out.println("GoodFlyPerson: flying...");
	}
	
	@Override
	public void heroSpeech() {
		System.out.println("GoodFlyPerson: I shall fight evil!");
	}
	
	@Override
	public void restoreOrder() {
		System.out.println("GoodFlyPerson: Restoring order...");
	}
	
	@Override
	public void usePower() {
		fly();
	}
}
