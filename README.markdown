# Head First Android Development - Code Samples 

Welcome. This is the repo for the Head First Android Development book's code samples. 
If you've already purchased the book, thanks! And if you haven't, I encourage you to buy it from O'Reilly here: http://oreilly.com/catalog/0636920012825. 
You can find a link here to buy either the digital edition, the print edition, or both. Currently, the book is in 
early release in digital only format, and is being updated regularly until final publication (currently estimated in late October).  

### Installation Instructions

1. Be sure to have Eclipse and the Android SDK installed according to the instructions in Chapter 1. 
1. Open up a terminal and create and CD into a new directory called HFAD-Code-Samples anywhere on your computer<pre>mkdir HFAD-Code-Samples<br/>cd HFAD-Code-Samples</pre>
1. Clone the git repo by entering the following command: <pre>git clone git@github.com:jonathansimon/HFAD-Code-Samples.git .</pre>
1. Open up eclipse and open the HFAD-Code-Samples directory as your workspace. You'll need to switch workspaces or open this as the default workspace. 
1. Set the Android SDK location in Eclipse. This is stored by workspace, so even if you set the Android SDK location for another workspace, you'll need to do it again here. You can set the location by going to Eclipse -> Preferences -> Android and entering the Android SDK Location
1. Set the JRE to 1.5 or 1.6. You can set the JRE for the workspace by going to Eclipse -> Preferences -> Java -> Installed JRE's and selecting 1.5 or 1.6
1. Import the projects by going to File -> Import -> Existing projects into workspace. Select the HFAD-Code-Samples directory and you'll see all of the chapter projects display in the dialog window. Select all and press Finish. 

And you're ready to run the sample apps! 

### Organization 

All of the code samples for the book are in this repo organized by chapter subfolders. 
Each subfolder maps to a single chapter, and is named starting with the chapter number followed by the name of the app. 
The code in each of the folders is meant to closely mimic the project at the END of the chapter. 

So for example, CH02_Android_Love refers to the 'AndroidLove' project at the END of Chapter 2. 

### Code packages 

Since the projects span multiple chapters, chapter numbers were also inserted into the package names in 
AndroidManifest.xml as well as the source code packages. This allows you to run the different versions 
of the apps as they stand and the end of each chapter at the same time without worrying about collisions or update issues.

So, for the app in CH02_Android_Love, you'll see a source package name of: com.headfirstlabs.ch02.android.love


### Work in progress

This code is a work in progress and is not yet complete. More chapter will be added (there are a total of 12 in the book). 
Additionally, there will be minor updates to the code as the chapters are updated. I'll also be working to update the 
documentation for each of the projects.

If there are things you'd like covered with the existing apps, please let me know. The book suggests possible further extensions to these apps. 
If there is interest, I can add those extensions here in extension projects. 

For issues with the source code, feel free to add bugs here or email me directly at jonathan.s.simon@gmail.com. 
For issues with the book itself, please submit errata on the O'Reilly site: http://oreilly.com/catalog/0636920012825. 
This way, my editorial staff and I can track issues and deal with them accordingly.      
 