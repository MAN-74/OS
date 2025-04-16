
package OS_Assignment2;

import java.util.*;

class Block {
    int blockSize;
    int startAddress;
    int endAddress;
    boolean isAllocated;
    String processID;
    int internalFragmentation;

    public Block(int blockSize, int startAddress) {
        this.blockSize = blockSize;
        this.startAddress = startAddress;
        this.endAddress = startAddress + blockSize - 1;
        this.isAllocated = false;
        this.processID = "Null";
        this.internalFragmentation = 0;
    }

    public void printInfo(int blockNumber) {
        System.out.printf("Block%-3d  %-6d  %4d-%-4d   %-10s%n",
                blockNumber, blockSize, startAddress, endAddress,
                isAllocated ? "allocated" : "free" );
    }
}