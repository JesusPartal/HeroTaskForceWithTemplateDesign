package factory;

import model.GoodFlyPerson;
import model.GoodStrongMan;
import model.SuperHero;
import model.SuperHeroType;

/**
 * SuperHeroFactory.java 
 * Purpose: A SuperHero object factory
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.0
 * @since 08-10-2019
 */
public class SuperHeroFactory {
	public static SuperHero buildHero(SuperHeroType type, int goodness) {
		SuperHero superHero = null;
		switch (type) {
			case GOODSTRONGMAN:
				superHero = new GoodStrongMan(goodness);
				break;
			case GOODFLYPERSON:
				superHero = new GoodFlyPerson(goodness);
				break;
			default:
				break;
		}
		return superHero;
	}
}
