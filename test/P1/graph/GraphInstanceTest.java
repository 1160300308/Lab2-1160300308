/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * Tests for instance methods of Graph.
 * 
 * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
 * methods to this class, or change the spec of {@link #emptyInstance()}.
 * Your tests MUST only obtain Graph instances by calling emptyInstance().
 * Your tests MUST NOT refer to specific concrete implementations.
 */
public abstract class GraphInstanceTest {
    
    // Testing strategy
    //   TODO
    
    /**
     * Overridden by implementation-specific test classes.
     * 
     * @return a new empty graph of the particular implementation being tested
     */
    public abstract Graph<String> emptyInstance();
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testInitialVerticesEmpty() {
        // TODO you may use, change, or remove this test
        assertEquals("expected new graph to have no vertices",
                Collections.emptySet(), emptyInstance().vertices());
    }
    @Test
    public void testaddvertex() {
    	Graph<String> graph = emptyInstance();
    	final String vertex1 = "1";
    	final String vertex2 = "2";
    	final String vertex3 = "3";
    	final String vertex4 = "4";
    	final String vertex5 = "5";
    	graph.add(vertex1);
    	graph.add(vertex2);
    	graph.add(vertex3);
    	graph.add(vertex4);
    	assertEquals("expect the num of the vertex",4,graph.vertices().size());
    	assertEquals(false, graph.add(vertex1));
    	assertEquals(true, graph.add(vertex5));
    }
    
    @Test
    public void testset() {
    	Graph<String> graph = emptyInstance();
    	final String vertex1 = "1";
    	final String vertex2 = "2";
    	final String vertex3 = "3";
    	final String vertex4 = "4";
    	final String vertex5 = "5";
    	final String vertex6 = "6";
    	final String vertex7 = "7";
    	graph.set(vertex1, vertex2, 3);
    	graph.set(vertex2, vertex4, 4);
    	graph.set(vertex5, vertex2, 6);
    	graph.set(vertex3, vertex4, 5);
    	graph.set(vertex3, vertex4, 0);
    	graph.set(vertex1, vertex6, 7);
    	assertEquals("expect the num of vertexs",6, graph.vertices().size());
    	assertEquals("remove the edge",0,graph.targets(vertex3).size());
    	assertEquals("add the source to the graph",true,graph.vertices().contains(vertex5));
    	assertEquals("add the target to the graph",true,graph.vertices().contains(vertex6));
    	assertEquals("expect return 0",0,graph.set(vertex1, vertex3, 0));
    	assertEquals("expect return 0",0,graph.set(vertex2, vertex7, 4));
    	assertEquals("expect return preweight",4,graph.set(vertex2, vertex4, 5));
    }
    
    @Test
    public void testremove() {
    	Graph<String> graph = emptyInstance();
    	final String vertex1 = "1";
    	final String vertex2 = "2";
    	final String vertex3 = "3";
    	final String vertex4 = "4";
    	graph.set(vertex1, vertex2, 4);
    	graph.set(vertex2, vertex3, 6);
    	graph.remove(vertex2);
    	assertEquals("expect return false",false, graph.remove(vertex4));
    	assertEquals("remove the vertex",2,graph.vertices().size() );
    	assertEquals("remove the edge",0, graph.sources(vertex3).size());
    	assertEquals("remove the edge",0, graph.targets(vertex1).size());
    	assertEquals("expect return true",true, graph.remove(vertex1) );
    }
    
    @Test
    public void testvertex() {
    	Graph<String> graph = emptyInstance();
    	final String vertex1 = "1";
    	final String vertex2 = "2";
    	final String vertex3 = "3";
    	final String vertex4 = "4";
    	final String vertex5 = "5";
    	graph.add(vertex5);
    	graph.set(vertex1, vertex3, 4);
    	graph.set(vertex4, vertex2, 5);
    	assertEquals("expect the num of vertex",5, graph.vertices().size());
    }
    
    @Test 
    public void testsource() {
    	Graph<String> graph = emptyInstance();
    	final String vertex1 = "1";
    	final String vertex2 = "2";
    	final String vertex3 = "3";
    	final String vertex4 = "4";
    	final String vertex5 = "5";
    	graph.set(vertex2, vertex1, 5);
    	graph.set(vertex3, vertex1, 4);
    	graph.set(vertex4, vertex1, 3);
    	graph.set(vertex5, vertex1, 2);
    	assertEquals("expect the num of edges",4, graph.sources(vertex1).size());
    	assertEquals("this graph has 5 vertexs and 4 edges" , graph.toString());
    }
    
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
}   	