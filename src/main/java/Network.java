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
	private int radius = 360;
	private int nowInNet;
	
	private ArrayList<Character> net;

	public Network(PApplet parent){

		this.parent = parent;
		this.net = new ArrayList<>();
	}

	public void display(){
		this.parent.fill(0);
		this.parent.ellipse(centerX, centerY,r*2 , r*2);
		this.parent.fill(255);
		this.parent.ellipse(centerX, centerY, 490, 490);
		
		for(Character ch : net){
			if(ch.getInNetwork()==true)
				System.out.println(ch.getName());
			for(Character t : ch.getTargets()){
				this.parent.fill(255);
				if(t.getInNetwork()==true){
					this.parent.line(ch.getCenterX(), ch.getCenterY(), t.getCenterX(), t.getCenterY());
				}
			}
		}
	}
	
	public void add(Character ch){
		this.nowInNet++;
		this.net.add(ch);
		ch.setInNetwork(true);
	}
	
	public void remove(Character ch){
		int index = 0;
		for(Character c :net){
			if(c == ch){
				this.nowInNet--;
				net.remove(index);
				ch.setInNetwork(false);
				ch.initial();
				break;
			}
			index++;
		}
	}
	
	public void update(){
		int radiusrate = 0;
		if(this.nowInNet != 0)
			radiusrate = this.radius / this.nowInNet;
		int i = 0;
		for(Character c : net){
			float fx = (float)250.0* (float)Math.cos(Math.toRadians(i));
			c.setCenterX(this.centerX + fx);
			float fy = (float)250.0* (float)Math.sin(Math.toRadians(i));
			c.setCenterY(this.centerY + fy);
			i = i + radiusrate;
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
