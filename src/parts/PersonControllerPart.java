package parts;
import entity.Entity;
public class PersonControllerPart extends Part{

	public PersonControllerPart(Entity entity){
		this.entity = entity;
	}
	
	@Override
	public void update(float delta){
		if(entity.hasPart(SpellPart.class)){
			entity.getPart(SpellPart.class).heal();
		}
	}

}
