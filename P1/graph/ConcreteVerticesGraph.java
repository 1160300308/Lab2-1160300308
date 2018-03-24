/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteVerticesGraph implements Graph<String> {
    
    private final List<Vertex> vertices = new ArrayList<>();
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    
    // TODO checkRep
    
    @Override public boolean add(String vertex) {
    	Map<String, Integer> map = new HashMap<>();
    	Vertex point = new Vertex(vertex, map);
    	for(int i=0;i<vertices.size();i++) {
    		if(vertices.get(i).getsource().equals(vertex)) {
    			return false;
    		}
    	}
    	vertices.add(point);
    	return true;
        //throw new RuntimeException("not implemented");
    }
    
    @Override public int set(String source, String target, int weight) {
    	Map<String, Integer> edge = new HashMap<>();
    	Map<String, Integer> map = new HashMap<>();
    	Vertex end = new Vertex(target, map);
    	edge.put(target,weight);
    	Vertex vertex = new Vertex(source, edge);
    	int flag1=0,flag2=0;
    	int preweight;
    	if(weight == 0) {
    		for(int i=0;i<vertices.size();i++) {
    			if(vertices.get(i).getsource().equals(source)) {
    				for(String obj: vertices.get(i).gettarget().keySet()) {
    					if(obj.equals(target)) {
    						vertices.get(i).gettarget().remove(obj);
    						return 0;
    					}
    				}
    			}
    		}
    	}
    	else {
    		for(int j=0;j<vertices.size();j++) {
    			if(vertices.get(j).getsource().equals(source)) {
    				flag1=1;
    			}
    			if(vertices.get(j).getsource().equals(target)) {
    				flag2=1;
    			}
    		}
    		if(flag1==0) {
    			if(flag2==0) {
    				vertices.add(end);
    			}
    			vertices.add(vertex);
    		}
    		else {
    			if(flag2==0) {
    				vertices.add(end);
    				for(int k=0;k<vertices.size();k++) {
    					if(vertices.get(k).getsource().equals(source)) {
    						vertices.get(k).gettarget().put(target, weight);
    						return 0;
    					}
    				}
    			}
    			else {
    				for(int i=0;i<vertices.size();i++) {
    					if(vertices.get(i).getsource().equals(source)) {
    						for(Map.Entry<String, Integer> obj: vertices.get(i).gettarget().entrySet()) {
    							if(obj.getKey().equals(target)) {
    								preweight = obj.getValue();
    								obj.setValue(weight);
    								return preweight;
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	return 0;
        //throw new RuntimeException("not implemented");
    }
    
    @Override public boolean remove(String vertex) {
    	int flag=0;
    	for(int i=0;i<vertices.size();i++) {
    		if(vertices.get(i).getsource().equals(vertex)) {
    			flag=1;
    			vertices.remove(i);
    		}	
    	}
    	if(flag == 0) {
    		return false;
    	}
    	for(int i=0;i<vertices.size();i++) {
    		for(String obj:vertices.get(i).gettarget().keySet()) {
    			if(obj.equals(vertex)) {
    				vertices.get(i).gettarget().remove(vertex);   				
    			}
    		}
    	}
    	return true;
        //throw new RuntimeException("not implemented");
    }
    
    @Override public Set<String> vertices() {
    	Set<String> vertex = new HashSet<>();
    	for(int i=0;i<vertices.size();i++) {
    		vertex.add(vertices.get(i).getsource());
    	}
    	return vertex;
        //throw new RuntimeException("not implemented");
    }
    
    @Override public Map<String, Integer> sources(String target) {
    	Map<String, Integer> source = new HashMap<>();
    	for(int i=0;i<vertices.size();i++) {
    		for(Map.Entry<String, Integer> obj: vertices.get(i).gettarget().entrySet()) {
    			if(obj.getKey().equals(target)) {
    				source.put(vertices.get(i).getsource(), obj.getValue());
    			}
    		}
    	}
    	return source;
        //throw new RuntimeException("not implemented");
    }
    
    @Override public Map<String, Integer> targets(String source) {
    	for(int i=0;i<vertices.size();i++) {
    		if(vertices.get(i).getsource().equals(source)) {
    			return vertices.get(i).gettarget();
    		}
    	}
    	return null;
        //throw new RuntimeException("not implemented");
    }
    
    @Override public String toString() {
    	int num=0;
    	for(int i=0;i<vertices.size();i++) {
    		num = num + vertices.get(i).gettarget().size();
    	}
    	String map = "this graph has " + vertices.size() + " vertexs and " + num + " edges";
    	return map;
    }
    // TODO toString()
    
}

/**
 * TODO specification
 * Mutable.
 * This class is internal to the rep of ConcreteVerticesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Vertex {
	
    private final String source;
    private Map<String, Integer> target = new HashMap<>();
    public Vertex(String source,Map<String, Integer> target) {
    	this.source = source;
    	this.target = target;
    }
    public String getsource() {
    	return source;
    }
    public Map<String, Integer> gettarget(){
    	return target;
    }
    public String toString() {
    	String vertex = "the vertex is " + source + " and it has " + target.size() + " adjacent vertexs";
    	return vertex;
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
