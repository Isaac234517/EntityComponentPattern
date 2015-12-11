package parts;

import entity.Entity;

public class AttackPart extends Part {
	
	public float damage;
	private Entity target;
	
	public AttackPart(float damage,Entity target){
		this.damage = damage;
		this.target = target;
	}
	
	public void attack(){
		StatusPart targetStatus = target.getPart(StatusPart.class);
		AttackPart myDamagePart = entity.getPart(AttackPart.class);
		targetStatus.health -= myDamagePart.damage;
		System.out.print("Target was damge"+damage+"Its health is"+targetStatus.health+"\n");
	}

}
