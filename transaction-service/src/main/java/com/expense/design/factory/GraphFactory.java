package com.expense.design.factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphFactory {
	
	
	@Autowired
	PieGraph pieGraph;
	
	@Autowired
	BarGraph barGraph;
	
	public Graph getGraph(String graphType) {
		 if(graphType == null){
	         return null;
	      }		
	      if(graphType.equalsIgnoreCase("PieGraph")){
	         return pieGraph;
	         
	      } else if(graphType.equalsIgnoreCase("BarGraph")){
	         return barGraph;
	         
	      } /*else if(graphType.equalsIgnoreCase("LineGraph")){
	         return new LineGraph();
	      }*/
	      
		return null;	
	}
}
