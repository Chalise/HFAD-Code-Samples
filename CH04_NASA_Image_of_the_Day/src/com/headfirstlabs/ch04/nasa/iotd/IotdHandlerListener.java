package com.headfirstlabs.ch04.nasa.iotd;

public interface IotdHandlerListener {
	
	public void iotdParsed(String url, String title, String description, String date);

}
