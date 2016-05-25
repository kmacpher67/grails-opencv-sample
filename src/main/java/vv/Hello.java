package vv;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import java.io.File;

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

    public String faceDetect(String xmlcascade, String imagelocation){
        String opencvpath = System.getProperty("user.dir") + "\\files\\";
        System.load(opencvpath + Core.NATIVE_LIBRARY_NAME + ".dll");
        System.out.println("\nRunning DetectFaceDemo");
        System.out.println("\nxmlcascade="+ xmlcascade);
        System.out.println("\nimagelocation="+ imagelocation);
        File filecascade = new File(xmlcascade);
        System.out.println(" class=" + filecascade.exists());
        // Create a face detector from the cascade file in the resources
        // directory.

        CascadeClassifier faceDetector = new CascadeClassifier(filecascade.toString());
        System.out.println("\nfaceDetector empty="+ faceDetector.empty());
        System.out.println(" imagelocation= "+ imagelocation);
        Mat image = Imgcodecs.imread(imagelocation);
        System.out.println(" java mat = " + image);
        // Detect faces in the image.
        // MatOfRect is a special container class for Rect.
        MatOfRect faceDetections = new MatOfRect();
        System.out.println("\nfaceDetections="+ faceDetections);
        faceDetector.detectMultiScale(image, faceDetections);
        System.out.println("\nfaceDetector="+ faceDetector);
        System.out.println(String.format("Detected %s faces",
                faceDetections.toArray().length));

        // Draw a bounding box around each face.
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }

        // Save the visualized detection.
        String filename = "faceDetection.png";
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, image);
        return filename;
    }

}
