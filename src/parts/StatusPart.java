package parts;

import entity.Entity;

public class StatusPart extends Part {
	public float health;
	
	public StatusPart(float health){
		this.health=health;
	}
	public boolean isAlive(){
		return this.health>0? true:false;
	}
	
}
