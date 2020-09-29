package main.java.org.arb;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

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
        Mat destination = new Mat();

        // Converting the image to gray scale and
        // saving it in the dst matrix
        Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY);

        // Writing the image
        Imgcodecs.imwrite("C:\\Users\\arbuzov\\Downloads\\grayIMG_20200823_112141.jpg", destination);
        System.out.println("The image is successfully to Grayscale");
        aaa();
        return "ok";
    }

    public void aaa()
    {

    }
}
