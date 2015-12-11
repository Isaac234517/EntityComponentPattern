package parts;
import entity.Entity;
public class SpellPart extends Part {
	
	private float healRate;
	
	public SpellPart(float healRate){
		super();
		this.healRate = healRate;
	}

	public void heal(){
		StatusPart status=entity.getPart(StatusPart.class);
		status.health+=healRate;
		System.out.print("Heal"+healRate+"\n");
	}
}
