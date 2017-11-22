
package gt.edu.url.prefinal.problema3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author tuxtor
 */
public class CategoriaCartas<E> {
    
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;// Anterior
		private Node<E> next;// Siguiente

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() throws IllegalStateException {
			if (next == null) // Nodo no valido
				throw new IllegalStateException("Posicion invalida");
			return element;
		}
		
		public void setElement(E e) {
			element = e;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

	}
        
       



	private Node<E> header = null;// Referencia
	private Node<E> trailer = null;
	private int size = 1;

	public CategoriaCartas() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	// Metodos internos
	/**
	 * Valida si una posicion contiene un nodo y el nodo existe
	 */
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("P invalido");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getNext() == null)
			throw new IllegalArgumentException("p ya no se encuentra en la lista");
		return node;
	}
	
	/**
	 * "Empaca" un nodo como posicion a menos que sea header o trailer
	 */
	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null; // do not expose user to the sentinels
		return node;
	}

	// ---

	public int size() {return size;}

	public boolean isEmpty() {return size == 0;}

	public Position<E> first( ) {
		return position(header.getNext());
	}

	public Position<E> last( ) {
		return position(trailer.getPrev());
	}
	
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		succ.setPrev(newest);
		pred.setNext(newest);
		size++;
		return newest;
	}
	
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}
	
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}
	
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{ 
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}
	
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}
	  public void ShowElements(){
	        Node <E> hd = header;
	        
	        while(hd.getNext()!=null){
	        	if(hd.getElement() != null) {
	        		 System.out.println(hd.getElement()); 
	        	}  
	        	try {
	        		if(hd.getNext() != null) {
		        		hd=hd.getNext();
		        	}	
	        	}
	        	catch(Exception e){
	        		return;
	        	}
	        
	        	
	        }
	        
	    }

    public  void swap(Position<E> p, Position<E> q) {
    	Node a, b;
    	Object temp;
       a = header;
    	b = a;
    	
    	while(a.getElement() != p.getElement()) {
    		a = a.next;
    	}
    	
    	while(b.getElement() != q.getElement()) {
    		b = b.next;
    	}
    	temp = a.getElement();
    	a.element = b.getElement();
    	b.element = temp;

    }
    
    Position<E> getPosition;
    public Position<E> positionAtIndex(int i){
    	
    	Node position;
    	
    	position = header;
    	
    	for(int j = 0; j < i; j ++) {
    		getPosition = position.next;
    	}
    	return getPosition;
    }
}
