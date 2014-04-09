package DataLayer.TrackModel;

import DataLayer.Bundles.*;
import java.util.*;
import DataLayer.EnumTypes.*;
import DataLayer.Train.*;
import java.io.*;

public class TrackModel 
{
    public ArrayList<Line> theLines;
    public ArrayList<TrainLocation> theTrainLocations;
    public ArrayList<Train> theTrains;
    private LineColor lineColor;
    
    
    public TrackModel()
    {
        
        theLines = new ArrayList<>();
        theLines.add(new Line(LineColor.GREEN));
        theLines.add(new Line(LineColor.RED));
        uploadTrackSpec();
        
    }
    
    public final void uploadTrackSpec()
    {
        String csvFile = "track.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
        
        int blockID, stationID, next, prev, approach, divergent, straight;
        int tswitchID = 0;
        double speedLimit, length, elevation, cumElev, gradient;
        boolean underground, light, rrxing, station, tswitch;
        String stationString;
        
        try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
                    String[] blockSpec = line.split(cvsSplitBy);
                    
                    if (blockSpec[0].equalsIgnoreCase("green"))
                    {
                        if (blockSpec[1].equalsIgnoreCase("b"))
                        {
                            blockID = Integer.parseInt(blockSpec[2]);
                            length = Double.parseDouble(blockSpec[3]);
                            
                            next = Integer.parseInt(blockSpec[4]);
                            prev = Integer.parseInt(blockSpec[5]);
                            if (next < 0 || prev < 0)
                            {
                            	tswitch = true;
                            	if(next < 0)
                            	{
                            	    tswitchID = next - (2 * next);
                            	}
                            	else if(prev < 0)
                            	{
                            	    tswitchID = prev - (2 * prev);
                            	}
                            	light = true;
                            }
                            else
                            {
                            	tswitch = false;
                            	tswitchID = -1;
                            	light = false;
                            }
                            
                            gradient = Double.parseDouble(blockSpec[6]);
                            elevation = Double.parseDouble(blockSpec[7]);
                            cumElev = Double.parseDouble(blockSpec[8]);
                            
                            speedLimit = Double.parseDouble(blockSpec[9]);
                            speedLimit = speedLimit * 1000.0;
                            speedLimit = speedLimit / 3600.0;
                            
                            station = Boolean.parseBoolean(blockSpec[10]);
                            if (station)
                            {
                                stationID = Integer.parseInt(blockSpec[11]);
                                stationString = blockSpec[12];
                            }
                            else
                            {
                                stationID = -1;
                                stationString = "";
                            }
                            
                            underground = Boolean.parseBoolean(blockSpec[13]);
                            rrxing = Boolean.parseBoolean(blockSpec[14]);

                            Block b = new Block(blockID, next, prev, length, speedLimit, elevation, cumElev, gradient, underground, light, rrxing, station, tswitch);
                            b.setStationID(stationID);
                            b.setStationString(stationString);
                            b.setTswitchID(tswitchID);
                            theLines.get(0).theBlocks.add(b);
                        }
                        else if(blockSpec[1].equalsIgnoreCase("s"))
                        {
                            blockID = Integer.parseInt(blockSpec[2]);
                            approach = Integer.parseInt(blockSpec[3]);
                            straight = Integer.parseInt(blockSpec[4]);
                            divergent = Integer.parseInt(blockSpec[5]);
                            Switch s = new Switch(LineColor.GREEN, blockID, approach, straight, divergent, true);
                            theLines.get(0).theSwitches.add(s);
                        }
                    }
                    else if(blockSpec[0].equalsIgnoreCase("red"))
                    {
                        if (blockSpec[1].equalsIgnoreCase("b"))
                        {
                            blockID = Integer.parseInt(blockSpec[2]);
                            length = Double.parseDouble(blockSpec[3]);
                            
                            next = Integer.parseInt(blockSpec[4]);
                            prev = Integer.parseInt(blockSpec[5]);
                            if (next < 0 || prev < 0)
                            {
                            	tswitch = true;
                            	if(next < 0)
                            	{
                            	    tswitchID = next - (2 * next);
                            	}
                            	else if(prev < 0)
                            	{
                            	    tswitchID = prev - (2 * prev);
                            	}
                            	light = true;
                            }
                            else
                            {
                            	tswitch = false;
                            	tswitchID = -1;
                            	light = false;
                            }
                            
                            gradient = Double.parseDouble(blockSpec[6]);
                            elevation = Double.parseDouble(blockSpec[7]);
                            cumElev = Double.parseDouble(blockSpec[8]);
                            
                            speedLimit = Double.parseDouble(blockSpec[9]);
                            speedLimit = speedLimit * 1000.0;
                            speedLimit = speedLimit / 3600.0;
                            
                            station = Boolean.parseBoolean(blockSpec[10]);
                            if (station)
                            {
                                stationID = Integer.parseInt(blockSpec[11]);
                                stationString = blockSpec[12];
                            }
                            else
                            {
                                stationID = -1;
                                stationString = "";
                            }
                            
                            underground = Boolean.parseBoolean(blockSpec[13]);
                            rrxing = Boolean.parseBoolean(blockSpec[14]);

                            Block b = new Block(blockID, next, prev, length, speedLimit, elevation, cumElev, gradient, underground, light, rrxing, station, tswitch);
                            b.setStationID(stationID);
                            b.setStationString(stationString);
                            b.setTswitchID(tswitchID);
                            theLines.get(1).theBlocks.add(b);
                        }
                        else if(blockSpec[1].equalsIgnoreCase("s"))
                        {
                            blockID = Integer.parseInt(blockSpec[2]);
                            approach = Integer.parseInt(blockSpec[3]);
                            straight = Integer.parseInt(blockSpec[4]);
                            divergent = Integer.parseInt(blockSpec[5]);
                            Switch s = new Switch(LineColor.RED, blockID, approach, straight, divergent, true);
                            theLines.get(1).theSwitches.add(s);
                        }
                    }
                    
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	System.out.println("Track Model is done reading spec.");
    }
    
