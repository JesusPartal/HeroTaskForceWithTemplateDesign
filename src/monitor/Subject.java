package monitor;

/**
 * Subject.java 
 * @author jesus.partal@mycit.ie
 * @author Jesus Partal
 * @version 1.0
 * @since 18-10-2019
 */
public interface Subject {
	public void attach(Observer o);
	public void detach(Observer o);
	public void notify(String filename);
}