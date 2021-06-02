package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;

//Le label va nous donner les informations pour chaque noeud 
//on en aura besoin pour l'algo de Dijkstra
public class Label implements Comparable<Label>{
    protected Node SommetCourant; 
    private Arc Pere; //D'après le sujet il est préférable de stocker l'arc et non le sommet
    private boolean Marque; 
    private double Cout; 


    public Label (Node SommetCourant) {
		this.SommetCourant = SommetCourant;
		this.Pere = null ; //Initialement le sommet n'a pas de père 
		this.Marque = false ; //On dit que le sommet n'a pas été marqué
		this.Cout = Double.POSITIVE_INFINITY ; //On initialise le cout à l'infinie
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
