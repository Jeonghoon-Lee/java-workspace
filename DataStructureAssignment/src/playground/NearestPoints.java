package playground;

public class NearestPoints {
    public static double getDistance(double[] point1, double[] point2) {
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }
    public static void main(String[] args) {
        double[][] pointList = {
                {-1, 3},
                {-1, -1},
                {1, 1},
                {2, 0.5},
                {2, -1},
                {3, 3},
                {4, 2},
                {4, -0.5}
        };

        int point1Index = 0;
        int point2Index = 1;
        double nearestDistance = getDistance(pointList[point1Index], pointList[point2Index]);

        for (int i=0; i<pointList.length; i++) {
            for (int j=i+1; j<pointList.length; j++) {
                double distance = getDistance(pointList[i], pointList[j]);
                if (nearestDistance > distance) {
                    point1Index = i;
                    point2Index = j;
                    nearestDistance = distance;
                }
            }
        }
        // Display result
        System.out.format("The closest two points are (%.1f, %.1f) and (%.1f, %.1f)\n",
                pointList[point1Index][0], pointList[point1Index][1],
                pointList[point2Index][0], pointList[point2Index][1]);
    }
}
