package com.slist.junit;


/**
 * Unit test cases for the implementation of a Singly-Linked List.
 *
 * @author  __your_name___
 */


import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import com.slist.SLinkedList;


public class SLinkedListTest
{
        /**
         * Lists for the three different configurations to test.
         */
        private SLinkedList empty;   // empty list
        private SLinkedList single;  // one-element list
        private SLinkedList multi;   // multi-element list


        /**
         * Re-initializes the lists for the three different configurations.
         * Called automatically by the JUnit framework before each of the
         * test methods below.
         */
        @Before
        public void setUp()
        {
		empty = new SLinkedList();   
//		String str = empty.toString(); // []
//		System.out.println(str);
		assertEquals( empty.toString(), "[]" );

                single = new SLinkedList();        // [8]
                single.addFirst(8);
                assertEquals( single.toString(), "[8 ]" );

                multi = new SLinkedList();         // [4 3 5 7 1 6]
                multi.addFirst(6);
                multi.addFirst(1);
                multi.addFirst(7);
                multi.addFirst(5);
                multi.addFirst(3);
                multi.addFirst(4);
                assertEquals( multi.toString(), "[4 3 5 7 1 6 ]");
        }
        
        /**
         * Test the isEmpty method.
         */
        @Test
        public void test_isEmpty()
        {
                assertTrue( empty.isEmpty() );

                assertTrue( !single.isEmpty() );

                assertTrue( !multi.isEmpty() );
        }

        /**
         * Test the addFirst method. The elements were added in *setUp*
         */
        @Test
        public void test_addFirst()
        {
                assertEquals( empty.toString(), "[]");

                assertEquals( single.toString(), "[8 ]");

                assertEquals( multi.toString(), "[4 3 5 7 1 6 ]");
        }

        /**
         * Test the addLast method.
         */
        @Test
        public void test_addLast()
        {
                empty.addLast( 4 );
                assertEquals( empty.toString(), "[4 ]");

                single.addLast( 7 );
                assertEquals( single.toString(), "[8 7 ]");

                multi.addLast( 9 );
                assertEquals( multi.toString(), "[4 3 5 7 1 6 9 ]");
        }

        /**
		 * Gets the item at the given index in the list.
         */
        @Test
        public void test_getNth()
        {
        	int found; 
        	found = empty.getNth(1);
        	assertEquals( found,Integer.MIN_VALUE);
        	found = empty.getNth(-1);
        	assertEquals( found,Integer.MIN_VALUE);
        	
        	found = single.getNth(-1);
        	assertEquals( found,Integer.MAX_VALUE);
        	found = single.getNth(0);
        	assertEquals( found, 8 );
        	
        	// "[4 3 5 7 1 6 ]"
        	found = multi.getNth(-1);
        	assertEquals( found,Integer.MAX_VALUE);
        	found = multi.getNth(0);
        	assertEquals( found, 4 );
        	found = multi.getNth(2);
        	assertEquals( found, 5 );
        	found = multi.getNth(5);
        	assertEquals( found, 6 );
        	found = multi.getNth(10);
        	assertEquals( found, Integer.MAX_VALUE );
        }
        
        /**
    	 * Adds the given item at the given index in the list.
    	 */
        @Test
        public void test_addAtNth()
        {
        	empty.addAtNth(1, 100 );
            assertEquals( empty.toString(), "[]");

            single.addAtNth(0, 7 );
            assertEquals( single.toString(), "[7 8 ]");

            multi.addAtNth(0, 9 );
            assertEquals( multi.toString(), "[9 4 3 5 7 1 6 ]");
            
            multi.addAtNth(4, 2 );
            assertEquals( multi.toString(), "[9 4 3 5 2 7 1 6 ]");
            
            multi.addAtNth(10, 8 );
            assertEquals( multi.toString(), "[9 4 3 5 2 7 1 6 ]");
            
            
        }

        /**
    	 * Replaces the node at the given index in the list 
    	 * with the given item returns the previous item at that index.
    	 * 
    	 */
    	@Test
    	public void test_replace()
    	{
    		int result=9999;
    		//Empty List
    		result = empty.replaceNth(0,100);
    		assertEquals(empty.toString(),"[]");
    		assertEquals(result,Integer.MIN_VALUE);
    		
    		//Single List
    		result = single.replaceNth(-1,100);
    		assertEquals(result,Integer.MIN_VALUE);
    		assertEquals(single.toString(),"[8 ]");
    		
    		result = single.replaceNth(0,100);
    		assertEquals(single.toString(),"[100 ]");
    		assertEquals(result,Integer.MAX_VALUE);
    		
    		result = single.replaceNth(1,500);
    		assertEquals(single.toString(),"[100 ]");
    		assertEquals(result,Integer.MIN_VALUE);
    		
    		//multi List "[4 3 5 7 1 6 ]"
    		
    		result = multi.replaceNth(0,100);
    		assertEquals(multi.toString(),"[100 3 5 7 1 6 ]");
    		assertEquals(result,Integer.MAX_VALUE);
    		
    		result = multi.replaceNth(3,500);
    		assertEquals(multi.toString(),"[100 3 5 500 1 6 ]");
    		assertEquals(result,Integer.MAX_VALUE);
    		
    		result = multi.replaceNth(5,200);
    		assertEquals(multi.toString(),"[100 3 5 500 1 200 ]");
    		assertEquals(result,Integer.MAX_VALUE);
    		
    		result = single.replaceNth(6,500);
    		assertEquals(multi.toString(),"[100 3 5 500 1 200 ]");
    		assertEquals(result,Integer.MIN_VALUE);
    	}
	
    	/**
    	 * Determines if the list contains the given item.
    	 */
    	@Test
    	public void test_contains()
    	{
    		boolean result;
    		
    		result = empty.contains(1);
    		assertFalse(result);	
    		
    		result =single.contains(1);
    		assertFalse(result);	
    		result =single.contains(8);
    		assertTrue(result);	
    		
    		// [4 3 5 7 1 6]
    		result =multi.contains(-1);
    		assertFalse(result);
    		result =multi.contains(4);
    		assertTrue(result);	
    		result =multi.contains(5);
    		assertTrue(result);
    		result =multi.contains(1);
    		assertTrue(result);
    		result =multi.contains(7);
    		assertTrue(result);
    		result =multi.contains(6);
    		assertTrue(result);	
    		result =multi.contains(8);
    		assertFalse(result);
    		
    	}

    	/**
    	 * Clears all the elements in the list 
    	 */
    	@Test
		public void test_clear(){
    		empty.clear();
    		assertEquals(empty.toString(),"[]");
    		
    		single.clear();
    		assertEquals(single.toString(),"[]");
    		
    		multi.clear();
    		assertEquals(multi.toString(),"[]");
    	}
}
