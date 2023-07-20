package prc;

import java.util.ArrayList;

public class DST {
	   int vertexCount;
	   
	   public DST(int vertexCount) {
		   this.vertexCount = vertexCount;	   
	   }
	   int minDist(int[] dist, Boolean []spSet)
	   {
	    int minValue = Integer.MAX_VALUE;
	    int minIndex = -1;

	    for(int vertex = 0;vertex<vertexCount;vertex++){
	        if(spSet[vertex]==false && dist[vertex] <= minValue){
	            minValue = dist[vertex];
	            minIndex = vertex;
	            
	        }
	    }
	    return minIndex;
	   }

	   int dijkstra(int graph[][], int s,int t)
	   {
	    int dist[] = new int[vertexCount];
	    Boolean spSet[] = new Boolean[vertexCount];

	    for(int j=0;j<vertexCount;j++){
	        dist[j]= Integer.MAX_VALUE;
	        spSet[j] = false;
	    }

	    dist[s]=0;

	    for(int i=0;i<vertexCount-1;i++){
	        int ux = minDist(dist, spSet);//ux:sourceVertex
	        spSet[ux] = true;

	        for(int vertex = 0;vertex < vertexCount;vertex++){
	            if(!spSet[vertex] && graph[ux][vertex]!=0 && dist[ux]!= Integer.MAX_VALUE )
	            {
	            	if(dist[ux]+graph[ux][vertex]< dist[vertex]){
	                dist[vertex] = dist[ux]+ graph[ux][vertex];
	            }
	        }
	    }
	    }
	    
	    return dist[t];

	   }
	   
	   float averageDST(int[][] g1, int[][] g2, int[][] g3, int source, int target ) {
		   DST dst1 = new DST(g1.length);
		   DST dst2 = new DST(g2.length);
		   DST dst3 = new DST(g3.length);
		   
		   int d1 = dst1.dijkstra(g1, source, target);
		   int d2 = dst2.dijkstra(g2, source, target);
		   int d3 = dst3.dijkstra(g3, source, target);
		   
		   return (d1+d2+d3)/3.0f;
		   
	   }
	   
	   int minDST(int[][] g1, int[][] g2, int[][] g3, int source, int target) {
		   DST dst1 = new DST(g1.length);
		   DST dst2 = new DST(g2.length);
		   DST dst3 = new DST(g3.length);
		   
		   int d1 = dst1.dijkstra(g1, source, target);
		   int d2 = dst2.dijkstra(g2, source, target);
		   int d3 = dst3.dijkstra(g3, source, target);
		   
		   return Math.min(d1, Math.min(d2, d3));
	   }
	   
	   int maxDST(int[][] g1, int[][] g2, int[][] g3, int source, int target) {
		   DST dst1 = new DST(g1.length);
		   DST dst2 = new DST(g2.length);
		   DST dst3 = new DST(g3.length);
		   
		   int d1 = dst1.dijkstra(g1, source, target);
		   int d2 = dst2.dijkstra(g2, source, target);
		   int d3 = dst3.dijkstra(g3, source, target);
		   
		   return Math.max(d1, Math.max(d2, d3));
	   }
	   
	   int medianDST(int[][] g1,int[][] g2,int[][] g3, int source, int target) {
		   DST dst1 = new DST(g1.length);
		   DST dst2 = new DST(g2.length);
		   DST dst3 = new DST(g3.length);
		   
		   int d1 = dst1.dijkstra(g1,source, target);
		   int d2 = dst2.dijkstra(g2, source, target);
		   int d3 = dst3.dijkstra(g3, source, target);
		   
		   ArrayList<Integer> result = new ArrayList<Integer>();
		   result.add(d1);
		   result.add(d2);
		   result.add(d3);
		   result.sort(null);
		    
		   return result.get(1);
	   }
	   

	}


