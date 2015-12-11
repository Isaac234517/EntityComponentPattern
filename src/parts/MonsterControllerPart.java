package parts;
import entity.Entity;
public class MonsterControllerPart extends Part {
		
	public MonsterControllerPart(Entity entity){
		super();
		this.entity = entity;
	}
	
	@Override
	public void update(float delta){
		if(entity.hasPart(AttackPart.class)){
			entity.getPart(AttackPart.class).attack();
		}
		
		if(entity.hasPart(SpellPart.class)){
			entity.getPart(SpellPart.class).heal();
		}
	}	
}
