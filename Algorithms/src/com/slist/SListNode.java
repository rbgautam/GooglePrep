package com.slist;

public class SListNode {

	private IntData<Integer> data;
	private SListNode next;
	
	public SListNode(){
		data=null;
		next=null;
	}
	public SListNode(IntData<Integer> data) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.next=null;
	}
	public IntData<Integer> getNodeValue() {
		// TODO Auto-generated method stub
		return this.data;
	}
	public void displayNode(SListNode sln) {
		// TODO Auto-generated method stub
		System.out.println(sln.data.getData());
	}
}
	