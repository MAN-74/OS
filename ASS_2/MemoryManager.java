package ASS_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoryManager {
    static List<Block> memoryBlocks = new ArrayList<>();
    static int allocationStrategy; // 1: First-Fit, 2: Best-Fit, 3: Worst-Fit

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
        System.out.println("Enter the process ID and size of process: ");
        String pID=scanner.next();
        int pSize=scanner.nextInt();

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

    public static void main(String[] args) {
        initializeMemory();  // Call this once at the beginning
    }
}


