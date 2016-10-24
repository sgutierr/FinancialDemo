# brmsFinancialDemo
Red Hat JBoss BPMS 6.3 demo 

This demo treats to show the suitability of a BRMS system as part of the solutions developed by a financial company.
It wants to build a system that allows BRMS segment contracts under a stipulated criteria, which are determined by the nature of the contract and the characteristics of the client company.
To carry out this demo BRMS must provide 3 deployment mode:
 * Batch
 * Standalone
 * Online

## The demo consists in the following components:
* brms6project: business central rules repository. https://github.com/sgutierr/brmsFinancialDemoRepo.git
* clientproject: simple standalone application that uses the financial rules package in a embedded mode. 
* documentTypeParser: helper class to parse the inbound file.


## Installation:
Previous requirements:
* A JBoss BPM Suite 6.3 or above installation

* Clone the following repository on Authoring->Administrator->Repositories->Clone repository
  https://github.com/sgutierr/brmsFinancialDemoRepo.git
* Download code from documentTypeParse and create a documentTypeParser.jar (mvn clean install)
* Copy ~/target/documentTypeParse.jar to ../jboss-eap-6.4/standalone/deployments/business-central.war/WEB-INF/lib





## FAQs
* Why this demo is executed on JBoss BPM Suite instead of JBoss BRMS?
  The demo uses human tasks in some process to previsualize the results.
