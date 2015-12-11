package parts;
import entity.*;
public abstract class Part {
	private boolean isActive =true ;
	protected Entity entity;
	
	public final boolean isActive(){
		return isActive;
	}
	
	public final void setEntity(Entity entity){
		this.entity=entity;
	}

	public final Entity getEntity(){
		return entity;
	}
	
	public void initialize(){
		
	}
	
	public void cleanUp(){
		
	}
	
	public void update(float delta){
		
	}
}

