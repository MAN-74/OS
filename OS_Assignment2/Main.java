
package OS_Assignment2;

import java.util.*;

public class Main {
    
    static List<Block> memoryBlocks = new ArrayList<>();
    static int allocationStrategy;
    static Scanner scanner = new Scanner(System.in);
    static Allocation allocation = new Allocation();


    public static void main(String[] args) {
        
        initializeMemory();
        
        
        boolean running = true;
        while (running) {
            System.out.println("============================================");
            System.out.println("1) Allocates memory blocks");
            System.out.println("2) De-allocates memory blocks");
            System.out.println("3) Print report about the current state of memory and internal Fragmentation");
            System.out.println("4) Exit");
            System.out.println("============================================");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                 case 1:
                        allocateMemory();
                    break;
                  
                case 2:
                        deallocateMemory();
                    break;
                case 3:
                        printMemoryStatus(true);
                    break;
                case 4:
                        running = false;
                        System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void initializeMemory() {
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
        printMemoryStatus(false);
    }

    public static void allocateMemory() {
        System.out.println("Enter the process ID and size of process: ");
        String pID = scanner.next();
        int pSize = scanner.nextInt();

        switch (allocationStrategy) {
            case 1:
                allocation.FirstFit(pID, pSize, memoryBlocks);
                break;
            case 2:
                allocation.BestFit(pID, pSize, memoryBlocks);
                break;
            case 3:
                allocation.WorstFit(pID, pSize, memoryBlocks);
                break;
            default:
                System.out.println("Invalid allocation strategy!");
        }
    } 

    public static void deallocateMemory() {
        System.out.print("Enter the process ID to deallocate: ");
        String processToRemove = scanner.next();
        boolean found = false;
        for (Block block : memoryBlocks) {
            if (block.isAllocated && block.processID.equals(processToRemove)) {
                block.isAllocated = false;
                block.processID = "Null";
                block.internalFragmentation = 0;
                found = true;
                System.out.println("Process " + processToRemove + " has been deallocated.");
                break;
            }
        }
        if (!found) {
            System.out.println("Process ID not found or already free.");
        }
    }

 public static void printMemoryStatus(boolean finalReport) {
    if (!finalReport) {
       
        System.out.println("==========================================================");
        System.out.println("Block#   Size    Start-End   Status");
        System.out.println("==========================================================");
        for (int i = 0; i < memoryBlocks.size(); i++) {
            Block block = memoryBlocks.get(i);
            System.out.printf("Block%-3d  %-6d  %4d-%-4d   %-10s%n",
                    i, block.blockSize, block.startAddress, block.endAddress,
                    block.isAllocated ? "allocated" : "free");
        }
        System.out.println("==========================================================");
    } else {
       
        System.out.println("==========================================================");
        System.out.println("Block#   Size    Start-End   Status      ProcessID    InternalFragmentation");
        System.out.println("==========================================================");
        for (int i = 0; i < memoryBlocks.size(); i++) {
            Block block = memoryBlocks.get(i);
            System.out.printf("Block%-3d  %-6d  %4d-%-4d   %-10s    %-10s    %-2d%n",
                    i, block.blockSize, block.startAddress, block.endAddress,
                    block.isAllocated ? "allocated" : "free", block.processID, block.internalFragmentation);
        }
    }
}

}
