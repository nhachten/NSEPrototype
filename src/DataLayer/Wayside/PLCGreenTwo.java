/******************************************************************************
 * 
 * PLCGreenTwo class
 * 
 * Developed by AJility
 * April 2014
 * CoE 1186
 * 
 * Contributers:
 *  Nathaniel W. Hachten
 *
 *****************************************************************************/

package DataLayer.Wayside;

import DataLayer.Bundles.*;
import DataLayer.EnumTypes.*;
import DataLayer.TrackModel.*;
import java.util.*;

/**
 *<h1>PLCGreenTwo</h1>
 * <p>
 * This class contains the PLC for the Green Line controller that controls the middle portion
 * of the Green Line according to the excel layout</p>
 * @author nwhachten
 */
public class PLCGreenTwo extends PLC{
    private boolean enteringJ;
    private boolean holdAtYard;
    private boolean leavingJ;
    private boolean stoppingAtJEnd;
    private int trainsInJ;

    public PLCGreenTwo(int id, LineColor line, HashMap routeTable) {
        super(id, line, routeTable);
        this.trainsInJ = 0;
        this.enteringJ = false;
        this.leavingJ = false;
        this.stoppingAtJEnd = false;
        this.holdAtYard = false;
    }
    
    //plcProgram() is the method that overrides PLC abstract method. This is the portion of code
    //specific to this portion of the Track
    //Returns - Commands, the commands for this program given a set of inputs
    @Override
    protected Commands plcProgram() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Commands c;
        c = new Commands();
        
        Block block152 = this.blocks.get(152);
        Block block57 = this.blocks.get(57);
        Block block58 = this.blocks.get(58);
        Block block62 = this.blocks.get(62);
        Block block61 = this.blocks.get(61);
        Block block60 = this.blocks.get(60);
        Switch switch1 = this.switches.get(1);
        Switch switch4 = this.switches.get(4);
        boolean dir;
       // System.out.println("PLC id: " + this.id + " PLC line " + this.line);
       // System.out.println("block152: " + block152.getBlockID());
        //System.out.println("switch1: " + switch1.SwitchID);
        
        if (block57.isOccupied() && !block58.isOccupied())
        {
            //if (block57.getDestination() == 151 || block57.getDestination() == 0)
            if (true) //hard code to tell train to go back to yard
            {
                dir = false;
                if (switch4.StraightBlock == 151) dir = true;
                c.pushCommand(new Switch(LineColor.GREEN, switch4.SwitchID, switch4.ApproachBlock,
                        switch4.StraightBlock, switch4.DivergentBlock, dir));
            }
            else
            {
                dir = false;
                if (switch4.StraightBlock == 58) dir = true;
                c.pushCommand(new Switch(LineColor.GREEN, switch4.SwitchID, switch4.ApproachBlock,
                        switch4.StraightBlock, switch4.DivergentBlock, dir));
                enteringJ = true;
            }
        }
        
        if (block58.isOccupied() && !block57.isOccupied())
        {
            if (enteringJ)
            {
                enteringJ = false;
                trainsInJ++;
            }
        }
        
        if (block152.isOccupied() && !block62.isOccupied())
        {
            if (!leavingJ)
            {
                 //set switch state
                 dir = false;
             //System.out.println("Switch 1: " + switch1.SwitchID);
             if (switch1.StraightBlock == 152) dir = true;
             c.pushCommand(new Switch(LineColor.GREEN, switch1.SwitchID, switch1.ApproachBlock,
             switch1.StraightBlock, switch1.DivergentBlock, dir));
             /*c.pushCommand( new BlockSignalBundle(block60.getAuthority(), block60.getDestination(),
                     0.0, block60.getBlockID(), LineColor.GREEN));
             c.pushCommand( new BlockSignalBundle(block61.getAuthority(), block61.getDestination(),
                     0.0, block61.getBlockID(), LineColor.GREEN));*/
             stoppingAtJEnd = true;
             holdAtYard = false;
            }
            else
            {
                c.pushCommand(new BlockSignalBundle(block152.getAuthority(), block152.getDestination(),
                    0.0, block152.getBlockID(), LineColor.GREEN));
                holdAtYard = true;
            }
        }
        
        if (block60.isOccupied() && !block61.isOccupied())
        {
            if (!stoppingAtJEnd)
            {
                c.pushCommand(new BlockSignalBundle(block60.getAuthority(), block60.getDestination(),
                    block60.getSpeedLimit(), block60.getBlockID(), LineColor.GREEN));
            }
            else
            {
                c.pushCommand(new BlockSignalBundle(block60.getAuthority(), block60.getDestination(),
                    0.0, block60.getBlockID(), LineColor.GREEN));
            }
        }
        
        if (block61.isOccupied() && !block60.isOccupied())
        {
            //leavingJ = true;
            if (!stoppingAtJEnd)
            {
                leavingJ = true;
                dir = false;
                if (switch1.StraightBlock == 61) dir = true;
                c.pushCommand(new Switch(LineColor.GREEN, switch1.SwitchID, switch1.ApproachBlock,
                    switch1.StraightBlock, switch1.DivergentBlock, dir));
                c.pushCommand(new BlockSignalBundle(block61.getAuthority(), block61.getDestination(),
                    block61.getSpeedLimit(), block61.getBlockID(), LineColor.GREEN));
                
            }
            else
            {
               /* c.pushCommand(new BlockSignalBundle(block61.getAuthority(), block61.getDestination(),
                    0.0, block61.getBlockID(), LineColor.GREEN));*/
            }
        }
                 
        
        if (block62.isOccupied() && !block61.isOccupied())
        {
            if (leavingJ)
            {
                trainsInJ--;
                leavingJ = false;
            }
            if (holdAtYard)
            {
                c.pushCommand(new BlockSignalBundle(block152.getAuthority(), block152.getDestination(),
                    block152.getSpeedLimit(), block152.getBlockID(), LineColor.GREEN));
                dir = false;
                if (switch1.StraightBlock == 152) dir = true;
                c.pushCommand(new Switch(LineColor.GREEN, switch1.SwitchID, switch1.ApproachBlock,
             switch1.StraightBlock, switch1.DivergentBlock, dir));
                holdAtYard = false;
            }
            
            stoppingAtJEnd = false;
        }
        
        
        
        
        return c;
        
        
    
    
    }
    
}
