/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * Tests for ConcreteVerticesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteVerticesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteVerticesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteVerticesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteVerticesGraph();
    }
    
    /*
     * Testing ConcreteVerticesGraph...
     */
    
    // Testing strategy for ConcreteVerticesGraph.toString()
    //   TODO
    
    // TODO tests for ConcreteVerticesGraph.toString()
    @Test 
    public void testtarget() {
    	Graph<String> graph = emptyInstance();
    	final String vertex1 = "1";
    	final String vertex2 = "2";
    	final String vertex3 = "3";
    	final String vertex4 = "4";
    	final String vertex5 = "5";
    	graph.set(vertex1, vertex2, 5);
    	graph.set(vertex1, vertex3, 4);
    	graph.set(vertex1, vertex4, 3);
    	graph.set(vertex1, vertex5, 2);
    	assertEquals("expect the num of edges",4, graph.targets(vertex1).size());
    	assertEquals("this graph has 5 vertexs and 4 edges" , graph.toString());
    }
    /*
     * Testing Vertex...
     */
    @Test
    public void testvertex() {
    	final String source = "source";
    	final String vertex1 = "1";
    	final String vertex2 = "2";
    	final String vertex3 = "3";
    	Map<String, Integer> map = new HashMap<>();
    	map.put(vertex1, 5);
    	map.put(vertex2, 6);
    	map.put(vertex3, 7);
    	Vertex vertex = new Vertex(source, map);
    	assertEquals("expect get the source",source, vertex.getsource());
    	assertEquals("expect get the target",map, vertex.gettarget());
    	assertEquals("expect toString","the vertex is source and it has 3 adjacent vertexs" ,vertex.toString());
    }
    // Testing strategy for Vertex
    //   TODO
    
    // TODO tests for operations of Vertex
    
}
