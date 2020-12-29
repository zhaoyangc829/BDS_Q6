import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class Pnpoly {
        private final List<double[]> points;
        private final List<double[]> vertices;
        private double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE,
                       maxX = Double.MIN_VALUE, maxY = Double.MIN_VALUE;

    public Pnpoly(String pointsFilePath, String verticesFilePath) {
        points = loadPoints(pointsFilePath, false);
        vertices = loadPoints(verticesFilePath, true);

    }

    public void start() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("./output.txt"))));
            for (double[] point : this.points) {
                bw.write(check(point) + "\r\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private List<double[]> loadPoints(String filePath, boolean isPolygon) {
        List<double[]> points = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
            String text;
            while ((text = br.readLine()) != null) {
                String[] coordinate = text.split(" ");
                if (coordinate.length < 2)
                    continue;
                double[] corList = new double[2];
                double x = Double.parseDouble(coordinate[0]);
                double y = Double.parseDouble(coordinate[1]);
                if (isPolygon) {
                    minX = Math.min(x, minX);
                    maxX = Math.max(x, maxX);
                    minY = Math.min(y, minY);
                    maxY = Math.max(y, maxY);
                }
                corList[0] = x;
                corList[1] = y;
                points.add(corList);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return points;
    }

    private boolean check(double[] point) {
        boolean isIn = false;
        if (point[0] < minX || point[0] > maxX || point[1] < minY || point[1] > maxX)
            return false;
        int i, j;
        for (i = 0, j = this.vertices.size() - 1; i < this.vertices.size(); j = i++) {
            if (((vertices.get(i)[1] > point[1]) != (vertices.get(j)[1] > point[1])) &&
                    (point[0] < (vertices.get(j)[0] - vertices.get(i)[0]) * (point[1] - vertices.get(i)[1]) / (vertices.get(j)[1] - vertices.get(i)[1]) + vertices.get(i)[0])) {
                isIn = !isIn;
            }
        }
        return isIn;
    }
}
