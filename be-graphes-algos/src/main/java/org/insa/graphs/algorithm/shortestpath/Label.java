package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;

public class Label implements Comparable<Label>{
    protected Node SommetCourant; 
    private Arc Pere; 
    private boolean Marque; 
    private double Cout; 


    public Label (Node SommetCourant) {
		this.SommetCourant = SommetCourant;
		this.Pere = null ;
		this.Marque = false ;
		this.Cout = Double.POSITIVE_INFINITY ;
	}
	
	/*Getters*/
	public Node getSommetCourrant() {
		return this.SommetCourant ;
	}
	
	public Arc getPere() {
		return this.Pere ;
	}
	
	public boolean getMarque () {
		return this.Marque ;
	}
	
	public double getTotalCost() {
		return this.Cout ;
	}
	
	/*Setters*/
	public void setPere(Arc Pere) {
		this.Pere = Pere ;
	}
	
	public void setMarqueTrue () {
		this.Marque = true ;
	}
	
	public double getCost() {
		return this.Cout ;
	}
	
	public void setCost(double cout) {
		this.Cout = cout ;
	}
	
	@Override
	public int compareTo(Label o) {
		return Double.compare(this.getTotalCost(), o.getTotalCost()) ;
	}

}
