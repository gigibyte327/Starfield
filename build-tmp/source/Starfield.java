import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle [] bob;
public void setup()
{
	
	size(400,400);
	bob = new Particle[101];
	for (int i=0;i<bob.length-2;i++){
		bob[i] = new NormalParticle();
	}
	bob[bob.length-1]=new OddballParticle();
	bob[bob.length-2]=new JumboParticle();
}
public void draw()
{
	fill(0,25);
	rect(0,0,400,400);
	for (int i=0; i<bob.length;i++){
		bob[i].move();
		//((NormalParticle)bob[i]).angle=Math.random()*2*PI;
		bob[i].show();
	}
}

public void mousePressed(){
	for(int i = 0; i<bob.length-3;i++){
		((NormalParticle)bob[i]).xPos = mouseX;
		((NormalParticle)bob[i]).yPos = mouseY;
	}
	

}
class NormalParticle implements Particle
{
	int rC, gC, bC;
	double  xPos, yPos, angle, speed;
	NormalParticle(){
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
		angle+=0.01f;
	}
	public void show(){
		fill(rC,gC,bC);
		noStroke();
		ellipse((float)xPos, (float)yPos, 10,10);	
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
class JumboParticle implements Particle
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
		angle+=0.01f;

	}
	public void show(){
		fill(255,255,255);
		noStroke();
		ellipse((float)xPos, (float)yPos, 20,20);	
	}
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
