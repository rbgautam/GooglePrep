package com.slist;

public class SListHead {
	
	private static int size;
	private SListNode sln;
	
	public SListHead()
	{
		size=0;
	}
	
	public SListHead(SListNode sln)
	{
		size=0;
		this.sln=sln;
	}

	public boolean isEmpty(int size) {
		// TODO Auto-generated method stub
		return size==0;
	}

	public int ListSize() {
		// TODO Auto-generated method stub
		return size;
	}
}
