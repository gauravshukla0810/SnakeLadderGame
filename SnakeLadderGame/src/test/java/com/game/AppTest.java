package com.game;

import org.junit.Test;

public class AppTest {

	@Test
	public void playSnakeGame() {
		String args[] = new String[100];
		args[0] = "1"; // chosse dice type
		args[1] = "1"; // choose if you want to add snake or not
		args[2] = "6"; // snake start poisiton
		args[3] = "1";// snake end position
		args[4] = "2";// you WANT TO ADD MORE SNAKE OR NOT - 2 means no
		args[5] = "2";// play more
		args[6] = "2";//play more
		args[7] = "2";// play more
		args[8] = "2";//play more
		args[9] = "2";// play more
		args[10] = "2";//play more
		args[11] = "2";// play more
		args[12] = "2";//play more
		args[13] = "2";//play more
		args[14] = "2";//play more
		args[15] = "2";//play more
		args[16] = "2";//play more
		args[17] = "2";//play more
		args[18] = "2";//play more
		args[19] = "2";//play more
		args[20] = "1";// exit
		SnakeLadder.main(args);
	}

}