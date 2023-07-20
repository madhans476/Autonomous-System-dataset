package prc;

import java.util.ArrayList;

public class MST2 {
	private int vertexCount;
	
    
    public MST2(int vertexCount) {
   	 this.vertexCount = vertexCount;
   	 
    }
	
    private int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }
    
    private void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
    
    public int[][] kruskalMST(int[][] g) {
    	
    	int[] parent = new int[vertexCount];
    	int[][] mst =  new int[vertexCount][vertexCount];
    	int edgeCount = 0;
    	
    	for (int i = 0; i < vertexCount; i++) {
            parent[i] = i;
            for (int j = 0; j < vertexCount; j++) {
                mst[i][j] = 0;
            }
        }
        
    	
        while (edgeCount < vertexCount - 1) {
            int minWeight = Integer.MAX_VALUE;
            int u = -1, v = -1;

            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    if (find(parent, i) != find(parent, j) && g[i][j] != 0 && g[i][j] < minWeight) {
                        minWeight = g[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
            union(parent, u, v);
            mst[u][v] = minWeight;
            mst[v][u] = minWeight;
            edgeCount++;
    	
       }
              
        return mst;
	
    }
    
    public double averageMST(int g1[][], int g2[][], int g3[][])
    {
        MST2 mst1 = new MST2(g1.length);
        MST2 mst2 = new MST2(g2.length);
        MST2 mst3 = new MST2(g3.length);
      
        int [][] matrix1 = mst1.kruskalMST(g1);
        int [][] matrix2 = mst2.kruskalMST(g2);
        int [][] matrix3 = mst3.kruskalMST(g3);

        System.out.println("step1");
        int averageMST = 0;
        int [][] combinedMatrix = new int[vertexCount][vertexCount];
        for(int i=0;i<6; i++){
        	
          for(int j=0; j<6; j++){
        	  if(matrix1[i][j]==0)
          		matrix1[i][j]=Integer.MAX_VALUE;
          	  if(matrix2[i][j]==0)
          		matrix2[i][j]=Integer.MAX_VALUE;
          	  if(matrix3[i][j]==0)
          		matrix3[i][j]=Integer.MAX_VALUE;
              combinedMatrix[i][j]= Math.min(matrix1[i][j], Math.min(matrix2[i][j], matrix3[i][j]));
              
             
          }
         
        }
        System.out.println("step 2");
        int [][] matrix4 = mst1.kruskalMST(combinedMatrix);
        System.out.println("Average MST");
        for(int i=0;i<6; i++){
           System.out.print("[ ");
          for(int j=0; j<6; j++){
              averageMST += matrix4[i][j];
              System.out.print(matrix4[i][j]+ ", ");
          }
          System.out.println("]");
        
        }
        return averageMST/2;
    }

      int minMST(int [][]g1, int [][]g2, int [][]g3){
        MST2 mst1 = new MST2(g1.length);
        MST2 mst2 = new MST2(g2.length);
        MST2 mst3 = new MST2(g3.length);
     
        int [][] matrix1 = mst1.kruskalMST(g1);
        int [][] matrix2 = mst2.kruskalMST(g2);
        int [][] matrix3 = mst3.kruskalMST(g3);

        int mst1Sum= 0, mst2Sum= 0 , mst3Sum = 0;
        for(int i=0; i<6 ;i++){
          for(int j=0; j<i ;j++){
              mst1Sum += matrix1[i][j];
              mst2Sum += matrix2[i][j];
              mst3Sum += matrix3[i][j];
          }
        }
        return Math.min(mst1Sum, Math.min(mst2Sum, mst3Sum));
        
      }
      int maxMST(int [][]g1, int [][]g2, int [][]g3){
        MST2 mst1 = new MST2(g1.length);
        MST2 mst2 = new MST2(g2.length);
        MST2 mst3 = new MST2(g3.length);
      
        int [][] matrix1 = mst1.kruskalMST(g1);
        int [][] matrix2 = mst2.kruskalMST(g2);
        int [][] matrix3 = mst3.kruskalMST(g3);

        int mst1Sum= 0, mst2Sum= 0 , mst3Sum = 0;
        for(int i=0; i<6 ;i++){
          for(int j=0; j<6 ;j++){
              mst1Sum += matrix1[i][j];
              mst2Sum += matrix2[i][j];
              mst3Sum += matrix3[i][j];
          }
        }
        return Math.max(mst1Sum/2, Math.max(mst2Sum/2, mst3Sum/2));
        
      }

        int medianMST(int [][]g1, int [][]g2, int [][]g3){
        MST2 mst1 = new MST2(g1.length);
        MST2 mst2 = new MST2(g2.length);
        MST2 mst3 = new MST2(g3.length);

        int [][] matrix1 = mst1.kruskalMST(g1);
        int [][] matrix2 = mst2.kruskalMST(g2);
        int [][] matrix3 = mst3.kruskalMST(g3);

        Integer mst1Sum= 0, mst2Sum= 0 , mst3Sum = 0;
        for(int i=0; i<6 ;i++){
          for(int j=0; j<i ;j++){
              mst1Sum += matrix1[i][j];
              mst2Sum += matrix2[i][j];
              mst3Sum += matrix3[i][j];
          }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(mst1Sum);
        result.add(mst2Sum);
        result.add(mst3Sum);
        result.sort(null);
      
        return result.get(1);
        
      }

	
}
