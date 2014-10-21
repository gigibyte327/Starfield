Particle [] bob;
void setup()
{
	
	size(400,400);
	bob = new Particle[101];
	for (int i=0;i<bob.length-1;i++){
		bob[i] = new NormalParticle();
	}
	bob[bob.length-1]=new OddballParticle();
	bob[bob.length-2] = new JumboParticle();

}
void draw()
{
	fill(255,25);
	rect(0,0,400,400);
	for (int i=0; i<bob.length;i++){
		bob[i].move();
		//((NormalParticle)bob[i]).angle=Math.random()*2*PI;
		bob[i].show();
	}
}

void mousePressed(){
	for(int i = 0; i<bob.length-1;i++){
		((NormalParticle)bob[i]).xPos = mouseX;
		((NormalParticle)bob[i]).yPos = mouseY;
	}
	

}
class NormalParticle implements Particle
{
	int rC, gC, bC,sz;
	double  xPos, yPos, angle, speed;
	NormalParticle(){
		xPos=200;
		yPos=200;
		sz=10;
		angle=Math.random()*2*PI;
		speed=Math.random()*5;
		rC=(int)(Math.random()*50);
		gC=(int)(Math.random()*50)+50;
		bC=(int)(Math.random()*200)+100;
	}
	public void move(){
		yPos=yPos+(Math.sin(angle))*speed;
		xPos=xPos+(Math.cos(angle))*speed;
		angle+=0.01;
	}
	public void show(){
		fill(rC,gC,bC);
		noStroke();
		ellipse((float)xPos, (float)yPos, sz,sz);	
	}
}

interface Particle
{
	public void show();
	public void move();
}
class OddballParticle implements Particle
{
	int rC, gC, bC;
	double  xPos, yPos, angle, speed;
	OddballParticle(){
		xPos=200;
		yPos=200;
		angle=Math.random()*2*PI;
		speed=Math.random()*5;
		rC=(int)(Math.random()*200);
		gC=(int)(Math.random()*200);
		bC=(int)(Math.random()*200);
	}
	public void move(){
		yPos=mouseY+15;
		xPos=mouseX-30;
		
	}
	public void show(){
		fill(rC,gC,bC);
		noStroke();
		triangle((float)xPos, (float)yPos, (float)xPos+60,(float)yPos, (float)xPos+30, (float)yPos-30);	
	}
}
class JumboParticle extends NormalParticle
{
	JumboParticle(){
		sz=30;
		rC=(int)(Math.random()*50)+100;
		gC=(int)(Math.random()*50)+50;
		bC=(int)(Math.random()*200);
	}
}
/*class JumboParticle implements Particle
{
	int rC, gC, bC;
	double  xPos, yPos, angle, speed;
	JumboParticle(){
		xPos=200;
		yPos=200;
		angle=Math.random()*2*PI;
		speed=Math.random()*5;
		rC=(int)(Math.random()*50);
		gC=(int)(Math.random()*50)+50;
		bC=(int)(Math.random()*200)+100;
	}
	public void move(){
		yPos=yPos+(Math.sin(angle))*speed;
		xPos=xPos+(Math.cos(angle))*speed;
		angle+=0.01;

	}
	public void show(){
		fill(255,255,255);
		noStroke();
		ellipse((float)xPos, (float)yPos, 20,20);	
	}
}*/