    public void setBlockInfo(BlockInfoBundle b)
    {
        int line = 0;
        lineColor = b.LineID;
        switch (lineColor)
        {
            case GREEN:
                line = 0;
            case RED:
                line = 1;
        }
        int block = b.BlockID;
        theLines.get(line).theBlocks.get(block).setRRXingState(b.RRXingState);
        theLines.get(line).theBlocks.get(block).setLightColor(b.LightColor);
    }
    
    public BlockInfoBundle getBlockInfoBundle(LineColor line, int block)
    {
        int lineNum = 0;
        switch (line)
        {
            case GREEN:
                lineNum = 0;
            case RED:
                lineNum = 1;
        }
        XingState s = theLines.get(lineNum).theBlocks.get(block).getRRXingState();
        LightColor l = theLines.get(lineNum).theBlocks.get(block).getLightColor();
        boolean c = theLines.get(lineNum).theBlocks.get(block).isClosed();
        BlockInfoBundle b = new BlockInfoBundle(l, s, block, line, c);
        return b;
    }
    
    public void setBlockSignal(BlockSignalBundle b)
    {
        int line = 0;
        lineColor = b.LineID;
        switch (lineColor)
        {
            case GREEN:
                line = 0;
            case RED:
                line = 1;
        }
        int block = b.BlockID;
        theLines.get(line).theBlocks.get(block).setAuthority(b.Authority);
        theLines.get(line).theBlocks.get(block).setDestination(b.Destination);
        theLines.get(line).theBlocks.get(block).setVelocity(b.Speed);
    }
    
