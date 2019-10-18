package model;

import java.io.Serializable;

/**
 * GoodStrongMan.java 
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.0
 * @since 08-10-2019
 */
public class GoodStrongMan extends SuperHero implements StrengthInterface, Serializable {
	
	private static final long serialVersionUID = 1L;

	public GoodStrongMan(int goodness) {
		super(goodness);
	}

	@Override
	public void strength() {
		System.out.println("GoodStrongMan: being strong...");
	}
	
	@Override
	public void heroSpeech() {
		System.out.println("GoodStrongMan: I shall fight evil!");
	}
	
	@Override
	public void restoreOrder() {
		System.out.println("GoodStrongMan: Restoring order...");
	}
	
	@Override
	public void usePower() {
		strength();
	}
}

