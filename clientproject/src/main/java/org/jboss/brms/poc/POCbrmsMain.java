package org.jboss.brms.poc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pocuo.pocproject.pocIncome;


import org.jboss.brms.poc.utils.BRMSUtil;
import org.kie.api.runtime.KieSession;

public class POCbrmsMain {
	
  private static BRMSUtil brmsUtil;
  public static List<pocIncome> results = new ArrayList<pocIncome>();
	
  
  public static void main(String[] args) {

	  if (args.length == 2) {
		 
		  launchPoCRules (args[0]);
		  writeInFile (args[1]);
		  
	  } else{	  		  
		  System.out.println("This program needs two parameters: arg[0]= input file,argo[1]=output file ");
          System.exit(1);
		  
	  }
      
  }
  
public static void launchPoCRules (String csvFile) {	  
        	    
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
         KieSession kSession;                       
        
        try {
       	        br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {
        
                	pocIncome factIn = new pocIncome();
                    
                        String[] entrada = line.split(cvsSplitBy);
                        factIn.setId_contrato(entrada[0]);
                        factIn.setCod_agrupacion(entrada[6]);
                        factIn.setSeg_comercial(entrada[1]);
                        factIn.setTipo_RNR(entrada[8]);
                        factIn.setTipo_pers(entrada[18]);
                        factIn.setTipo_prod(entrada[4]);
                        factIn.setId_cartera("");
                        factIn.setCod_tipologia("");
                                                                                 
                     if (brmsUtil == null) {
                            brmsUtil = new BRMSUtil();
                        }

                     kSession = brmsUtil.getStatefulSession();                                                             
               
                     // Insert facts
                     kSession.insert(factIn);                        
                     
                     if (kSession != null) { 
                          // Fire rules
                         kSession.fireAllRules();
                         if (kSession != null) {
                             kSession.dispose();
                             results.add(factIn);
                         }
                     }
                     else {
                       System.out.println("Invalid KSession");
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

  }
         
  public static boolean writeInFile (String outFile){
	  try{
	  
		 FileWriter writer = new FileWriter(outFile);
		 Iterator<pocIncome> itr = results.iterator();
		 pocIncome tempS;
	     while (itr.hasNext()){
	    	 tempS= (pocIncome) itr.next();    	             
	         writer.append(tempS.getId_contrato());
	         writer.append(",");
	         writer.append(tempS.getCod_agrupacion());
	         writer.append(",");
	         writer.append(tempS.getTipo_pers());
	         writer.append(",");
	         writer.append(tempS.getSeg_comercial());        
	         writer.append(",rules fired:");
	         writer.append(tempS.getCod_tipologia());
	         writer.append(", outcome:");
	         writer.append(tempS.getId_cartera());
	         writer.append('\n');
             System.out.println("IdContrato: " + tempS.getId_contrato()
                     + " , CodAgrupacion: " + tempS.getCod_agrupacion()
                     + " , Rules: " + tempS.getCod_tipologia()                 
                     + " , Id Carter: " + tempS.getId_cartera()    );
	         	       	        	
	     }
		          
      writer.flush();
      writer.close();
  }
  catch(IOException e)
  {
       e.printStackTrace();
  }
	  return true;
  }
  

  
  
}