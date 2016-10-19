package org.sgutierr.documentParser;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jbpm.document.Document;



public class DocumentParserExample {

	
	public List<String[]> getContentParsed (Document doc)  {
		
		List<String[]> allContent = new ArrayList<String[]>();	
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
                              
        try {
       	    
        	ByteArrayInputStream is = new ByteArrayInputStream(doc.getContent());	        
        	br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                
                        String[] entrada = line.split(cvsSplitBy);

                        System.out.println("IdContrato: " + entrada[0]
                                + " , CodAgrupacion: " + entrada[6]
                                + " , SegComercial: " + entrada[1]                 
                                + " , TipoRNR: " + entrada[8]
                                + " , TipoPersona: " + entrada[18]
                                + " , TipoProducto:" + entrada[4]
                                        );
                        
                        String[] lineArr  = new String[6];
                        lineArr[0] =  entrada[0];
                        lineArr[1] = entrada[6];
                        lineArr[2] = entrada[1];
                        lineArr[3] = entrada[8];
                        lineArr[4] = entrada[18];
                        lineArr[5] = entrada[4];
                       
                        allContent.add(lineArr);
                }
        } catch (Exception e) {
	          e.printStackTrace();
	      }
                              
     return allContent;                   
                        
		
	}
	
	public BufferedReader converByteToBufferReader (byte[] content){
		  
	      InputStream is = null;
	      BufferedReader bfReader = null;
	      try {
	          is = new ByteArrayInputStream(content);
	          bfReader = new BufferedReader(new InputStreamReader(is));
	          String temp = null;
	          while((temp = bfReader.readLine()) != null){
	              System.out.println(temp);
	          }
	      } catch (IOException e) {
	          e.printStackTrace();
	      } finally {
	          try{
	              if(is != null) is.close();
	          } catch (Exception ex){
	               
	          }
	      }

		  return bfReader;
	  }	
	
	public void todo (){
		
	/*	

	// Get the document provided for user with all contracts.
	//
	org.sgutierr.documentParser.DocumentParserExample docToParse = new org.sgutierr.documentParser.DocumentParserExample();
	System.out.println("Get contracts");
	org.jbpm.document.Document doc =(org.jbpm.document.Document) kcontext.getVariable("documentIn");
	

	// Convert to BufferReader.
	//

	java.io.ByteArrayInputStream is = new ByteArrayInputStream(doc.getContent());	   
	java.io.BufferedReader bfReader = new BufferedReader(new InputStreamReader(is));
	
	// Create A new pocIncomeS parsed list
	//    
	List<String[]> allContent = new ArrayList<String[]>();	
    String line = "";
    String cvsSplitBy = ";";
	
    java.util.List contracts_tmp = new java.util.ArrayList();
    while ((line = bfReader.readLine()) != null) {
    
            String[] entrada = line.split(cvsSplitBy);

            System.out.println("IdContrato: " + entrada[0]
                    + " , CodAgrupacion: " + entrada[6]
                    + " , SegComercial: " + entrada[1]                 
                    + " , TipoRNR: " + entrada[8]
                    + " , TipoPersona: " + entrada[18]
                    + " , TipoProducto:" + entrada[4]
                            );
            pocuo.pocproject.pocIncome tempP= new pocuo.pocproject.pocIncome();       

                      tempP.setId_contrato(entrada[0]);
                      tempP.setCod_agrupacion(entrada[6]);
                      tempP.setSeg_comercial(entrada[1]);
                      tempP.setTipo_RNR(entrada[8]);
                      tempP.setTipo_pers(entrada[18]);
                      tempP.setTipo_prod(entrada[4]);
                      tempP.setId_cartera("");     
                      contracts_tmp.add(tempP);

    }
     
    kcontext.setVariable("contractsCollection",contracts_tmp);
    System.out.println("Contracts: "+contracts_tmp.size()+" added to the process");

    // create a collection to hold our multi-instance results.
    //
    java.util.List reviews_results_tmp = new java.util.ArrayList();
    kcontext.setVariable("contractsResults",reviews_results_tmp);
    System.out.println("variable set");

    */

	}
}
