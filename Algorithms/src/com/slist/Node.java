package com.slist;




public class Node {
	private IntData data;	// the data value stored at the node
	public Node next;				// the successor of this node
	
	/** Creates null node
	 * 
	 */
	/* TODO I don't see use of non parameterized constructor here */
	public Node()
	{
		
		data = new IntData();
		data.setData(Integer.MIN_VALUE);
		next=null;
	}
	
	/** creates a node with the given data item and no successor
	 * 
	 * @param intdata
	 */
	public Node(Integer intdata) {
		data = new IntData();
		setData(intdata);
		next=null;
	}



	public void setData(Integer intdata) {
		data.setData(intdata);
	}

	public IntData getData() {
		return data;
	}
	
	

}
