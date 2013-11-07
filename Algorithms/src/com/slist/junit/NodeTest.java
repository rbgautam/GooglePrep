/**
 * 
 */
package com.slist.junit;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.slist.IntData;
import com.slist.Node;

/**
 * @author rgautam
 *
 */
public class NodeTest {

	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testNode()
	{
		int data =1;
		Node node = new Node(data);
		data=node.getData().getData();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
