package parts;

public class FlyPart extends Part {
	
	private float speed;
	private float height;
	
	public FlyPart(float speed, float height){
		super();
		this.speed=speed;
		this.height=height;
	}
	
	@Override
	public void update(float delta){
		height+=speed*delta;
	}
	
}
