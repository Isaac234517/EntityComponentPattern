import entity.Entity;
import parts.*;
public class GameLoop {
	
	public static Entity createMonster(Entity target){
		Entity monster = new Entity();
		monster.attached(new StatusPart(100));
		AttackPart attackPart=new AttackPart(30,target);
		attackPart.setEntity(monster);
		monster.attached(attackPart);
		SpellPart spellPart=new SpellPart(1);
		spellPart.setEntity(monster);
		monster.attached(spellPart);
		monster.attached(new MonsterControllerPart(monster));
		return monster;
	}
	
	public static Entity createPerson(){
		Entity person = new Entity();
		person.attached(new StatusPart(120));
		SpellPart spellPart=new SpellPart(10);
		spellPart.setEntity(person);
		person.attached(spellPart);
		person.attached(new PersonControllerPart(person));
		return person;
	}

	public static void main(String[] args) throws InterruptedException {
		Entity person=createPerson();
		Entity monster=createMonster(person);
		while(person.getPart(StatusPart.class).health>0){
			monster.update(1);
			person.update(1);
			Thread.sleep(2000);
		}

	}

}
