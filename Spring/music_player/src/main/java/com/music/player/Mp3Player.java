package com.music.player;

public class Mp3Player implements MusicPlayerInterface{
	private OutputDeviceInterface outputDevice;

	@Override
	public void play() {
		System.out.println("Playing using MP3 player");
		outputDevice.outputSound();
	}

	@Override
	public void stop() {
		System.out.println("Pause using MP3 player\n");				
	}

	@Override
	public void setOutputDevice(OutputDeviceInterface device) {
		this.outputDevice = device;
	}

}
