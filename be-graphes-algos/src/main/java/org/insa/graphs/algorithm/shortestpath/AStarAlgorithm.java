package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.*;
import java.util.List;
import org.insa.graphs.algorithm.AbstractInputData;

public class AStarAlgorithm extends DijkstraAlgorithm {
	
    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }
    
    //On redéfinit la fonction InitialiseLabels définie dans la classe DijkstraAlgorithm 
    //Afin de créer à présent  un tableau de labels star de taille nbNoeuds
   protected Label[] InitialiseLabels() {
	   LabelStar ArrayLabels[] = new LabelStar[nbNoeuds] ;
	   List<Node> nodes = graphe.getNodes();
	   
	   double Cost = 0;

	   int MaxSpeed = Speed() ; 
	   
	   //Il s'agit du point de destination 
	   Point DestinationP = data.getDestination().getPoint() ; 
	   
	   //On crée les labels star
	   for (Node node : nodes) {
		   ArrayLabels[node.getId()] = new LabelStar(node);
		   
		   //Le cout est la distance entre le point et la point de destination en métres
		   if(data.getMode() == AbstractInputData.Mode.LENGTH) {
			   Cost = node.getPoint().distanceTo(DestinationP);
			   
			   //Si il d'agit du temps le plus court qui nous intéresse on divise cette longueur par la vitesse 
	       		Cost = 3.6* node.getPoint().distanceTo(DestinationP) / MaxSpeed; 
	       	}
		   
		   ArrayLabels[node.getId()].setEstimatedCost(Cost);
	   }
	   return ArrayLabels ; 
    }
  // Pour éviter le problème des sommets marqués qui font des cercle dasn toute la carte
   private int Speed() {
	   int MaxSpeedData =  data.getMaximumSpeed() ; 
	   int MaxSpeedGraph = graphe.getGraphInformation().getMaximumSpeed() ;
	   int Speed = Math.min(MaxSpeedData, MaxSpeedGraph) ; 
	   
	   if (MaxSpeedData ==  GraphStatistics.NO_MAXIMUM_SPEED && MaxSpeedGraph ==  GraphStatistics.NO_MAXIMUM_SPEED ) {
		   Speed = 130 ;
	   }
	   if (MaxSpeedData ==  GraphStatistics.NO_MAXIMUM_SPEED) {
		   Speed = MaxSpeedGraph; 
	   }
	   if (MaxSpeedGraph ==  GraphStatistics.NO_MAXIMUM_SPEED) {
		   Speed = MaxSpeedData; 
	   }
	return Speed ; 
   }
}
