import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Vertice {
	private String name;
	private ArrayList<Vertice> neighbours;
	private HashMap<Vertice, Integer> adjacentVertices;
	private int capacity;
	private Vertice parent;
	private int level;
	private boolean ifVisited;
	public Vertice(String name, int Capacity) {
		this.name = name;
		this.adjacentVertices = new HashMap<Vertice, Integer>();
		this.capacity = Capacity;
		this.level = -1;
		this.ifVisited = false;
		this.neighbours = new ArrayList<Vertice>();
		}
	
	public void addConnection(Vertice vertice, int capacity) {
		this.adjacentVertices.put(vertice, capacity);
		this.neighbours.add(vertice);
		
	}
	public boolean getifVisited() {
		return ifVisited;
	}
	
	public void setifVisited(boolean ifVisited) {
		this.ifVisited = ifVisited ;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Vertice getParent() {
		return parent;
	}
	public void setParent(Vertice parent) {
		this.parent = parent;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAdjacentVertices(HashMap<Vertice, Integer> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}
	public Map<Vertice, Integer> getAdjacentVertices() {
		return adjacentVertices;
	}
	public ArrayList<Vertice> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(ArrayList<Vertice> neighbours) {
		this.neighbours = neighbours;
	}
	
}
