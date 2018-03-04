package orderedStructures;

public class Fibonacci extends Progression {

	private double prev; 
	
	public Fibonacci() { 
		this(1); 
		prev = 0; 
	}
	private Fibonacci(double first) {
		super(first);
	}

	@Override
	public double nextValue() throws IllegalStateException{
		if(!this.firstValue)
			throw new IllegalStateException("You haven't executed the firstValue method.");
		current+=prev;
		prev= current - prev;
		return current;
	}
	
	@Override	
	public double firstValue() { 
		double value = super.firstValue(); 
		prev = 0; 
		return value; 
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.equals(firstValue())) {return true;}
		
		return false;
		
	}
	

}