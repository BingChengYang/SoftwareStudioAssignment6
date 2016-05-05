package main.java;

import processing.core.PApplet;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {

	private MainApplet parent;
	
	private String name;
	private int value;
	private Color c;
	
	private int centerX;
	private int centerY;

	private ArrayList<Character> targets;
	
	public Character(MainApplet parent , String name , int value ){

		this.parent = parent;
		this.name = name;
		this.value = value;
		
		this.targets = new ArrayList<>();
	}

	public void display(){

	}
	
}
