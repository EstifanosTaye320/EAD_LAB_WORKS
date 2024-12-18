package com.music.player;

public class HeadPhones implements OutputDeviceInterface{
	private String deviceName;
	private int soundVolume;
	
	public HeadPhones(String device) {
		this.deviceName = device;
	}
	
	@Override
	public void outputSound() {
		System.out.printf("%s used at volume %d\n", this.deviceName, this.soundVolume);
	}
	
	@Override
	public void setSoundVolume(int soundVolume) {
		this.soundVolume = soundVolume;
	}
}
