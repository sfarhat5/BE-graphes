package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Node;


public class LabelStar extends Label implements Comparable<Label> {

	private double EstimatedCost;
	
	public LabelStar (Node CurrentNode) {
		super(CurrentNode);
		this.EstimatedCost = Double.POSITIVE_INFINITY;
	}
	 @Override
	 //Fonction pour renvoyer le cout total du label : son cout + le cout estimé défini précedemment
	public double getTotalCost() {
		return this.EstimatedCost + this.getCost();
	}
	 //Fonction renvoyant seulement le cout estimé
	  public double getEstimatedCost() {
	        return this.EstimatedCost;
	    }
	  public void setEstimatedCost(double EstimatedCost) {
	        this.EstimatedCost = EstimatedCost;
	    } 
    public int compareTo(LabelStar label) {
    	return Double.compare(this.getEstimatedCost(), label.getEstimatedCost());
	}
}