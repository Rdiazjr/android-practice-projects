package com.example.bouncingballs;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class AnimationView extends View {
	private final int FRAME_RATE = 15;
	private Paint paint;
	private Handler h;
	private Ball myBall;
	private Ball greenBall;
	private Ball redBall;
	private Ball yellowBall;
	private Ball violetBall;
	
	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		h = new Handler();
		
		paint = new Paint();
		paint.setColor(Color.BLUE);
		myBall = new Ball(100,100,Color.BLUE,50);
		greenBall = new Ball(200,200,Color.GREEN,25);
		redBall = new Ball(50,400,Color.RED	,75);
		yellowBall = new Ball(250,500,Color.YELLOW	,60);
		violetBall = new Ball(300,300,Color.rgb(147,112,219) ,90);
		
		myBall.setSpeedX(10);
		myBall.setSpeedY(10);
		
		greenBall.setSpeedX(-20);
		greenBall.setSpeedY(-15);
		
		redBall.setSpeedX(5);
		redBall.setSpeedY(-5);
		
		yellowBall.setSpeedX(20);
		yellowBall.setSpeedY(15);
		
		violetBall.setSpeedX(15);
		violetBall.setSpeedY(15);
		
	}
	
	protected void onDraw(Canvas c){
		myBall.bounce(c);
		greenBall.bounce(c);
		redBall.bounce(c);
		yellowBall.bounce(c);
		violetBall.bounce(c);
		c.drawCircle(myBall.getX(),myBall.getY(),myBall.getRadius(),myBall.getPaint());
		c.drawCircle(greenBall.getX(),greenBall.getY(),greenBall.getRadius(),greenBall.getPaint());
		c.drawCircle(redBall.getX(),redBall.getY(),redBall.getRadius(),redBall.getPaint());
		c.drawCircle(yellowBall.getX(),yellowBall.getY(),yellowBall.getRadius(),yellowBall.getPaint());
		c.drawCircle(violetBall.getX(),violetBall.getY(),violetBall.getRadius(),violetBall.getPaint());
		h.postDelayed(r, FRAME_RATE);
	} 
	private Runnable r = new Runnable(){
		public void run(){
			invalidate();
		}
	};

}
