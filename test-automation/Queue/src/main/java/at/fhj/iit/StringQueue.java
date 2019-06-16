package at.fhj.iit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE

/**
 * Die StringQueue, implementiert die Queue-Schnittstelle und speichert eine Liste von Strings.
 * Die Klasse hat zwei Konstruktoren. Der erste ohne Parameter, dann wird die maxSize auf 5 gesetzt.
 * Der zweite Konstruktor akzeptiert eine ganze Zahl für die maxSize.
 * Die Methode <code>peek()</code> gibt das erste Element zurück, ohne es aus der Warteschlange zu entfernen, wenn die Warteschlange leer ist, gibt sie Null zurück.
 * Die Methode <code>poll()</code> gibt das erste Element zurück und löscht es, wenn die Warteschlange leer ist, gibt sie Null zurück.
 * Die Methode <code>remove()</code> gibt das erste Element zurück und löscht es, wenn die Warteschlange leer ist, löst sie eine {@link NoSuchElementException} aus.
 * Die Methode <code>element()</code> gibt das erste Element zurück, ohne es aus der Warteschlange zu entfernen, wenn die Warteschlange leer ist, wirft sie eine {@link NoSuchElementException}.
 *
 * @author Wieser, Ranzenbacher
 * @seit dem 14.06.2019
 */
public class StringQueue implements Queue {

	private static final Logger logger = LogManager.getLogger(StringQueue.class);
	private List<String> elements = new ArrayList<String>();
	private int maxSize = 5;

	/**
	 * Constructor without parameter. The maxSize of this instance is set to {@link StringQueue#maxSize}.
	 */
	public StringQueue(){
		this.maxSize = maxSize;
	}
	/**
	 * Constructor with one int parameter. The maxSize of this instance is set to the parameter value.
	 * @param maxSize int
	 */
	public StringQueue(int maxsize){
		this.maxSize = maxSize;
	}

	/**
	 *	Offer is adding a String to the queue until the maxSize is reached.
	 * @param obj 	This String is added to the queue
	 * @return boolean If the size() of the queue is less then the maxSize, it return true another false.
	 */
	@Override
	public boolean offer(String obj) {

		logger.info("offer: method adds String to queue");
		if(elements.size()!= maxSize) {
			elements.add(obj);
		} else {
			logger.error("Stack is full!");
			return false;
		}
			return true;
	}

	/**
	 * Poll returns the first element of the queue and remove the element from the queue,
	 * if the queue is empty the method return null.
	 * The first element is selected with the {@link StringQueue#peek()} method.
	 * @return String The first element in the queue, if the queue is empty it return null.
	 */
	@Override
	public String poll() {

		logger.info("poll: returns head of list and deletes it afterwards");
		String element = peek();
		
		if(elements.size() > 0) {
			elements.remove(0);
		}
		return element;
	}

	/**
	 *	Remove returns the first element in the queue and deletes the element. If the queue is empty the method thows {@link NoSuchElementException}.
	 *	The first element is selected and removed with the {@link StringQueue#poll()} method.
	 * @return String The first element in the queue, if the queue is empty it throws a {@link NoSuchElementException}.
	 * @exception NoSuchElementException If the queue is empty.
	 */
	@Override
	public String remove() {

		logger.info("returns head of list and deletes value afterwards");
		String element = poll();		
		//element = "";
		if(element == null) {
			logger.error("throws NoSuchElementException");
			throw new NoSuchElementException("there's no element any more");
		}
		return element;
	}

	/**
	 *	Peek returns the first element of the queue without deleting the element, if the queue is empty the method return null;
	 * @return String The first element in the queue, if the queue is empty it return null.
	 */
	@Override
	public String peek() {

		logger.info("returns the value of head from list");
		String element;
		if(elements.size() > 0) {
			element = elements.get(0);
		} else {
			element = null;
		}
		return element;
	}

	/**
	 *	Element returns the first element of the queue without deleting the element, if the queue is empty the method throws {@link NoSuchElementException};
	 * @return String The first element in the queue, if the queue is empty the method throws {@link NoSuchElementException}.
	 * @exception NoSuchElementException If the element returned from {@link StringQueue#peek()} equals null.
	 */
	@Override
	public String element() {

		logger.info("returns the value of head");
		String element = peek();
		if(element == null) {
			logger.error("throws NoSuchElementException");
			throw new NoSuchElementException("there's no element any more");
		}
		return element;
	}

}