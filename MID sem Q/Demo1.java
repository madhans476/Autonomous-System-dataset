package prc;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
       
        int g1[][] = { {0,0,0,4,0,2},
                       {0,0,5,2,0,0}, 
                       {0,5,0,2,0,0}, 
                       {4,2,2,0,0,0},
                       {0,0,0,0,0,2},
                       {2,0,0,0,2,0}};

        int g2[][] = { {1,2,0,6,0,0},
                       {2,0,2,4,0,0},
                       {0,2,0,2,0,0}, 
                       {6,4,2,0,2,0}, 
                       {0,0,0,2,0,2}, 
                       {0,0,0,0,2,0}};
        
        int g3[][] = { {1,2,0,6,0,0},
                       {2,0,2,4,0,0},
                       {0,2,0,2,0,0}, 
                       {6,4,2,0,2,0}, 
                       {0,0,5,2,0,2}, 
                       {0,0,0,0,2,0}};
        
        MST1 mst1 = new MST1(6);
        MST2 mst2 = new MST2(6);
        DST dst1 = new DST(6);
        DST2 dst2 = new DST2(6);
        
        System.out.println("To find AVERAGE MST or DST press 1!");
        System.out.println("To find MEDIAN MST or DST press 2!");
        System.out.println("To find MINIMUM MST or DST press 3!");
        System.out.println("To find MAXIMUM MST or DST press 4!");
        int s = 0;
        int t = g1.length-1;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        int opt = input.nextInt();
        switch(opt) {
        case 1:
        	System.out.println("To find Average MST using PRIMS algorithm press 1!");
        	System.out.println("To find Average MST using KRUSKAL algorithm press 2!");
        	System.out.println("To find Average Shortest path using DIJSKSTRA algorithm press 3!");
        	System.out.println("To find Average Shortest path using BELLMAN FORD algorithm press 4!");
        	
        	int opt1 = input.nextInt();
        	switch(opt1) {
        	case 1:
        		System.out.print("The Average MST is "+ mst1.averageMST(g1, g2, g3));
        		break;
        	case 2:
        		System.out.print("The Average MST is " + mst2.averageMST(g1, g2, g3));
        		break;
        		
        	case 3:
        		System.out.print("Enter the source vertex(0-5): ");
        	    s = input.nextInt();
        	    System.out.print("Enter the target vertex(0-5): ");
        	    t = input.nextInt();
        		System.out.println("The Average Shortest path is " + dst1.averageDST(g1, g2, g3,s,t));
        		break;
        		
        	case 4:
        		System.out.print("Enter the source vertex(0-5): ");
        		s = input.nextInt();
        		System.out.print("Enter the target vertex(0-5): ");
        	    t = input.nextInt();
        		System.out.println("The Average Shortest path is " + dst2.averageDST(g1, g2, g3,s,t));
        		break;
        	default:
        		System.out.println("YOUR INPUT DOES NOT MATCHES");

        	}
        	break;
        	
        case 2:
        	System.out.println("To find Median MST using PRIMS algorithm press 1!");
        	System.out.println("To find Median MST using KRUSKAL algorithm press 2!");
        	System.out.println("To find Median Shortest path using DIJSKSTRA algorithm press 3!");
        	System.out.println("To find Median Shortest path using BELLMAN FORD algorithm press 4!");
        	
        	int opt2 = input.nextInt();
        	switch(opt2) {
        	case 1:
        		System.out.println("The Median MST is "+ mst1.medianMST(g1, g2, g3));
        		break;
        		
        	case 2:
        		System.out.println("The Median MST is "+ mst2.medianMST(g1, g2, g3));
        		break;
        		
        	case 3:
        		System.out.print("Enter the source vertex(0-5): ");
        	    s = input.nextInt();
        	    System.out.print("Enter the target vertex(0-5): ");
        	    t = input.nextInt();
        		System.out.println("The Median Shortest path is "+ dst1.medianDST(g1, g2, g3,s,t) );
        		break;
        		
        	case 4:
        		System.out.print("Enter the source vertex(0-5): ");
        	    s = input.nextInt();
        	    System.out.print("Enter the target vertex(0-5): ");
        	    t = input.nextInt();
        		System.out.println("The Median Shortest path is "+ dst2.medianDST(g1, g2, g3,s,t));
        		break;
				
        	default:
        		System.out.println("YOUR INPUT DOES NOT MATCHES!");
				}
        	break;
        	
        case 3:
        	System.out.println();
        	System.out.println("To find Minimum MST using PRIMS algorithm press 1!");
        	System.out.println("To find Minimum MST using KRUSKAL algorithm press 2!");
        	System.out.println("To find Minimum Shortest path using DIJSKSTRA algorithm press 3!");
        	System.out.println("To find Minimum Shortest path using BELLMAN FORD algorithm press 4!");
        	
        	int opt3 = input.nextInt();
        	switch(opt3) {
        	case 1:
        		System.out.println("The Minimum MST is "+ mst1.minMST(g1, g2, g3));
        		break;
        		
        	case 2:
        		System.out.println("The Minimum MST is "+ mst2.minMST(g1, g2, g3));
        		break;
        		
        	case 3:
        		System.out.print("Enter the source vertex(0-5): ");
        	    s = input.nextInt();
        	    System.out.print("Enter the target vertex(0-5): ");
        	    t = input.nextInt();
        		System.out.println("The Minimum Shortest path is "+ dst1.minDST(g1, g2, g3,s,t) );
        		break;
        		
        	case 4:
        		System.out.print("Enter the source vertex(0-5): ");
        	    s = input.nextInt();
        	    System.out.print("Enter the target vertex(0-5): ");
        	    t = input.nextInt();
        		System.out.println("The Minimum Shortest path is "+ dst2.minDST(g1, g2, g3,s,t));
        		break;
				
        	default:
        		System.out.println("YOUR INPUT DOES NOT MATCHES!");
				}
        	break;
        	
        case 4:
        	System.out.println("To find Maximum MST using PRIMS algorithm press 1!");
        	System.out.println("To find Maximum MST using KRUSKAL algorithm press 2!");
        	System.out.println("To find Maximum Shortest path using DIJSKSTRA algorithm press 3!");
        	System.out.println("To find Maximum Shortest path using BELLMAN FORD algorithm press 4!");
        	
        	int opt4 = input.nextInt();
        	switch(opt4) {
        	case 1:
        		System.out.println("The Maximum MST is "+ mst1.maxMST(g1, g2, g3));
        		break;
        		
        	case 2:
        		System.out.println("The Maximum MST is "+ mst2.maxMST(g1, g2, g3));
        		break;
        		
        	case 3:
        		System.out.print("Enter the source vertex(0-5): ");
        	    s = input.nextInt();
        	    System.out.print("Enter the target vertex(0-5): ");
        	    t = input.nextInt();
        		System.out.println("The Maximum Shortest path is "+ dst1.maxDST(g1, g2, g3,s,t) );
        		break;
        		
        	case 4:
        		System.out.print("Enter the source vertex(0-5): ");
        	    s = input.nextInt();
        	    System.out.print("Enter the target vertex(0-5): ");
        	    t = input.nextInt();
        		System.out.println("The Maximum Shortest path is "+ dst2.maxDST(g1, g2, g3,s,t));
        		break;
				
        	default :
        		System.out.println("YOUR INPUT DOES NOT MATCHES!");
				}
        	break;
        	
        	
        	}
        
    }
}


