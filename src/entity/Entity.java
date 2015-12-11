package entity;
import java.util.*;

import parts.*;
public class Entity {
	
	private boolean isInitialize;
	private boolean isActive;
	private Map<Class<? extends Part>,Part> parts=new HashMap<Class<? extends Part>,Part>();
	private List<Part> partToAdd = new ArrayList<Part>();
	private List<Class<? extends Part>> partToRemove = new ArrayList<Class <? extends Part>>();
	
	public <T extends Part> boolean hasPart(Class<T> partclass) {
		return parts.containsKey(partclass);
	}
	
	public <T extends Part> void attached(Part part){
		if(hasPart(part.getClass())){
			throw new IllegalArgumentException("Already exist part");
		}
		else{
			parts.put(part.getClass(), part);
			if(isInitialize){
				part.initialize();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Part> T getPart(Class<T> partclass ){
		if(!hasPart(partclass)){
			throw new IllegalArgumentException("No this type of part exist");
		}
		else{
			return (T) parts.get(partclass);
		}
	}
	
	public void initialize(){
		isInitialize=true;
		isActive = true;
		for(Part part : parts.values()){
			part.initialize();
		}
	}
	
	public void cleanUp(){
		if(isActive){
			isActive = false;
			for(Part part: parts.values()){
				part.cleanUp();
			}
		}
	}
	
	public void update(float delta){
		for (Part part : parts.values()){
			part.update(delta);
		}
		
		while(!partToRemove.isEmpty()){
			remove(partToRemove.remove(0));
		}
		
		while(!partToAdd.isEmpty()){
			attached(partToAdd.remove(0));
		}
	}
	
	public void deattched(Part part){
		if(!hasPart(part.getClass())){
			throw new IllegalArgumentException("this part is not existing");
		}
		else{
			partToRemove.add(part.getClass());
		}
	}
	
	public <T extends Part> void remove(Class<T> partclass){
		parts.remove(partclass);
	}
}
