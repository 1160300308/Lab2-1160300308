/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.events.EntityDeclaration;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph implements Graph<String> {
    
    private final Set<String> vertices = new HashSet<>();
    private final List<Edge> edges = new ArrayList<>();
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    
    // TODO checkRep
    
    @Override public boolean add(String vertex) {
    	if(vertices.contains(vertex)) {
    		return false;
    	}
    	vertices.add(vertex);
    	return true;
        //throw new RuntimeException("not implemented");
    }
    
	@Override public int set(String source, String target, int weight) {
    	Edge edge = new Edge(source,target,weight);
    	int preweight = 0;
    	if(weight == 0) {
    		for(int i=0;i<edges.size();i++) {
    			if(edges.get(i).getbegin().equals(source)&&edges.get(i).getend().equals(target)) {
    				edges.remove(i);
    				return 0;
    			}
    		}
    	}
    	else {
    		if(!vertices.contains(source)||!vertices.contains(target)) {
    			if(!vertices.contains(source)) {
        			vertices.add(source);
        		}
        		if(!vertices.contains(target)) {
        			vertices.add(target);
        		}
        		edges.add(edge);
        		return 0;
    		}
    		if(vertices.contains(source)&&vertices.contains(target)) {
    			for(int j=0;j<edges.size();j++) {
        			if(edges.get(j).getbegin().equals(source)&&edges.get(j).getend().equals(target)) {
        				preweight = edges.get(j).getlength();
        				edges.set(j, edge);
        				return preweight;
        			}
        		}

    		}
    	}
        //throw new RuntimeException("not implemented");
		return 0;
    }
    
    @Override public boolean remove(String vertex) {
    	if(!vertices.contains(vertex)) {
    		return false;
    	}
    	vertices.remove(vertex);
    	for(int i=0;i<edges.size();i++) {
    		if(edges.get(i).getbegin().equals(vertex)) {
    			edges.remove(i);
    		}
    		
    	}
    	for(int j=0;j<edges.size();j++) {
    		if(edges.get(j).getend().equals(vertex)) {
    			edges.remove(j);
    		}
    	}
    	return true;
        //throw new RuntimeException("not implemented");
    }
    
    @Override public Set<String> vertices() {
    	Set<String> vertex = new HashSet<>();
    	for(String obj : vertices) {
    		vertex.add(obj);
    	}
    	return vertex;
        //throw new RuntimeException("not implemented");
    }
    
    @Override public Map<String, Integer> sources(String target) {
    	Map<String, Integer> sources = new HashMap<>();
    	for(int i=0;i<edges.size();i++) {
    		if(edges.get(i).getend().equals(target)) {
    			sources.put(edges.get(i).getbegin(), edges.get(i).getlength());
    		}
    	}
    	return sources;
        //throw new RuntimeException("not implemented");
    }
    
    @Override public Map<String, Integer> targets(String source) {
    	Map<String, Integer> targets = new HashMap<>();
    	for(int i=0;i<edges.size();i++) {
    		if(edges.get(i).getbegin().equals(source)) {
    			targets.put(edges.get(i).getend(), edges.get(i).getlength());
    		}
    	}
    	return targets;
        //throw new RuntimeException("not implemented");
    }
    
    @Override public String toString() {
    	String graph = "this graph has " + vertices.size() + " vertexs and " + edges.size() + " edges";
    	return graph;
    }
    // TODO toString()
    
}

/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Edge {
    private final String begin;
    private final String end;
    private final int length;
    public Edge(String source,String target,int weight) {
		this.begin = source;
		this.end = target;
		this.length = weight;
	}
    public String getbegin() {
    	return begin;
    }
    public String getend() {
    	return end;
    }
    public int getlength() {
		return length;
	}
    public String toString() {
    	String edge = "this edge is from " + begin + " to " + end + " and the length is " + length;
    	return edge;
    }
    // TODO fields
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    
    // TODO checkRep
    
    // TODO methods
    
    // TODO toString()
    
}
