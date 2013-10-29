package com.junit;



import org.junit.*;

import com.slist.IntData;
import com.slist.SListNode;

public class SListNodeTest {

	IntData<Integer> data;
	SListNode sln ;
	@Before
	public void setUp() throws Exception {
		data = new IntData<Integer>();
	}
	
	@Test
	public void testNodeDataConstructor()
	{
		 sln = new SListNode();
		 
	}
	
	@Test
	public void testsetData()
	{
		data.setData(10);
		sln = new SListNode(data);
	}
	
	@Test
	public void testNodeDataParaConstructor()
	{
		data.setData(10);
		sln = new SListNode(data);
	}
	
	@Test
	public void testGetNodeValue()
	{
		data.setData(10);
		sln = new SListNode(data);
		data = sln.getNodeValue();
	}

	@Test
	public void testDisplayNode()
	{
		data.setData(10);
		sln = new SListNode(data);
		sln.displayNode(sln);
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
