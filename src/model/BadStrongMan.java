package model;

import java.io.Serializable;

/**
 * BadStrongMan.java 
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.0
 * @since 08-10-2019
 */
public class BadStrongMan extends SuperVillain implements StrengthInterface, Serializable {

	private static final long serialVersionUID = 1L;

	public BadStrongMan() {
		super();
	}
	
	@Override
	public void strength() {
		System.out.println("BadStrongMan: using strength...");
	}
	
	@Override
	public void usePower() {
		strength();
	}
	
	@Override
	public void evilLaugh() {
		System.out.println("BadStrongMan: muahahahaha...");
	}
	
	@Override
	public void createChaos() {
		System.out.println("BadStrongMan: creating chaos...");
	}

}
