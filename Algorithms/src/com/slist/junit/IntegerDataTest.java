package com.slist.junit;

import static org.junit.Assert.*;

import org.junit.*;

//import com.slist.Data;
import com.slist.IData;
import com.slist.IntData;

public class IntegerDataTest {
	IData<Integer> data;

	@Before
	public void setUp() throws Exception {
		data = new IntData<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		data = null;
	}

	@Test
	public void testData() {

		assertNotNull(data);

	}

	@Test
	public void testSetData() {
		 data.setData(10);
	}
	

	@Test
	public void testGetData() {
		data.setData(10);
		assertEquals(data.getData(),(Integer)10);
	}

	
}
