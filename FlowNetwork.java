import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class FlowNetwork {
	int maxFlow = 0;
	ArrayList<Vertice> pathVertices = new ArrayList<Vertice>();
	Vertice sink;
	Vertice source;
	int minCapacity = Integer.MAX_VALUE;
	public FlowNetwork(Vertice sink, Vertice source) {
		this.sink = sink;
		this.source = source;
	}
	public boolean BFS(Vertice sink, Vertice source) {
		Queue<Vertice> unvisitedVertices = new LinkedList<Vertice>();
		Set<Vertice> visitedVertices = new HashSet<Vertice>();
		source.setLevel(0);
		unvisitedVertices.add(source);
		while(unvisitedVertices.size() != 0) {
			Vertice currentVertice = unvisitedVertices.poll();
			visitedVertices.add(currentVertice);
			if(sink == currentVertice) {
				return true;
			}
			ArrayList<Vertice> adjacents = currentVertice.getNeighbours();
			for(int aa = 0; aa < adjacents.size(); aa++) {
				Vertice next = adjacents.get(aa);
				if(!visitedVertices.contains(next) && (!unvisitedVertices.contains(next))) {
					next.setLevel(currentVertice.getLevel()+1);
					unvisitedVertices.add(next);
				}
			}
			
			
		}
		return false;
	}
	
	public boolean findMinFlow(Vertice sink, Vertice source) {
		Set<Vertice> visitedVertices = new HashSet<Vertice>();
		Deque<Vertice> stack = new ArrayDeque<>();
		stack.push(source);
		while(!stack.isEmpty()) {
			Vertice current = stack.poll();
			visitedVertices.add(current);
			if(current == sink) {
				while(current!=null) {
					this.pathVertices.add(current);
					if(current.getParent() != null && current.getParent().getAdjacentVertices().get(current) < minCapacity) {
						minCapacity = current.getParent().getAdjacentVertices().get(current);
					}
					current = current.getParent();
					
				}
				return true;
			}
			ArrayList<Vertice> adjacents2 = current.getNeighbours();
			for(int aaa = 0; aaa < adjacents2.size(); aaa++) {
				Vertice next2 = adjacents2.get(aaa);
				if((next2.getLevel() == current.getLevel()+1) && (!visitedVertices.contains(next2))){
					stack.push(next2);
					next2.setParent(current);
					
				}
			}
	
		}
		return false;
	}
	
	
	public int MaxFlow() {
		while(BFS(this.sink, this.source)) {
			while(findMinFlow(this.sink, this.source)) {
				for(int b = this.pathVertices.size()-1; b > 0; b--) {
					this.pathVertices.get(b).getAdjacentVertices().replace(this.pathVertices.get(b-1), this.pathVertices.get(b).getAdjacentVertices().get(this.pathVertices.get(b-1))-minCapacity);
					if(this.pathVertices.get(b).getAdjacentVertices().get(this.pathVertices.get(b-1)) == 0) {
						this.pathVertices.get(b).getNeighbours().remove(this.pathVertices.get(b-1));
					}
					if(this.pathVertices.get(b-1).getNeighbours().contains(this.pathVertices.get(b))) {
						this.pathVertices.get(b-1).getAdjacentVertices().replace(this.pathVertices.get(b), this.pathVertices.get(b-1).getAdjacentVertices().get(this.pathVertices.get(b))+minCapacity);	
					}
					else {
						this.pathVertices.get(b-1).getAdjacentVertices().put(this.pathVertices.get(b),minCapacity);
						this.pathVertices.get(b-1).getNeighbours().add(this.pathVertices.get(b));
					}
				}
				maxFlow += minCapacity;
				pathVertices.clear();
				this.minCapacity = Integer.MAX_VALUE;
			}
			
			
		}
		return maxFlow;
		
	}

}