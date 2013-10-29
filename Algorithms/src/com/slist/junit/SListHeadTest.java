package com.slist.junit;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.slist.SListHead;
import com.slist.SListNode;

public class SListHeadTest {

	int size;
	SListHead head;
	@Before
	public void setUp() throws Exception {
		 head = new SListHead();
	}

	@Test
	public void testIsEmpty(){
		size=0;
		boolean res;
		res = head.isEmpty(size);
		assertTrue(res);
	}
	
	@Test
	public void testListSize(){
		size=head.ListSize();
	}


	@After
	public void tearDown() throws Exception {
	}

}
