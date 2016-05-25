package hwopencv

import org.opencv.core.Core
import org.opencv.core.CvType
import org.opencv.core.Mat
import vv.Hello;

class HelloController {


    static {
//        String path = "C:\\opencv\\build\\java\\x64\\opencv_java310.dll";
        String path = "C:/opencv/build/java/x64/opencv_java310.dll";
//        System.load(path);
        Runtime.getRuntime().load0(groovy.lang.GroovyClassLoader.class, path)
    }

    def index() {
        Hello hello = new Hello();
        def dump = hello.index();
        render dump
    }

    def index1(){
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        System.out.println("Welcome to OpenCV NATIVE_LIBRARY_NAME= " + Core.NATIVE_LIBRARY_NAME);
        String opencvpath = System.getProperty("user.dir") + "\\files\\";
        System.out.println("user.dir="+opencvpath);
        String libPath = System.getProperty("java.library.path");
        System.out.println("libPath="+libPath);

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat m  = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("m = " + m.dump());
        render m.dump();
    }

    def faceDetect(){
        Hello hello = new Hello();
        def props = grailsApplication.getProperties();
        //System.out.println("grailsApplication.getProperties() = " + grailsApplication.getProperties());
        String filepath = grailsAttributes.getApplicationContext().getResource("/lbpcascade_frontalface.xml").getFile().getAbsolutePath()
        String imageloc = grailsAttributes.getApplicationContext().getResource("/AverageMaleFace.jpg").getFile().getAbsolutePath()
        def faceDetect = hello.faceDetect(filepath, imageloc);
        render "<A href="+faceDetect+"> face detect file ${faceDetect} </a>"
    }
}
