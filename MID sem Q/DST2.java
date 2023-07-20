package prc;

import java.util.ArrayList;

public class DST2 {

	int vertexCount;
	
	public DST2(int vertexCount) {
		this.vertexCount = vertexCount;
		
	}
	
	int BellmanFord(int[][] g, int s, int t) {
		int dist[] = new int[vertexCount];
		
		for(int j=0;j<vertexCount;j++){
	        dist[j]= Integer.MAX_VALUE;
	        
	    }
		
		dist[s]=0;
		for(int vertex=0;vertex< vertexCount-1;vertex++ ) {
			for(int sx=0;sx< vertexCount;sx++) { //sx: sourceVertex
				for(int dx=0;dx<vertexCount;dx++)//dx:destinationVertex
				{		
			      if(g[sx][dx]!=0)
			      {
			    	  if(dist[sx]!=Integer.MAX_VALUE && dist[dx]>dist[sx]+g[sx][dx]) {
			    		  dist[dx]=dist[sx]+g[sx][dx];
			    		
			    	  }
			      }
			    }
		     }
		
	     }
		
		for(int sx=0;sx< vertexCount;sx++) { 
			for(int dx=0;dx<vertexCount;dx++)
			{		
		      if(g[sx][dx]!=0)
		      {
		    	  if(dist[dx]>dist[sx]+g[sx][dx]) {
		    		  System.out.println("The Graph contains negative edge cycle");
		    	  }
		      }
		    }
	     }
		
	    return dist[t];
	    }
	
	    float averageDST(int[][] g1, int[][] g2,int[][] g3, int source, int target) {
	    	
	    	DST2 dst1 = new DST2(g1.length);
	    	DST2 dst2 = new DST2(g2.length);
	    	DST2 dst3 = new DST2(g3.length);
	    	
	    	int d1 = dst1.BellmanFord(g1, source, target);
	    	int d2 = dst2.BellmanFord(g2, source, target);
	    	int d3 = dst3.BellmanFord(g3, source, target);
	    	
	    	return (d1+d2+d3)/3.0f;
	    	
	    }
	    
	    int minDST(int[][] g1,int[][] g2,int[][] g3, int source, int target) {
	    	DST2 dst1 = new DST2(g1.length);
	    	DST2 dst2 = new DST2(g2.length);
	    	DST2 dst3 = new DST2(g3.length);
	    	
	    	int d1 = dst1.BellmanFord(g1, source, target);
	    	int d2 = dst2.BellmanFord(g2, source, target);
	    	int d3 = dst3.BellmanFord(g3, source, target);
	    	
	    	return Math.min(d1, Math.min(d2, d3));
	    }
	    
	    int maxDST(int[][] g1, int[][] g2,int[][] g3, int source, int target) {
	    	DST2 dst1 = new DST2(g1.length);
	    	DST2 dst2 = new DST2(g2.length);
	    	DST2 dst3 = new DST2(g3.length);
	    	
	    	int d1 = dst1.BellmanFord(g1, source, target);
	    	int d2 = dst2.BellmanFord(g2, source, target);
	    	int d3 = dst3.BellmanFord(g3, source, target);
	    	
	    	return Math.max(d1, Math.max(d2, d3));
	    }
	    
	    int medianDST(int[][] g1, int[][] g2,int[][] g3, int source, int target) {
	    	DST2 dst1 = new DST2(g1.length);
	    	DST2 dst2 = new DST2(g2.length);
	    	DST2 dst3 = new DST2(g3.length);
	    	
	    	int d1 = dst1.BellmanFord(g1, source, target);
	    	int d2 = dst2.BellmanFord(g2, source, target);
	    	int d3 = dst3.BellmanFord(g3, source, target);
	    	
	    	ArrayList<Integer> result = new ArrayList<Integer>();
			result.add(d1);
			result.add(d2);
			result.add(d3);
			result.sort(null);
			    
			return result.get(1);
	    }
	
	    
}
