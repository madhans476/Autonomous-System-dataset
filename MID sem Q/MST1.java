package prc;
import java.util.ArrayList;

public class MST1{
    private int vertexCount;
     
     public MST1(int vertexCount) {
    	 this.vertexCount = vertexCount;
     }
    
    int findMinKeyVertex(int keys[], Boolean setOfMST[])
    {   
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for(int vertex = 0 ; vertex< vertexCount; vertex++)
        {
           if (setOfMST[vertex] == false && keys[vertex] < minValue){
             minValue = keys[vertex];
             minIndex = vertex;

           }

        }
        return minIndex;
    }

    void printMST(int mstArray[], int graph[][])
    {   
        System.out.println("Edge \t\tWeight");
        for(int j=1;j< vertexCount;j++){
            System.out.println(j+1 + "<-->" + (1+(int)(mstArray[j])) + " \t\t"+ graph[j][mstArray[j]]);
        }
    }

    public int[][] primMST(int graph[][])
    {
      int mstArray[] = new int [vertexCount];
      int keys[] = new int [vertexCount];
      Boolean setOfMST[] = new Boolean[vertexCount];

      for(int j=0;j< vertexCount ; j++){
        keys[j]= Integer.MAX_VALUE;
        setOfMST[j] = false;
      }

      keys[0] = 0;
      mstArray[0]= -1;

      for(int i=0; i< vertexCount - 1; i++){
        int edge = findMinKeyVertex(keys, setOfMST);
        setOfMST[edge] = true;

        for(int vertex = 0 ; vertex< vertexCount; vertex++){
           if(graph[edge][vertex]!= 0 && setOfMST[vertex]==false && graph[edge][vertex]< keys[vertex]){
               mstArray[vertex] = edge;
               keys[vertex]= graph[edge][vertex];
           } 
        }
      }

      int mstGraph [][] = new int[vertexCount][vertexCount];
      for(int j=1;j< vertexCount;j++){
        mstGraph[j][mstArray[j]] = graph[j][mstArray[j]];
        mstGraph[mstArray[j]][j] = graph[j][mstArray[j]];
      }

      //printMST(mstArray, graph);
      return mstGraph;
    }

    public double averageMST(int g1[][], int g2[][], int g3[][]){
      MST1 mst1 = new MST1(g1.length);
      MST1 mst2 = new MST1(g2.length);
      MST1 mst3 = new MST1(g3.length);
    
      int [][] matrix1 = mst1.primMST(g1);
      int [][] matrix2 = mst2.primMST(g2);
      int [][] matrix3 = mst3.primMST(g3);

      int averageMST = 0;
      int [][] combinedMatrix = new int[vertexCount][vertexCount];
      for(int i=0;i<6; i++)
      {
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
      int [][] matrix4 = mst1.primMST(combinedMatrix);
      System.out.println("Average MST");
      for(int i=0;i<6; i++){
         System.out.print("[ ");
        for(int j=0; j<6; j++){
            
            System.out.print(matrix4[i][j]+ ", ");
            averageMST += matrix4[i][j];
        }
        System.out.println("]");
      
    }
      return averageMST/2;
    }

    int minMST(int [][]g1, int [][]g2, int [][]g3){
      MST1 mst1 = new MST1(g1.length);
      MST1 mst2 = new MST1(g2.length);
      MST1 mst3 = new MST1(g3.length);
    
      int [][] matrix1 = mst1.primMST(g1);
      int [][] matrix2 = mst2.primMST(g2);
      int [][] matrix3 = mst3.primMST(g3);

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
      MST1 mst1 = new MST1(g1.length);
      MST1 mst2 = new MST1(g2.length);
      MST1 mst3 = new MST1(g3.length);
    
      int [][] matrix1 = mst1.primMST(g1);
      int [][] matrix2 = mst2.primMST(g2);
      int [][] matrix3 = mst3.primMST(g3);

      int mst1Sum= 0, mst2Sum= 0 , mst3Sum = 0;
      for(int i=0; i<6 ;i++){
        for(int j=0; j<i ;j++){
            mst1Sum += matrix1[i][j];
            mst2Sum += matrix2[i][j];
            mst3Sum += matrix3[i][j];
        }
      }
      return Math.max(mst1Sum, Math.max(mst2Sum, mst3Sum));
      
    }

      int medianMST(int [][]g1, int [][]g2, int [][]g3){
      MST1 mst1 = new MST1(g1.length);
      MST1 mst2 = new MST1(g2.length);
      MST1 mst3 = new MST1(g3.length);

      int [][] matrix1 = mst1.primMST(g1);
      int [][] matrix2 = mst2.primMST(g2);
      int [][] matrix3 = mst3.primMST(g3);

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

