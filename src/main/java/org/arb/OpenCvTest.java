package org.arb;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpenCvTest {
    public OpenCvTest() {
    }

    public boolean processImage2() throws Exception {
//        System.load("D:\\opencv\\build\\java\\x64\\opencv_java440.dll");
//        System.load("D:\\opencv\\build\\java\\opencv-440.jar");

        // To load  OpenCV core library
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        String input = "C:\\Users\\arbuzov\\Downloads\\IMG_20200823_112141.jpg";

        // To Read the image
//        start();

        // Creating the empty destination matrix
        //Mat destination = new Mat();

        // Converting the image to gray scale and
        // saving it in the dst matrix
//        Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY);

        // Writing the image
//        Imgcodecs.imwrite("C:\\Users\\arbuzov\\Downloads\\grayIMG_20200823_112141.jpg", destination);
//        System.out.println("The image is successfully to Grayscale");

//        for ( int i = -10; i <= 10; i++) {
//            VideoCapture c = new VideoCapture(0);
//
//            c.read(matrix);
//            if (c.isOpened()) {
//                if (c.read(matrix)) {
//                    BufferedImage image = new BufferedImage(matrix.width(),
//                            matrix.height(), BufferedImage.TYPE_3BYTE_BGR);
//
//                    WritableRaster raster = image.getRaster();
//                    DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
//                    byte[] d = dataBuffer.getData();
//                    matrix.get(0, 0, d);
//                }
//                Imgcodecs.imwrite("C:\\Users\\arbuzov\\Downloads\\aa.png", matrix);
//            } else {
//                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
//            }
//        }
        start();
        return false;
    }

    public void start() throws Exception {
        Stage stage = new Stage();

        WritableImage writableImage = null;
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        VideoCapture c = new VideoCapture(0);


        BufferedImage image = null;


        ImageView img = new ImageView(writableImage);
        img.setFitHeight(400);
        img.setFitWidth(600);
        img.setPreserveRatio(true);
        Group r = new Group(img);
        Scene s = new Scene(r, 600, 400);
        stage.setTitle("Capturing an image");
        stage.setScene(s);
        stage.setAlwaysOnTop(true);
        stage.show();

        Mat matrix = new Mat();
        c.read(matrix);
        if(c.isOpened()) {
            if (c.read(matrix)) {

//                Thread.sleep(3000);
                image = new BufferedImage(matrix.width(),
                        matrix.height(), BufferedImage.TYPE_3BYTE_BGR);

                WritableRaster raster = image.getRaster();
                DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
                byte[] d = dataBuffer.getData();
                int a = 0;
                while (a < 1000) {
                    matrix.get(0, 0, d);

                    writableImage = SwingFXUtils.toFXImage(image, null);
                    img.setImage(writableImage);
                    img.requestFocus();
                    a++;
                }




                saveImage(matrix);
            }
        }





        c.release();

    }

    public void saveImage(Mat matrix) {
        String f = "C:\\Users\\arbuzov\\Downloads\\aa.bmp";
        Imgcodecs imageCodecs = new Imgcodecs();
        imageCodecs.imwrite(f, matrix);
    }

    public boolean isFaceExists(Mat image)
    {
        org.arb.FaceDetectionController detection = new org.arb.FaceDetectionController();
        detection.init();
        Rect[] facesArray = detection.getDetectedFaces(image);

        for (int i = 0; i < facesArray.length; i++) {

//            Imgproc.rectangle(image, facesArray[i].tl(), facesArray[i].br(),
//                    new Scalar(0, 255, 0), 3);
            return true;
        }
        return false;
    }
}
