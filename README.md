# grails-opencv-sample
simple sample grails opencv fix! 

This started as a stack-trace question that I was interested in. 

You need to have the OPENCV DLL in the PATH & in the files directory. IDK why. 

````
set PATH=%PATH%;C:\opencv\build\java\x64
grails run-app
```` 

Copy the DLL to a new directory called "files" in your grails app home directory. 
I don't know why this is. but this makes it work, where the DLL has to be in both locations. 

I've added it to here or add the default opencv location to the baseline path. 
```C:\Windows\System32\WindowsPowerShell\v1.0```

