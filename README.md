# grails-opencv-sample
simple sample grails opencv fix! 

This started as a stack-trace question that I was interested in. 
http://stackoverflow.com/questions/37393736/how-to-get-opencv-to-work-with-grails-3-using-intellij-idea

You need to have the OPENCV DLL in the PATH & in the files directory. IDK why. 

````
set PATH=%PATH%;C:\opencv\build\java\x64
grails run-app
```` 

Copy the DLL to a new directory called "files" in your grails app home directory. 
I don't know why this is. but this makes it work, where the DLL has to be in both locations. 

I've added it to here or add the default opencv location to the baseline path. 

To get this to run in IntelliJ IDEA, looked at the System.out.println and saw that the system libPath was and dropped the .dll here: 
```
C:\Windows\System32\WindowsPowerShell\v1.0
````
