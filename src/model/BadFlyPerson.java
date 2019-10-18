package model;

import java.io.Serializable;

/**
 * BadFlyPerson.java 
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.0
 * @since 08-10-2019
 */
public class BadFlyPerson extends SuperVillain implements Serializable, FlyInterface {

	private static final long serialVersionUID = 1L;

	public BadFlyPerson() {
		super();
	}
	
	@Override
	public void fly() {
		System.out.println("BadFlyPerson: flying...");
	}
	
	@Override
	public void usePower() {
		fly();
	}
	
	@Override
	public void evilLaugh() {
		System.out.println("BadFlyPerson: muahahahaha...");
	}
	
	@Override
	public void createChaos() {
		System.out.println("BadFlyPerson: creating chaos...");
	}

}
