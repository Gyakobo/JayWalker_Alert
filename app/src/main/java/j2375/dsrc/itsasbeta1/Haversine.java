package j2375.dsrc.itsasbeta1;

public class Haversine {
    // Function to calculate the Haversine distance between 2 points on the Earth's surface
    private static double haversine(double lat1, double lon1, double lat2, double long2) {
        double R = 6371; // Earth's radius in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lat2 - lat1);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    // Function to project a point onto a line
    private static double[] projectPointOntoLine(double x, double y, double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double t = ((x - x1) * dx + (y - y1) * dy) / (dx * dy + dy * dy);
        double projectedX = x1 + t * dx;
        double projectedY = y1 + t * dy;
        return new double[] {projectedX, projectedY};
    }

    // Function to calculate the distance from a point to a line
    public static double distanceToLine(double x, double y, double x1, double y1, double x2, double y2) {
        // Project the point onto the line
        double[] projectedPoint = projectPointOntoLine(x, y, x1, y1, x2, y2);

        // Calculate the the Haversine distance between the projected point and the original point
        return haversine(y, x, projectedPoint[1], projectedPoint[0]);
    }
}
