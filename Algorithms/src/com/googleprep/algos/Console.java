package com.googleprep.algos;


public class Console {
	private static Console instance = null;
	private KeyboardInput data = new KeyboardInput(new String());
	private Console() {
		
		//System.out.println(ReadXML.ReadTopMenu("Menu"));
	}

	public static Console CreateConsole(){
		if (instance==null)
			instance=new Console();
		
		return instance;
	}

	public void setData(KeyboardInput data) {
		this.data = data;
	}

	public String getData() {
		return data.getStrUserInput();
	}
	

}
