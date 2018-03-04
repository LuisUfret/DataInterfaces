package orderedStructures;

import interfaces.Combinable;

public class Arithmetic extends Progression implements Combinable {
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}
	
	@Override
	public double nextValue() throws IllegalStateException{
		if(!this.firstValue)
			throw new IllegalStateException("You haven't executed the firstValue method.");
		current = current + commonDifference; 
		return current;
	}

	@Override
	public String toString(){
		
		
		return "Arith" + "(" + this.firstValue() + "," 
		+ this.commonDifference + ")";
	}
	
	@Override
	public double getTerm(int n) throws IndexOutOfBoundsException{
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 
				
		return (n/2)*(2*this.firstValue()+(n-1)*commonDifference);
	}

	@Override
	public boolean equals(Object o) {
		if(o.equals(firstValue()) && o.equals(commonDifference)) {return true;}
		
		return false;
		
	}

	@Override
	public Progression add(Arithmetic other) {
		double otherFirst = this.firstValue() + other.firstValue();
		double otherDifference = commonDifference + other.commonDifference;
		Progression otherProgression = new Arithmetic(otherFirst, otherDifference);
		return otherProgression;
	}

	@Override
	public Progression substract(Arithmetic other) {
		double otherFirst = this.firstValue() - other.firstValue();
		double otherDifference = commonDifference - other.commonDifference;
		Progression otherProgression = new Arithmetic(otherFirst, otherDifference);
		return otherProgression;
	}
}