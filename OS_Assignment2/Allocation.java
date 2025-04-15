/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ospp2;


import java.util.ArrayList;
import java.util.List;

public class Allocation {

    public void FirstFit(String pID,int pSize,List<Block> memoryBlocks){ //Allocate the first available block that is large enough.
        int firstFit = -1;
    for (Block block : memoryBlocks) {
        if (!block.isAllocated) {
            if (block.blockSize >= pSize) {
                firstFit = memoryBlocks.indexOf(block);
                break;
            }
        }
    }

    // Check if we found a suitable block
    if (firstFit == -1) {
        System.out.println("Error: No suitable block found for process " + pID);
        return;
    }
        Block firstFitedBlock=memoryBlocks.get(firstFit);
        firstFitedBlock.isAllocated=true;
        firstFitedBlock.processID=pID;
        int internalFragmentation = internalFragmentation(firstFitedBlock.blockSize, pSize);
        firstFitedBlock.internalFragmentation=internalFragmentation;

        System.out.println(firstFitedBlock.processID+//
        " Allocated at address "+firstFitedBlock.startAddress+//
        ", and the internal fragmentation is "+firstFitedBlock.internalFragmentation);

    }
    public void BestFit(String pID,int pSize,List<Block> memoryBlocks){  // Allocate the smallest block that is large enough.
         int bestFit = -1;
    for (Block block : memoryBlocks) {
        if (block.blockSize >= pSize) {
            if (bestFit == -1) {
                bestFit = memoryBlocks.indexOf(block);
            } else if (memoryBlocks.get(bestFit).blockSize > block.blockSize) {
                bestFit = memoryBlocks.indexOf(block);
            }
        }
    }

    // Check if we found a suitable block
    if (bestFit == -1) {
        System.out.println("Error: No suitable block found for process " + pID);
        return;
    }
        Block bestFitedBlock=memoryBlocks.get(bestFit);
        bestFitedBlock.isAllocated=true;
        bestFitedBlock.processID=pID;
        int internalFragmentation = internalFragmentation(bestFitedBlock.blockSize, pSize);
        bestFitedBlock.internalFragmentation=internalFragmentation;

        System.out.println(bestFitedBlock.processID+//
        " Allocated at address "+bestFitedBlock.startAddress+//
        ", and the internal fragmentation is "+bestFitedBlock.internalFragmentation);
        

    }
    public void WorstFit(String pID,int pSize,List<Block> memoryBlocks){
         int worstFit = -1;
    for (Block block : memoryBlocks) {
        if (block.blockSize >= pSize) {
            if (worstFit == -1) {
                worstFit = memoryBlocks.indexOf(block);
            } else if (memoryBlocks.get(worstFit).blockSize < block.blockSize) {
                worstFit = memoryBlocks.indexOf(block);
            }
        }
    }

    // Check if we found a suitable block
    if (worstFit == -1) {
        System.out.println("Error: No suitable block found for process " + pID);
        return;
    }
        Block worstFittedBlock=memoryBlocks.get(worstFit);
        worstFittedBlock.isAllocated=true;
        worstFittedBlock.processID=pID;
        int internalFragmentation = internalFragmentation(worstFittedBlock.blockSize, pSize);
        worstFittedBlock.internalFragmentation=internalFragmentation;

        System.out.println(worstFittedBlock.processID+//
        " Allocated at address "+worstFittedBlock.startAddress+//
        ", and the internal fragmentation is "+worstFittedBlock.internalFragmentation);
    }

    public int internalFragmentation(int blockSize, int processSize){
        return blockSize - processSize;
    }
}
