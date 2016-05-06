package main.java;

import processing.core.PApplet;
import java.util.*;
/**
* This class is used for the visualization of the network.
* Depending on your implementation, you might not need to use this class or create a class on your own.
* I used the class to draw the circle and re-arrange nodes and links.
* You will need to declare other variables.
*/
public class Network {
	
	private PApplet parent;
	
	private static float centerX = 700;
	private static float centerY = 300;
	private static float r = 250;
	
	private ArrayList<Character> net;

	public Network(PApplet parent){

		this.parent = parent;
		this.net = new ArrayList<>();
	}

	public void display(){
		this.parent.fill(0);
		this.parent.ellipse(centerX, centerY,r*2 , r*2);
	}
	
	public void add(Character ch){
		this.net.add(ch);
		ch.setInNetwork(true);
	}
	
	public void remove(Character ch){
		int index = 0;
		for(Character c :net){
			if(c == ch){
				net.remove(index);
				break;
			}
			index++;
		}
	}
	
	public void addAll(ArrayList<Character> list){
		this.net = list;
	}
	
	public void removeAll(){
		while(this.net.isEmpty()!=true){
			this.net.remove(0);
		}
	}
	
}
