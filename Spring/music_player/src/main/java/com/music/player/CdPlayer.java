package com.music.player;

public class CdPlayer implements MusicPlayerInterface{
	private OutputDeviceInterface outputDevice;
	
	@Override
	public void play() {
		System.out.println("Playing using CD player");
		outputDevice.outputSound();
	}

	@Override
	public void stop() {
		System.out.println("Pause using CD player\n");				
	}

	@Override
	public void setOutputDevice(OutputDeviceInterface device) {
		this.outputDevice = device;
	}

}
