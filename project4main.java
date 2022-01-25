import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class project4main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		Vertice source = new Vertice("Source",0);
		Vertice sink = new Vertice("Sink",0);
		LinkedList<Vertice> Vehicles = new LinkedList<Vertice>();
		int nOfGreenTrain = in.nextInt();
		ArrayList<Vertice> greenTrains = new ArrayList<Vertice>();
		for(int c = 0; c < nOfGreenTrain; c++) {
			int greenCapacity = in.nextInt();
			Vertice greenTrain = new Vertice("GreenTrain"+c, greenCapacity);
			greenTrain.addConnection(sink, greenCapacity);
			greenTrains.add(greenTrain);
			Vehicles.add(greenTrain);
		}
		
		int nOfRedTrain = in.nextInt();
		ArrayList<Vertice> redTrains = new ArrayList<Vertice>();
		for(int d = 0; d < nOfRedTrain; d++) {
			int redCapacity = in.nextInt();
			Vertice redTrain = new Vertice("RedTrain"+d, redCapacity);
			redTrain.addConnection(sink, redCapacity);
			redTrains.add(redTrain);
			Vehicles.add(redTrain);
		}
		
		int nOfGreenReindeers = in.nextInt();
		ArrayList<Vertice> greenReindeers = new ArrayList<Vertice>();
		for(int e = 0; e < nOfGreenReindeers; e++) {
			int greenReindeerCapacity = in.nextInt();
			Vertice greenReindeer = new Vertice("GreenReindeer"+e, greenReindeerCapacity);
			greenReindeer.addConnection(sink, greenReindeerCapacity);
			greenReindeers.add(greenReindeer);
			Vehicles.add(greenReindeer);
		}
		
		int nOfRedReindeers = in.nextInt();
		ArrayList<Vertice> redReindeers = new ArrayList<Vertice>();
		for(int f = 0; f < nOfRedReindeers; f++) {
			int redReindeerCapacity = in.nextInt();
			Vertice redReindeer = new Vertice("RedReindeer"+f, redReindeerCapacity);
			redReindeer.addConnection(sink, redReindeerCapacity);
			redReindeers.add(redReindeer);
			Vehicles.add(redReindeer);
		}
		
		int nOfGifts = 0;
		int nOfBags = in.nextInt();
		if(nOfBags == 0) {
			out.print(0);
			out.close();
			
		}
		else {
			
		in.nextLine();
		String lastLine = in.nextLine();
		lastLine = lastLine.strip();
		String lineArray[] = lastLine.split(" ");
		Vertice bBags = new Vertice("bBags",0);
		Vertice cBags = new Vertice("cBags",0);
		Vertice dBags = new Vertice("dBags",0);
		Vertice eBags = new Vertice("eBags",0);
		Vertice bdBags = new Vertice("bdBags",0);
		Vertice cdBags = new Vertice("cdBags",0);
		Vertice beBags = new Vertice("beBags",0);
		Vertice ceBags = new Vertice("ceBags",0);
		Vertice noConstraintBags = new Vertice("noConstraintBags",0);
		for(int g = 0; g < lineArray.length; g = g+2) {
				Vertice bag = new Vertice("bag"+g, Integer.valueOf(lineArray[g+1]));
				nOfGifts += bag.getCapacity();
				String name = lineArray[g];
				if(name.equals(" ")) {
					noConstraintBags.setCapacity(noConstraintBags.getCapacity()+bag.getCapacity());
				}
				
				if(name.equals("a")) {
					if(bag.getCapacity() > 0) {
						source.addConnection(bag, bag.getCapacity());
					}
					for(int i = 0; i < Vehicles.size(); i++) {
						bag.addConnection(Vehicles.get(i), 1);
					}
				}
				
				if(name.equals("b")) {
					bBags.setCapacity(bBags.getCapacity()+bag.getCapacity());
					
				}
				
				if(name.equals("c")) {
					cBags.setCapacity(cBags.getCapacity()+bag.getCapacity());
					
				}
				
				if(name.equals("d")) {
					dBags.setCapacity(dBags.getCapacity()+bag.getCapacity());
				}
				
				if(name.equals("e")) {
					eBags.setCapacity(eBags.getCapacity()+bag.getCapacity());
						
				}
				
				
				if(name.equals("ab")) {
					if(bag.getCapacity() > 0) {
						source.addConnection(bag, bag.getCapacity());
					}
					for(int j = 0; j < greenReindeers.size(); j++) {
						bag.addConnection(greenReindeers.get(j), 1);
						
					}
					for(int jj = 0; jj < greenTrains.size(); jj++) {
						bag.addConnection(greenTrains.get(jj), 1);
					}
					
				}
				
				if(name.equals("ac")) {
					if(bag.getCapacity() > 0) {
						source.addConnection(bag, bag.getCapacity());
					}
					for(int k = 0; k < redReindeers.size(); k++) {
						bag.addConnection(redReindeers.get(k), 1);
						
					}
					for(int kk = 0; kk < redTrains.size(); kk++) {
						bag.addConnection(redTrains.get(kk), 1);
					}
				}
				
				if(name.equals("ad")) {
					if(bag.getCapacity() > 0) {
						source.addConnection(bag, bag.getCapacity());
					}
					for(int l = 0; l < redTrains.size(); l++) {
						bag.addConnection(redTrains.get(l), 1);
					
					}
					for(int ll = 0; ll < greenTrains.size(); ll++) {
						bag.addConnection(greenTrains.get(ll), 1);
					}
				}
				
				if(name.equals("ae")) {
					if(bag.getCapacity() > 0) {
						source.addConnection(bag, bag.getCapacity());
					}
					for(int m = 0; m < redReindeers.size(); m++) {
						bag.addConnection(redReindeers.get(m), 1);
					}
					for(int mm = 0; mm < greenReindeers.size(); mm++) {
						bag.addConnection(greenReindeers.get(mm), 1);
						
					}
				}
				
				if(name.equals("bd")) {
					bdBags.setCapacity(bdBags.getCapacity()+bag.getCapacity());
				}
				
				if(name.equals("be")) {
					beBags.setCapacity(beBags.getCapacity()+bag.getCapacity());
				}
				
				if(name.equals("cd")) {
					cdBags.setCapacity(cdBags.getCapacity()+bag.getCapacity());
				}
				
				if(name.equals("ce")) {
					ceBags.setCapacity(ceBags.getCapacity()+bag.getCapacity());
				}
				
				if(name.equals("abd")) {
					if(bag.getCapacity() > 0) {
						source.addConnection(bag, bag.getCapacity());
					}
					for(int s = 0; s < greenTrains.size(); s++) {
						bag.addConnection(greenTrains.get(s), 1);
						
					}
				}
				
				if(name.equals("abe")) {
					if(bag.getCapacity() > 0) {
						source.addConnection(bag, bag.getCapacity());
					}
					for(int t = 0; t < greenReindeers.size(); t++) {
						bag.addConnection(greenReindeers.get(t), 1);
						
					}
				}
				
				if(name.equals("acd")) {
					if(bag.getCapacity() > 0) {
						source.addConnection(bag, bag.getCapacity());
					}
					for(int u = 0; u < redTrains.size(); u++) {
						bag.addConnection(redTrains.get(u), 1);
						
					}
				}
				
				if(name.equals("ace")) {
					if(bag.getCapacity() > 0) {
						source.addConnection(bag, bag.getCapacity());
					}
					for(int v = 0; v < redReindeers.size(); v++) {
						bag.addConnection( redReindeers.get(v), 1);
						
					}
				}
				
				
				
				
				
	
		}
		if(noConstraintBags.getCapacity() > 0) {
			source.addConnection(noConstraintBags, noConstraintBags.getCapacity());
			for(int iii = 0; iii < Vehicles.size(); iii++) {
				noConstraintBags.addConnection(Vehicles.get(iii), Vehicles.get(iii).getCapacity());
			}
		}
		

		for(int aa = 0; aa < greenReindeers.size(); aa++) {
			if(bBags.getCapacity() > 0) {
				bBags.addConnection(greenReindeers.get(aa), greenReindeers.get(aa).getCapacity());
			}
			if(eBags.getCapacity() > 0) {
				eBags.addConnection(greenReindeers.get(aa), greenReindeers.get(aa).getCapacity());
			}
			if(beBags.getCapacity() > 0) {
				beBags.addConnection(greenReindeers.get(aa), greenReindeers.get(aa).getCapacity());
			}
			
		}
		
		
			
		for(int aaa = 0; aaa < greenTrains.size(); aaa++) {
			if(bBags.getCapacity() > 0) {
				bBags.addConnection(greenTrains.get(aaa), greenTrains.get(aaa).getCapacity());
			}
			if(dBags.getCapacity() > 0) {
				dBags.addConnection(greenTrains.get(aaa), greenTrains.get(aaa).getCapacity());
			}
			if(bdBags.getCapacity() > 0) {
				bdBags.addConnection(greenTrains.get(aaa), greenTrains.get(aaa).getCapacity());
			}
		}
		
		for(int ab = 0; ab < redReindeers.size(); ab++) {
			if(cBags.getCapacity() > 0) {
				cBags.addConnection(redReindeers.get(ab), redReindeers.get(ab).getCapacity());	
			}
			if(eBags.getCapacity() > 0) {
				eBags.addConnection(redReindeers.get(ab), redReindeers.get(ab).getCapacity());
			}
			if(ceBags.getCapacity() > 0) {
				ceBags.addConnection(redReindeers.get(ab), redReindeers.get(ab).getCapacity());
			}
			
		}
		
		for(int abb = 0; abb < redTrains.size(); abb++) {
			if(cBags.getCapacity() > 0) {
				cBags.addConnection(redTrains.get(abb), redTrains.get(abb).getCapacity());
			}
			if(dBags.getCapacity() > 0) {
				dBags.addConnection(redTrains.get(abb), redTrains.get(abb).getCapacity());
			}
			if(cdBags.getCapacity() > 0) {
				cdBags.addConnection(redTrains.get(abb), redTrains.get(abb).getCapacity());
			}
		}
		
		if(bBags.getCapacity() > 0) {
			source.addConnection(bBags, bBags.getCapacity());
		}
		if(cBags.getCapacity() > 0) {
			source.addConnection(cBags, cBags.getCapacity());
		}
		
		if(dBags.getCapacity() > 0) {
			source.addConnection(dBags, dBags.getCapacity());
		}
		
		if(eBags.getCapacity() > 0) {
			source.addConnection(eBags, eBags.getCapacity());
		
		}
		
		if(bdBags.getCapacity() > 0) {
			source.addConnection(bdBags, bdBags.getCapacity());
		
		}
		
		if(beBags.getCapacity() > 0){
			source.addConnection(beBags, beBags.getCapacity());
	
		}
		
		if(cdBags.getCapacity() > 0) {
			source.addConnection(cdBags, cdBags.getCapacity());
		}
		
		if(ceBags.getCapacity() > 0) {
			source.addConnection(ceBags, ceBags.getCapacity());
		}
		
		FlowNetwork flow = new FlowNetwork(sink, source);
		out.print(nOfGifts-flow.MaxFlow());
		}
	}

}
