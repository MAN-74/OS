package ASS_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoryManager {
    static List<Block> memoryBlocks = new ArrayList<>();
    static int allocationStrategy; // 1: First-Fit, 2: Best-Fit, 3: Worst-Fit
    
    public static void main (String[]args){
        Allocation allocation=new Allocation();
        initializeMemory();
        Scanner scanner = new Scanner(System.in);
        System.err.println("1) Allocates memory blocks\r\n" + //
                        "2) De-allocates memory blocks\r\n" + //
                        "3) Print report about the current state of memory and internal Fragmentation\r\n" + //
                        "4) Exit");
        int choice=scanner.nextInt();
        
        
        switch (choice){
            case 1:
            System.out.println("Enter the process ID and size of process: ");
                String pID=scanner.next();
                int pSize=scanner.nextInt();
            switch (allocationStrategy) {
                case 1:
                allocation.FirstFit(pID,pSize,memoryBlocks);

                    break;
                case 2:
                allocation.BestFit(pID,pSize,memoryBlocks);
                break;
                case 3:
                allocation.WorstFit(pID,pSize,memoryBlocks);

                break;
                default:
                    break;
            }
            

            break;

            case 2: 
            break;
            case 3:
            case 4:

        }
        
    }  



    public static void initializeMemory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of blocks: ");
        int numBlocks = scanner.nextInt();

        int[] sizes = new int[numBlocks];
        System.out.print("Enter the size of each block in KB: ");
        for (int i = 0; i < numBlocks; i++) {
            sizes[i] = scanner.nextInt();
        }

        int currentStart = 0;
        for (int size : sizes) {
            memoryBlocks.add(new Block(size, currentStart));
            currentStart += size;
        }

        System.out.println("Enter allocation strategy (1 for first-fit, 2 for best-fit, 3 for worst-fit): ");
        allocationStrategy = scanner.nextInt();
        System.out.println("Memory blocks are created…");
        printMemoryStatus();

       

        
    }

    public static void printMemoryStatus() {
        System.out.println("==========================================================");
        System.out.println("Block#   Size    Start-End   Status");
        System.out.println("==========================================================");
        for (int i = 0; i < memoryBlocks.size(); i++) {
            memoryBlocks.get(i).printInfo(i);
        }
        System.out.println("==========================================================");
    }

    
}


