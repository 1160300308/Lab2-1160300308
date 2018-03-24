/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for ConcreteEdgesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteEdgesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteEdgesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteEdgesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteEdgesGraph();
    }
    
    /*
     * Testing ConcreteEdgesGraph...
     */
    
    // Testing strategy for ConcreteEdgesGraph.toString()
    //   TODO
    
    // TODO tests for ConcreteEdgesGraph.toString()
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
     * Testing Edge...
     */
    @Test
    public void testedge() {
    	final String source = "source";
    	final String target = "target";
    	final int weight = 5;
    	Edge edge = new Edge(source, target, weight);
    	assertEquals("expect get the source",source, edge.getbegin());
    	assertEquals("expect get the target",target, edge.getend());
    	assertEquals("expect get the length",weight, edge.getlength());
    	assertEquals("expect toString","this edge is from source to target and the length is 5", edge.toString());
    }
    // Testing strategy for Edge
    //   TODO
    
    // TODO tests for operations of Edge
    
}
