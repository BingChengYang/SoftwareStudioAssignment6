package main.java;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;
import controlP5.*;

/**
* This class is for sketching outcome using Processing
* You can do major UI control and some visualization in this class.  
*/
@SuppressWarnings("serial")
public class MainApplet extends PApplet{
	
	JSONObject data;
	JSONArray nodes, links;
	
	private Network net;
	
	private String path = "main/resources/";
	private String[] str;
	private String file1 = "starwars-episode-1-interactions.json";
	private ArrayList<Character> characters1;
	private ArrayList<Character> characters2;
	private ArrayList<Character> characters3;
	private ArrayList<Character> characters4;
	private ArrayList<Character> characters5;
	private ArrayList<Character> characters6;
	private ArrayList<Character> characters7;
	public ArrayList<Character> nowcharacters;
	public int nowEpisode = 0;
	public int record = 0;
	
	private ControlP5 cp5;
	
	private final static int width = 1200, height = 650;
	
	public void setup() {
		str = new String[7];
		size(width, height);
		cp5 = new ControlP5(this);
		cp5.addButton("buttonA").setLabel("Add all").setPosition(950,40).setSize(200,30);
		cp5.addButton("buttonB").setLabel("Clear all").setPosition(950,80).setSize(200,30);
		net = new Network(this);
		characters1 = new ArrayList<Character>();
		characters2 = new ArrayList<Character>();
		characters3 = new ArrayList<Character>();
		characters4 = new ArrayList<Character>();
		characters5 = new ArrayList<Character>();
		characters6 = new ArrayList<Character>();
		characters7 = new ArrayList<Character>();
		setInputFilename();
		smooth();
		loadData();
		
	}

	public void draw() {
		this.getCharacterList();
		this.background(255);
		int episodenum = this.nowEpisode + 1;
		fill(76);
		textSize(26);
		text("star war " + episodenum,500,60);
		this.net.display();
		for(int i=0; i< this.nowcharacters.size(); i++){
			this.nowcharacters.get(i).display();
		}
		for(int i=0; i < this.nowcharacters.size(); i++){
			if(this.nowcharacters.get(i).getDistance(mouseX, mouseY) < 625){
				this.fill(115);
				this.rect(mouseX, mouseY - 30, 150, 30);
				this.fill(0);
				this.textSize(20);
				this.text(this.nowcharacters.get(i).getName(), mouseX + 10, mouseY - 10);
			}
		}
		
		/*if(mouseX < 110 && mouseX > 0 && mouseY > 0 && mouseY < 120){
			this.fill(115);
			this.rect(mouseX, mouseY, 50, 30);
			//this.fill(0);
			this.text(this.nowcharacters.get(0).getName(), mouseX + 5, mouseY + 5);
		}*/
	}
	
	public void buttonA(){
		for(int i=0 ; i< this.nowcharacters.size(); i++){
			if(this.nowcharacters.get(i).getInNetwork() == false){
				this.net.add(this.nowcharacters.get(i));
			}
		}
		this.net.update();
	}
	
	public void buttonB(){
		for(int i=0; i < this.nowcharacters.size(); i++){
			if(this.nowcharacters.get(i).getInNetwork() == true){
				this.net.remove(this.nowcharacters.get(i));
			}
		}
		this.net.update();
	}
	
	public void keyPressed(){
		this.buttonB();
		if(keyCode == 49){
			this.nowEpisode = 0;
		}else if(keyCode == 50){
			this.nowEpisode = 1;
		}else if(keyCode == 51){
			this.nowEpisode = 2;
		}else if(keyCode == 52){
			this.nowEpisode = 3;
		}else if(keyCode == 53){
			this.nowEpisode = 4;
		}else if(keyCode == 54){
			this.nowEpisode = 5;
		}else if(keyCode == 55){
			this.nowEpisode = 6;
		}
	}
	
	public void mouseClicked(){
		for(int i=0; i < this.nowcharacters.size(); i++){
			if(this.nowcharacters.get(i).getDistance(mouseX, mouseY) < 625 && this.nowcharacters.get(i).getInNetwork()==false){
				this.net.add(this.nowcharacters.get(i));
				this.net.update();
				System.out.println("aaa");
			}
			if(this.nowcharacters.get(i).getDistance(mouseX, mouseY) < 625 && this.nowcharacters.get(i).getInNetwork()==true){
				this.net.remove(this.nowcharacters.get(i));
				System.out.println("bbb");
			}
		}
	}
	
