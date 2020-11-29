package org.arb;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class OpenCvTest {
    public OpenCvTest() {
    }

    public String test() throws Exception {
//        System.load("D:\\opencv\\build\\java\\x64\\opencv_java440.dll");
//        System.load("D:\\opencv\\build\\java\\opencv-440.jar");

        // To load  OpenCV core library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String input = "C:\\Users\\arbuzov\\Downloads\\IMG_20200823_112141.jpg";

        // To Read the image
        Mat source = Imgcodecs.imread(input);

        // Creating the empty destination matrix
        //Mat destination = new Mat();

        // Converting the image to gray scale and
        // saving it in the dst matrix
//        Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY);

        // Writing the image
//        Imgcodecs.imwrite("C:\\Users\\arbuzov\\Downloads\\grayIMG_20200823_112141.jpg", destination);
//        System.out.println("The image is successfully to Grayscale");
        aaa(source);
        return "ok";
    }

    public void aaa(Mat image)
    {
        System.out.println("1=====================");
        org.arb.FaceDetectionController detection = new org.arb.FaceDetectionController();
        System.out.println("2=====================");
        detection.init();
        System.out.println("3=====================");
        detection.detectAndDisplay(image);
        System.out.println("4=====================");
    }
}
