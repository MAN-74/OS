package ASS_2;

import java.util.ArrayList;

public class Allocation {

    public void FirstFit(String pID,int pSize,ArrayList<Block> memoryBlocks){ //Allocate the first available block that is large enough.
        for(Block block : memoryBlocks){
           if(block.isAllocated){
                if(block.blockSize>=pSize){
                    block.isAllocated=true;
                    block.processID=pID;
                    break;
                }
           }
        }

    }
    public void BestFit(String pID,int pSize,ArrayList<Block> memoryBlocks){  // Allocate the smallest block that is large enough.
        int bestFit=-1;
        for(Block block : memoryBlocks){
            if(block.blockSize>=pSize){
                if(bestFit==-1){
                    bestFit=memoryBlocks.indexOf(block);
                }
                else if(memoryBlocks.get(bestFit).blockSize>block.blockSize){
                    bestFit=memoryBlocks.indexOf(block);
                }
            }
        }
        Block bestFitedBlock=memoryBlocks.get(bestFit);
        bestFitedBlock.isAllocated=true;
        bestFitedBlock.processID=pID;

    }
    public void WorstFit(String pID,int pSize,ArrayList<Block> memoryBlocks){
        int worstFit=-1;
        for(Block block : memoryBlocks){
            if(block.blockSize>=pSize){
                if(worstFit==-1){
                    worstFit=memoryBlocks.indexOf(block);
                }
                else if(memoryBlocks.get(worstFit).blockSize<block.blockSize){
                    worstFit=memoryBlocks.indexOf(block);
                }
            }
        }
        Block worstFittedBlock=memoryBlocks.get(worstFit);
        worstFittedBlock.isAllocated=true;
        worstFittedBlock.processID=pID;
    }
    
}