	private void getCharacterList(){
		if(this.nowEpisode == 0)
			this.nowcharacters = this.characters1;
		else if(this.nowEpisode == 1)
			this.nowcharacters = this.characters2;
		else if(this.nowEpisode == 2)
			this.nowcharacters = this.characters3;
		else if(this.nowEpisode == 3)
			this.nowcharacters = this.characters4;
		else if(this.nowEpisode == 4)
			this.nowcharacters = this.characters5;
		else if(this.nowEpisode == 5)
			this.nowcharacters = this.characters6;
		else if(this.nowEpisode == 6)
			this.nowcharacters = this.characters7;
	}
	
	private void setInputFilename(){
		str[0] = "starwars-episode-1-interactions.json";
		str[1] = "starwars-episode-2-interactions.json";
		str[2] = "starwars-episode-3-interactions.json";
		str[3] = "starwars-episode-4-interactions.json";
		str[4] = "starwars-episode-5-interactions.json";
		str[5] = "starwars-episode-6-interactions.json";
		str[6] = "starwars-episode-7-interactions.json";
	}
	
	private void loadData(){
		for(int i=0 ; i < 7; i++){
			float x = 60;
			float y = 60;
			data = loadJSONObject(path + str[i]);
			
			nodes = data.getJSONArray("nodes");
			links = data.getJSONArray("links");
			
			for(int j=0; j< nodes.size(); j++){
				Character c = new Character(this, nodes.getJSONObject(j).getString("name"),nodes.getJSONObject(j).getString("colour"),x, y);
				if(i==0)
					this.characters1.add(c);
				else if(i==1)
					this.characters2.add(c);
				else if(i == 2)
					this.characters3.add(c);
				else if(i == 3)
					this.characters4.add(c);
				else if(i == 4)
					this.characters5.add(c);
				else if(i == 5)
					this.characters6.add(c);
				else if(i == 6)
					this.characters7.add(c);
				if(y > 810){
					x = x + 65;
					y = 60;
				}else{
					y = y + 90;
				}
			}
			for(int j=0; j < links.size(); j++){
				if(i==0){
					this.characters1.get(links.getJSONObject(j).getInt("source")).setValue(links.getJSONObject(j).getInt("value"));
					this.characters1.get(links.getJSONObject(j).getInt("source")).add(this.characters1.get(links.getJSONObject(j).getInt("target")));
				}else if(i==1){
					this.characters2.get(links.getJSONObject(j).getInt("source")).setValue(links.getJSONObject(j).getInt("value"));
					this.characters2.get(links.getJSONObject(j).getInt("source")).add(this.characters2.get(links.getJSONObject(j).getInt("target")));
				}else if(i == 2){
					this.characters3.get(links.getJSONObject(j).getInt("source")).setValue(links.getJSONObject(j).getInt("value"));
					this.characters3.get(links.getJSONObject(j).getInt("source")).add(this.characters3.get(links.getJSONObject(j).getInt("target")));
				}else if(i == 3){
					this.characters4.get(links.getJSONObject(j).getInt("source")).setValue(links.getJSONObject(j).getInt("value"));
					this.characters4.get(links.getJSONObject(j).getInt("source")).add(this.characters4.get(links.getJSONObject(j).getInt("target")));
				}else if(i == 4){
					this.characters5.get(links.getJSONObject(j).getInt("source")).setValue(links.getJSONObject(j).getInt("value"));
					this.characters5.get(links.getJSONObject(j).getInt("source")).add(this.characters5.get(links.getJSONObject(j).getInt("target")));
				}else if(i == 5){
					this.characters6.get(links.getJSONObject(j).getInt("source")).setValue(links.getJSONObject(j).getInt("value"));
					this.characters6.get(links.getJSONObject(j).getInt("source")).add(this.characters6.get(links.getJSONObject(j).getInt("target")));
				}else if(i == 6){
					this.characters7.get(links.getJSONObject(j).getInt("source")).setValue(links.getJSONObject(j).getInt("value"));
					this.characters7.get(links.getJSONObject(j).getInt("source")).add(this.characters7.get(links.getJSONObject(j).getInt("target")));
				}
			}
				
		}
	}

}
/*
 * */
