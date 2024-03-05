package j2375.dsrc.itsasbeta1;

import android.util.Log;

import com.snatik.polygon.Polygon;
import com.snatik.polygon.Polygon.Builder;
import com.snatik.polygon.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class CheckPointPolygon {
    public Builder ply; // = new Builder();
    public ArrayList LstPolygon;
    public ArrayList coord;
    //public Double[] XPoints = new Double[];
    //public Double[] YPoints = new Double[];
    public List<Double> Lst =  new ArrayList<Double>();

    public String InorOut(Map<String, ArrayList> PolygonDef, ArrayList Pts){
        String returnval = "Null";
        float pX = ((Double) Pts.get(0)).floatValue();
        float pY = ((Double) Pts.get(1)).floatValue();

        for (String intname : PolygonDef.keySet()) {
            LstPolygon = new ArrayList();
            LstPolygon = PolygonDef.get(intname);
            coord = new ArrayList();
            ply = new Builder();

            for (int i=0;i<LstPolygon.size();i++)
            {
                coord = new ArrayList();
                coord = (ArrayList) LstPolygon.get(i);
                float lat = ((Double) coord.get(0)).floatValue();
                float lon = ((Double) coord.get(1)).floatValue();
                ply.addVertex(new Point(lat,lon));
            }

            Polygon PolygonToCheck = ply.build();

            Point point = new Point(pX,pY);
            boolean contains = PolygonToCheck.contains(point);

            if (contains == true)
            {
                returnval = intname;
                break;
            }
        }
        Log.d(TAG,"Street Name 1: "+returnval);
        return returnval;
    }
}
