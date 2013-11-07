package com.slist.junit;


/**
 * Unit test cases for the implementation of a Singly-Linked List.
 *
 * @author  __your_name___
 */


import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
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
		String str = empty.toString(); // []
		System.out.println(str);
		assertEquals( empty.toString(), "[]" );

                single = new SLinkedList();        // [8]
                single.addFirst(8);
                assertEquals( single.toString(), "[8]" );

                multi = new SLinkedList();         // [4 3 5 7 1 6]
                multi.addFirst(6);
                multi.addFirst(1);
                multi.addFirst(7);
                multi.addFirst(5);
                multi.addFirst(3);
                multi.addFirst(4);
                assertEquals( multi.toString(), "[4 3 5 7 1 6]");
        }


        /**
         * Test the addFirst method. The elements were added in *setUp*
         */
        @Test
        public void test_addFirst()
        {
                assertEquals( empty.toString(), "[]");

                assertEquals( single.toString(), "[8]");

                assertEquals( multi.toString(), "[4 3 5 7 1 6]");
        }


        /**
         * Test the addLast method.
         */
        @Test
        public void test_addLast()
        {
                empty.addLast( 4 );
                assertEquals( empty.toString(), "[4]");

                single.addLast( 7 );
                assertEquals( single.toString(), "[8 7]");

                multi.addLast( 9 );
                assertEquals( multi.toString(), "[4 3 5 7 1 6 9]");
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
	 * Test the getFirst() method.
	 */
        @Test
	public void test_getFirst()
        {
		// call the method that is expected to throw an exception; if the 
		// method did not throw the expected exception, will get to fail()
	        try { empty.getFirst(); fail(); }
                catch (NoSuchElementException e) { /* test passed */ }
				   	     
						
		// test cases for other configurations (single, multi)
		//
		// ...	
	}
}
