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
	
	private ArrayList<Character> net;

	public Network(PApplet parent){

		this.parent = parent;
		this.net = new ArrayList<>();
	}

	public void display(){
		
	}
	
	public void add(Character ch){
		this.net.add(ch);
		ch.setInNetwork(true);
	}
	
	public void remove(Character ch){
		
	}
	
	public void addAll(ArrayList<Character> list){
		
	}
	
	public void removeAll(){
		
	}
	
}
