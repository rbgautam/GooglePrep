package com.slist;

public class IntData<Integer>  implements IData<Integer> { //extends Data<Integer>

	private Integer value;
	
	@Override
	public  Integer getData(){
//		System.out.println("IntData get");
		return value;
	}
	
	@Override
	public void setData(Integer data) {
		value=data;

	}

}
