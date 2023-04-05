import java.lang.Math;

public class Complex {
	public double x = 0;
	public double y = 0;

	public Complex(){
		this(0, 0);
	}

	public Complex(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double module(){
		return Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2));
	}

    	public double arg(){
		if (this.x>0) return Math.atan(this.y/this.x);
		if (this.x == 0) return this.y>0 ? Math.PI/2 : y<0 ? -Math.PI/2 : 0;
		else return this.y>=0 ? Math.PI+Math.atan(this.y/this.x) : Math.atan(this.y/this.x)-Math.PI;
    	}

    	public void add(Complex num){
        	this.x+=num.x;
        	this.y+=num.y;	
    	}

	public void sub(Complex num){
        	this.x-=num.x;
		this.y-=num.y;
	}

	public void getValue(){
		System.out.println(this.x + "+" + "(" + this.y + "i" + ")");
	}

}