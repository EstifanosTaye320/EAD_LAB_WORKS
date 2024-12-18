package com.music.player;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MusicPlayerApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beansConfig.xml");
		MusicPlayerInterface mp3Player = context.getBean("mp3", MusicPlayerInterface.class);
		mp3Player.play();
		mp3Player.stop();
		
		MusicPlayerInterface cdPlayer = context.getBean("cd", MusicPlayerInterface.class);
		cdPlayer.play();
		cdPlayer.stop();
	}

}
