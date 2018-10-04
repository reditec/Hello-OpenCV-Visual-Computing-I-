import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.util.Arrays;

public class HelloOpenCV {
    public static void main(String[] args){
        System.out.println("Hello world");

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("success");

        Mat m = new Mat(3,2, CvType.CV_8UC3, new Scalar(0,0,255));
        System.out.println("M:\n" + m);
        System.out.println("M:\n" + m.dump());

        System.out.println("Zeilen:\n" + m.rows());
        System.out.println("Spalten:\n" + m.cols());
        System.out.println("Farb-Kanäle:\n" + m.channels());

        double[] data = {0,255,255};
        m.put(1,1,data);
        System.out.println("M:\n" + m.dump());

        double[] getData = m.get(0,0);
        System.out.println("getData: " + Arrays.toString(getData));

        //
        double[] data1 = {3, 4, 2, 5, 6, 2, 1, 8, 9};
        Mat a = new Mat(3, 3, CvType.CV_64F);
        a.put(0,0,data1);
        System.out.println("A: \n" + a.dump());

        //Transpose
        Mat at = new Mat();
        at = a.t();
        System.out.println("AT: " + at.dump());

        System.out.println("det(A) =" + Core.determinant(a));

        //Inverse
        Mat B = a.inv();
        System.out.println("B: \n" + B.dump());

        //Multiplication, element vise
        Mat C = B.mul(a);
        System.out.println("C: \n" + C.dump());

        //Matrix mult
        Mat E = new Mat();
        Core.gemm(a, B, 1, B, 0, E);
        System.out.println("E: \n" + E.dump());

        //Assignment
        Mat F = new Mat();
        //F = A;
        //F = A.clone();
        a.copyTo(F);
        System.out.println("A: \n" + a.dump());
        System.out.println("F: \n" + F.dump());
        F.put( 2, 2, 888);
        System.out.println("A: \n" + a.dump());
        System.out.println("F: \n" + F.dump());

    }
}
