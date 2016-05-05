package main.java;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

/**
* This class is for sketching outcome using Processing
* You can do major UI control and some visualization in this class.  
*/
@SuppressWarnings("serial")
public class MainApplet extends PApplet{
	
	JSONObject data;
	JSONArray nodes, links;
	
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
	
	private final static int width = 1200, height = 650;
	
	public void setup() {
		str = new String[7];
		characters1 = new ArrayList<Character>();
		characters2 = new ArrayList<Character>();
		characters3 = new ArrayList<Character>();
		characters4 = new ArrayList<Character>();
		characters5 = new ArrayList<Character>();
		characters6 = new ArrayList<Character>();
		characters7 = new ArrayList<Character>();
		setInputFilename();
		size(width, height);
		smooth();
		loadData();
		
	}

	public void draw() {
		this.getCharacterList();
		if(this.record == 0){
		for(int i=0; i< this.nowcharacters.size(); i++){
			System.out.println(this.nowcharacters.get(i).getName());
		}
		this.record = 1;
		}
	}
	
	public void keyPressed(){
		if(nowEpisode == 6)
			nowEpisode = 0;
		else
			nowEpisode ++;
		this.record = 0; 
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
	
	/*private void setCharacterList(){
		characters1 = new ArrayList<Character>();
		characters2 = new ArrayList<Character>();
		characters3 = new ArrayList<Character>();
		characters4 = new ArrayList<Character>();
		characters5 = new ArrayList<Character>();
		characters6 = new ArrayList<Character>();
		characters7 = new ArrayList<Character>();
		this.a1.add(characters1);
		this.a1.add(characters2);
		this.a1.add(characters3);
		this.a1.add(characters4);
		this.a1.add(characters5);
		this.a1.add(characters6);
		this.a1.add(characters7);
	}*/
	
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
			data = loadJSONObject(path + str[i]);
			
			nodes = data.getJSONArray("nodes");
			links = data.getJSONArray("links");
			
			for(int j=0; j< nodes.size(); j++){
				Character c = new Character(this, nodes.getJSONObject(i).getString("name"));
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
			}
		}
	}

}
/*
 * */