    public BlockSignalBundle getBlockSignalBundle(LineColor line, int block) 
    {
        int lineNum = 0;
        switch (line)
        {
            case GREEN:
                lineNum = 0;
            case RED:
                lineNum = 1;
        }
        int a = theLines.get(lineNum).theBlocks.get(block).getAuthority();
        int d = theLines.get(lineNum).theBlocks.get(block).getDestination();
        double s = theLines.get(lineNum).theBlocks.get(block).getVelocity();
        boolean c = theLines.get(lineNum).theBlocks.get(block).isClosed();
        BlockSignalBundle b = new BlockSignalBundle(a, d, s, block, line, c);
        return b;
    }
    
    public TrackSignal getTrackSignal(LineColor line, int block)
    {
        int lineNum = 0;
        switch (line)
        {
            case GREEN:
                lineNum = 0;
            case RED:
                lineNum = 1;
        }
        int a = theLines.get(lineNum).theBlocks.get(block).getAuthority();
        int d = theLines.get(lineNum).theBlocks.get(block).getDestination();
        String dd = theLines.get(lineNum).theBlocks.get(d).getStationString();
        double s = theLines.get(lineNum).theBlocks.get(block).getVelocity();
        double g = theLines.get(lineNum).theBlocks.get(block).getGradient();
        boolean u = theLines.get(lineNum).theBlocks.get(block).isUnderground();
        TrackSignal t = new TrackSignal(s, a, u, dd, g);
        return t;
    }
    
    public void setDispatchSignal(DispatchBundle d)
    {
    	int line = 0;
    	int block = 0;
        lineColor = d.toLine;
        if (lineColor == LineColor.GREEN)
        {
            
                line = 0;
                block = 152;
        }
        else
        {
            
                line = 1;
                block = 77;
        }
        theLines.get(line).theBlocks.get(block).setAuthority(d.Authority);
        theLines.get(line).theBlocks.get(block).setDestination(d.Destination);
        theLines.get(line).theBlocks.get(block).setVelocity(d.Speed);
        
        theTrainLocations.get(d.trainID).setStartLocation(line);
        
        boolean u = theLines.get(line).theBlocks.get(block).isUnderground();
        int dest = theLines.get(line).theBlocks.get(block).getDestination();
        String dd = theLines.get(line).theBlocks.get(dest).getStationString();
        double g = theLines.get(line).theBlocks.get(block).getGradient();
        
        TrackSignal t = new TrackSignal(d.Speed, d.Authority, u, dd, g);
        
        theTrains.get(d.trainID).setTrackSignal(t);
    }
    
    public void updateTrainLocations()
    {
    	for(int i = 0; i < theTrainLocations.size(); i++)
    	{
    	    double deltaX = theTrains.get(i).getDeltaX();
    	    LineColor line = theTrainLocations.get(i).line;
    	    int lineNum = 0;
            switch (line)
            {
                case GREEN:
                    lineNum = 0;
                    break;
                case RED:
                    lineNum = 1;
                    break;
            }
    	    int block = theTrainLocations.get(i).currentBlock;
    	    int prev = theLines.get(lineNum).theBlocks.get(block).prev;
    	    int next = theLines.get(lineNum).theBlocks.get(block).next;
    	    double length = theLines.get(lineNum).theBlocks.get(block).getLength();
    	    theTrainLocations.get(i).updateLocation(deltaX, length, prev, next);
    	    
    	    block = theTrainLocations.get(i).currentBlock;
    	    
    	    int a = theLines.get(lineNum).theBlocks.get(block).getAuthority();
            int d = theLines.get(lineNum).theBlocks.get(block).getDestination();
            String dd = theLines.get(lineNum).theBlocks.get(d).getStationString();
            double s = theLines.get(lineNum).theBlocks.get(block).getVelocity();
            double g = theLines.get(lineNum).theBlocks.get(block).getGradient();
            boolean u = theLines.get(lineNum).theBlocks.get(block).isUnderground();
            TrackSignal t = new TrackSignal(s, a, u, dd, g);
            
            theTrains.get(i).setTrackSignal(t);
    	    
    	}
    }
    
}
