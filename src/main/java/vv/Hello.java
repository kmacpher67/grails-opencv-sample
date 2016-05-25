package vv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;


/**
 * Created by 310237766 on 5/24/2016.
 */
public class Hello {

    public Hello(){
        System.out.println("hello constructor");
    }

    static {
//        String path = "C:\\opencv\\build\\java\\x64\\opencv_java310.dll";
        String path1 = "C:/opencv/build/java/x64/opencv_java310.dll";
//        System.load(path);
        System.load(path1);
        //Runtime.getRuntime().load0(groovy.lang.GroovyClassLoader.class, path)
    }
    public String index() {

        System.out.println("Welcome to OpenCV " + Core.VERSION);
        System.out.println("Welcome to OpenCV NATIVE_LIBRARY_NAME= " + Core.NATIVE_LIBRARY_NAME);
        String opencvpath = System.getProperty("user.dir") + "\\files\\";
        System.out.println("user.dir="+opencvpath);
        String libPath = System.getProperty("java.library.path");
        System.out.println("libPath="+libPath);
        System.load(opencvpath + Core.NATIVE_LIBRARY_NAME + ".dll");

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat m  = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("m = " + m.dump());
        return m.dump();
    }


}
