# [NeoPeptide](http://www.neopeptide.cn/)
### What is NeoPeptide
NeoPeptide is a catalog of epitopes derived from neoantigens, arising from somatic mutations, captured from the literatures and immunological resources. NeoPeptide could help researchers identify neoantigens in different cancers (e.g., melanoma, breast cancer, lung cancer, squamous cell carcinoma, etc) and search for appropriate cancer vaccine candidates. Experimentally characterized neo-epitopes are available in this database, as well as data on MHC binding and MHC ligand elution experiments, with additional information such as the nucleic acid and amino acid exchange of the corresponding neoantigens. The database represents the experimental contexts in which these peptides were determined to be immune neoepitopes. Neoepitopes recognized in humans and mice are included. Both positive and negative experimental results are captured. Currently, NeoPeptide contains more than 170,000 data of neoantigens and more than 12,000 mutated genes. NeoPeptide also provides useful links, which further support searches of functions of mutated proteins or neoepitopes.

### Database implementation 
The NeoPeptide database was built using tomcat 9.0.7(web server) and MySQL (database server). All data were processed and organized into a MySQL Database Management System (version 5.7.20). The framework of the website were designed and implemented using the Java Spring MVC and user interface was developed using html, css and jQuery libraries. Charts of downloads and views in statistics pages were produced by Highcharts 5.0.12. The website has been tested in several popular web browsers, including Internet Explorer, Google Chrome and Firefox.

### How to compile
A computer with a Java environment and a java IDE. Use the IDE to compile the code downloaded from github and generate war files.

### How to deploy
A computer with tomcat9.0.7 and mysql. First, download the .dbf file from the NeoPeptide website and import it into the mysql database. Then copy the war file compiled from code to the tomcat/webapps directory. Start tomcat by startup.exe in tomcat/bin, access the address through the browser. For example in local machine access http://localhost:8080/bic

### How to use external link [IEDB](https://www.iedb.org/)
1. Since the IEDB web server does not support external link directly, users need to add the inputs manually. For convenience, we also develop a script based on the google chrome browser to help user add the inputs automatically. In particular, an extra script running on the user’s local browser needs to be installed. Firstly, a user opens the google chrome server and installs an extension named [Tampermonkey](https://chrome.google.com/webstore/detail/tampermonkey/dhdgffkkebhmkfjojejmpbldmpobfkfo?utm_source=chrome-ntp-icon) at google web store. 
![Tampermonkey](https://github.com/Priest-zhi/neopeptide/raw/master/doc/fig1.png)
2. Secondly, a user uses chrome to open website https://greasyfork.org/en/scripts/380715-iedb for installing our script, and clicks "install this script".
![Tampermonkey](https://github.com/Priest-zhi/neopeptide/raw/master/doc/fig2.png)
3. The new tab page will be shown in the following, and a user needs to click “install”.
![Tampermonkey](https://github.com/Priest-zhi/neopeptide/raw/master/doc/fig3.png)
4. After the installation, user opens "Dashboard" of Tampermonkey, and clicks “IEDB”.
![Tampermonkey](https://github.com/Priest-zhi/neopeptide/raw/master/doc/fig4.png)
![Tampermonkey](https://github.com/Priest-zhi/neopeptide/raw/master/doc/fig5.png)
5. Next, choose "Settings" and select "document-body" at "Run at". 
![Tampermonkey](https://github.com/Priest-zhi/neopeptide/raw/master/doc/fig6.png)
6. After finishing all the installation and the setting, user could add the inputs automatically and see the related results by clicking "submit" at IEDB. 
![Tampermonkey](https://github.com/Priest-zhi/neopeptide/raw/master/doc/fig7.png)
![Tampermonkey](https://github.com/Priest-zhi/neopeptide/raw/master/doc/fig8.png)

