/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataLayer.Wayside;

import DataLayer.Bundles.BlockInfoBundle;
import DataLayer.Bundles.BlockSignalBundle;
//import DataLayer.Bundles.Switch;
import DataLayer.TrackModel.Switch;
import DataLayer.EnumTypes.LineColor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nwhachten
 * @version 1.0
 * @since 2014-04-02
 */
public final class Wayside {
    private final TrackController[] controllers;
    private final int controllerCount = 6;
    //private final int[][] blockNums;
    //private final LineColor[] lines;
    
    
    public Wayside(BlockInfoBundle[] blockInfoArray, BlockSignalBundle[] blockSignalArray)
    {
        int[][] blockNums = new int[][]{{0,1},{2,3},{4,5},{5,6},{6,7},{8,9}};
        LineColor[] lines = new LineColor[] {LineColor.GREEN, LineColor.GREEN, LineColor.GREEN,
            LineColor.RED, LineColor.RED, LineColor.RED};
        this.controllers = new TrackController[controllerCount];
        
        for (int i = 0; i < controllerCount; i++)
        {
            controllers[i] = new TrackController(i, lines[i], blockNums[i]);
        }
        
        this.setBlockInfoArray(blockInfoArray);
        this.setBlockSignalArray(blockSignalArray);
        
        
    }
    
    public void sendTravelSignal(BlockSignalBundle packet)
    {
        LineColor line = packet.getLineID();
        int blockNum = packet.getBlockID();
        
        for (int i=0; i < controllerCount; i++)
        {
            if (controllers[i].getLine() == line)
            {
                for (int b : controllers[i].getBlockNums() )
                {
                    if (b == blockNum)
                    {
                        this.controllers[i].sendTravelSignal(packet);
                    }
                }
            }
        }
    }
    
    public void sendSwitchStateSignal(Switch packet)
    {
        for (TrackController tc : this.controllers)
        {
            if (tc.getLine() == packet.getLineID() && tc.containsBlock(packet.getBlockID()))
            {
                tc.sendSwitchStateSignal(packet);
                break;
            }
        }
    }
    
    public void setBlockInfoArray(BlockInfoBundle[] blockInfoArray)
    {
        List<List<BlockInfoBundle>> list;
        list = new ArrayList<>(controllerCount);
        
        for (BlockInfoBundle b : blockInfoArray)
        {
            for (TrackController tc : this.controllers)
            {
                if (b.getLineID() == tc.getLine() && tc.containsBlock(b.getBlockID()))
                {
                    //add block to tc's arraylist
                    list.get(tc.getId()).add(b);
                }
            }
        }
        for (TrackController tc : this.controllers)
        {
            tc.setTrackBlockInfo(list.get(tc.getId()));
        }
    }
    
    public void setBlockSignalArray(BlockSignalBundle[] blockSignalArray)
    {
        List<List<BlockSignalBundle>> list;
        list = new ArrayList<>(controllerCount);
        
        for (BlockSignalBundle b : blockSignalArray)
        {
            for (TrackController tc : this.controllers)
            {
                if (b.getLineID() == tc.getLine() && tc.containsBlock(b.getBlockID()))
                {
                    //add block to tc's arraylist
                    list.get(tc.getId()).add(b);
                }
            }
        }
        for (TrackController tc : this.controllers)
        {
            tc.setTrackSignalInfo(list.get(tc.getId()));
        }
        
    }
    
    public ArrayList<BlockSignalBundle> getBlockSignalCommands()
    {
        ArrayList<BlockSignalBundle> commands;
        commands = new ArrayList<>();
        
        for (TrackController tc : this.controllers)
        {
            for (BlockSignalBundle c : tc.getCommandSignalQueue())
            {
                commands.add(c);
            }
        }
        
        return commands;
    }
    
    public ArrayList<BlockInfoBundle> getBlockInfoCommands()
    {
        ArrayList<BlockInfoBundle> commands;
        commands = new ArrayList<>();
        
        for (TrackController tc : this.controllers)
        {
            for (BlockInfoBundle c : tc.getCommandBlockQueue())
            {
                commands.add(c);
            }
        }
        
        return commands;
    }
    
    public ArrayList<Switch> getSwitchCommands()
    {
        ArrayList<Switch> commands;
        commands = new ArrayList<>();
        
        for (TrackController tc : this.controllers)
        {
            for (Switch c : tc.getCommandSwitchQueue())
            {
                commands.add(c);
            }
        }
        
        return commands;
    }
    
   
    
    
    
}
