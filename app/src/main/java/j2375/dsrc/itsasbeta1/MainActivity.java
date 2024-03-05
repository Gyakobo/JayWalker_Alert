package j2375.dsrc.itsasbeta1;

// Fine Location

import static android.content.ContentValues.TAG;
import static java.lang.Math.round;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.cardiomood.android.controls.gauge.SpeedometerGauge;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;

import org.apache.commons.codec.binary.Hex;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.routing.OSRMRoadManager;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polygon;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import fr.marben.asnsdk.japi.Context;
import fr.marben.asnsdk.japi.Loader;
import fr.marben.asnsdk.japi.spe.Value;
import j2375.dsrc.asncode.dsrc.Connection;
import j2375.dsrc.asncode.dsrc.GenericLane;
import j2375.dsrc.asncode.dsrc.IntersectionGeometry;
import j2375.dsrc.asncode.dsrc.IntersectionState;
import j2375.dsrc.asncode.dsrc.LaneAttributes_Vehicle;
import j2375.dsrc.asncode.dsrc.MapData;
import j2375.dsrc.asncode.dsrc.MovementEvent;
import j2375.dsrc.asncode.dsrc.MovementState;
import j2375.dsrc.asncode.dsrc.NodeSetXY;
import j2375.dsrc.asncode.dsrc.NodeXY;
import j2375.dsrc.asncode.dsrc.Node_LLmD_64b;
import j2375.dsrc.asncode.dsrc.PersonalSafetyMessage;
import j2375.dsrc.asncode.dsrc.SPAT;

public class MainActivity extends AppCompatActivity{ //} implements MqttCallback {

    /* OSM Map */
    // GPT
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    private FusedLocationProviderClient fusedLocationClient;
    private LocationCallback locationCallback;
    ////////////////

    private MapView map;
    private IMapController mapController;
    public Context context = new Context();
    public Context context_psm = new Context();

    MapData mapData;
    public boolean FakeLoc = false;
    private String Cd = "40.74170640304741, -74.1803510852022";
    // private String Cd = "40.741613, -74.18035";
    public double FLat = Double.valueOf(Cd.split(",")[0]);
    public double FLon = Double.valueOf(Cd.split(",")[1]);
    /////////////////////////////////////////////////////////////////////

    /* Pedestrian Coords */
    Vector2f pedVector = new Vector2f(0, 0);
    Vector2f dir = new Vector2f(0, 0);
    /////////////////////////////////////////////////////////////////////

    /* Vehicle Peripherals */
    public List<Double> Lst =  new ArrayList<Double>();
    public Map<String, ArrayList<Double>> IntCoords = new HashMap<String,ArrayList<Double>>();

    public Map<String, String> IntersectionIDs = new HashMap<String,String>();
    public Map<String, String> ClientIDs = new HashMap<String,String>();
    public String DirectionPhNum;
    public String NextIntersection;
    public String PrevIntersection = "Null";
    public double DistToNextInt;
    public double TimeToNextInt;
    public double VehSpeed;
    public double VehBearing;
    public Location AndroidLoc;
    public Location NextIntCoord;
    public Location PSMLoc;

    public Map<String, Object> AllMAPs = new HashMap<String, Object>();
    public String IntID_Lane_Street_PhaseNum;

    public List<Double> FakeLat =  new ArrayList<Double>();
    public List<Double> FakeLon =  new ArrayList<Double>();
    public int FakePosIter = 0;
    public double MinCheckDist = 3.0E-5;
    /////////////////////////////////////////////////////////////////////

    Calendar c1, c2 ;
    private SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");

    private boolean mActive;
    private static boolean flag=false;
    private static boolean flag_psm=false;

    public Object ObjBearingInfo = new Object();

    Timer timer6;
    Timer timer1;
    Timer timer2;
    Timer timer3;
    Timer timer4;
    Timer timer5;
    Timer timer7;
    public JSONObject jsonb;

    static String line = "", str = "";
    public MqttClient VZClient;
    public MqttClient VZClientMAP;
    public MqttClient VZClientPSM;
    public MqttConnectOptions connOpts = new MqttConnectOptions();
    public MqttConnectOptions connOptsMAP = new MqttConnectOptions();
    public MqttConnectOptions connOptsPSM = new MqttConnectOptions();
    public String cID;

    final String brokerUrl = "tcp://vzmode.nyc.wl.dltdemo.io:31234";     /** The broker url. */
    //final String clientId;     /** The client id. */
    final String topic = "VZCV2X/+/+/RSU/NA/NA/+/UPER/SPAT";     /** The topic. */
    final String topicMAP = "REGIONAL/STAT/3/d/r/5/+/+/+/+/+/SW/NA/NA/UPER/MAP/";     /** The topic. */
    final String topicPSM = "VZCV2X/+/+/VRU/PED/NA/+/UPER/PSM";     /** The topic. */

    final String username = "njit";     /** username */
    final String password = "PVoyRXq2o";     /** password */

    private String urlpath = "https://transprod04.njit.edu/SignalIntersection/api/values/Get?FileName=";

    //public Map<String, Polygon> DictData = new HashMap<String,Polygon>(); // this is the collection of polygon for map display
    //public Map<String, ArrayList> DictDataArr = new HashMap<String,ArrayList>(); // this is for the in-out check purpose.

    public List<String> PSMMsgs = new ArrayList<String>();

    //CurrPoint = new GeoPoint(40.74170640304741, -74.18035108520228); // Lock_Warren West
    //CurrPoint = new GeoPoint(40.741457629390574, -74.17975875530463); VehBearing = 110.0; // Summit_Warren East
    //CurrPoint = new GeoPoint(40.7423054722345, -74.18232279579556); VehBearing = 110.0;//Lock_Warren East
    //CurrPoint = new GeoPoint(40.74332409124599, -74.18545114605222); VehBearing = 110.0; //Norfolk_Warren East
//                    CurrPoint = new GeoPoint(40.743811967965826, -74.18688261646628); VehBearing = 110.0; //Hudson_Warren East
//                    CurrPoint = new GeoPoint(40.74388838865761, -74.18690748206504); VehBearing = 300.0; //WestMarket_Warren Wast
//                    CurrPoint = new GeoPoint(40.74619148492786, -74.1909346843811); VehBearing = 110.0; //First_Warren East
    // 40.744124257490334, -74.19045627211962 First_Warren North
    // 40.74582717026662, -74.18969420970672 First WestMarket South Left-turn
    // 40.743833002259265, -74.1867309884951 Warren WestMarket West
    // 40.74356827219225, -74.18683071721168 Warren WestMarket North
    // 40.73882942245464, -74.17565897947921 University South
    // 40.738034340388204, -74.17295669487302 Washington North
    // 40.738002754992564, -74.1730139638721 Halsey South
    // 40.73730478035264, -74.17038856817564 Commerce South
    // 40.73676080918616, -74.16854623092371 Mullberry
    // 40.7360539361948, -74.16637034467921 McCarter



    //public Map<String, Object> intersectionList = new HashMap<String,Object>();
    ArrayList<Object> laneSet = new ArrayList<Object>();

    String responseText;
    StringBuffer response;
    int responseCode = 0;
    URL url;
    Activity activity;
    //ArrayList Coords = new ArrayList();

    ListView listView;
    GeoPoint startPoint;
    GeoPoint CurrPoint;
    LocationManager mLocationManager;
    Marker MyMarker;
    Marker IntersectionMarker;
    public TextView Msg,text, text1, text2, text3,text4,text5,text6,text7,text8,text9,text10,text11, textPedMsg;

    ImageView sigDirections, current_sign, NearbyBicycle; // CrossingPed
    ProgressBar progressBar;

    private SpeedometerGauge speedometer;

    String MAdd;
    private SPAT spatMSG;
    private PersonalSafetyMessage psMsg;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        MAdd = getMacAddress();

        MemoryPersistence persistence = new MemoryPersistence();

        try {
            VZClient  = new MqttClient(brokerUrl, MAdd, persistence);
        } catch (MqttException e) {
            e.printStackTrace();
        }
        connOpts.setCleanSession(true);
        connOpts.setUserName(username);
        connOpts.setPassword(password.toCharArray());

        try {
            VZClientMAP  = new MqttClient(brokerUrl, MAdd+"_MAP", persistence);
        } catch (MqttException e) {
            e.printStackTrace();
        }
        connOptsMAP.setCleanSession(true);
        connOptsMAP.setUserName(username);
        connOptsMAP.setPassword(password.toCharArray());

        try {
            VZClientPSM  = new MqttClient(brokerUrl, MAdd+"_PSM", persistence);
        } catch (MqttException e) {
            e.printStackTrace();
        }
        connOptsPSM.setCleanSession(true);
        connOptsPSM.setUserName(username);
        connOptsPSM.setPassword(password.toCharArray());

        j2375.dsrc.asncode.RuntimeConfiguration.initialize();
        InputStream fis = null;
        InputStream fis_psm = null;

        // Below two lines are need to display a os map
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        RoadManager roadManager = new OSRMRoadManager(this, BuildConfig.APPLICATION_ID);

        Msg= (TextView) findViewById(R.id.textView0);
        //Msg= findViewById(R.id.textView0);
        text6  = findViewById(R.id.textView6);
        text5  = findViewById(R.id.textView5);
        text4  = findViewById(R.id.textView4);
        text3  = findViewById(R.id.textView3);
        text2  = findViewById(R.id.textView2);
        text1  = findViewById(R.id.textView1);
        text  = findViewById(R.id.textView1);

        text7 = findViewById(R.id.place);
        //text8 = findViewById(R.id.distance);
        text9 = findViewById(R.id.sigTimer);
        text10 = findViewById(R.id.TextView04);
        text11 = findViewById(R.id.noSignal);
        textPedMsg = findViewById(R.id.PedMsg);
        textPedMsg.setVisibility(View.GONE);

        speedometer = (SpeedometerGauge) findViewById(R.id.speedometer);

        // Add label converter
        speedometer.setLabelConverter(new SpeedometerGauge.LabelConverter() {
            @Override
            public String getLabelFor(double progress, double maxProgress) {
                return String.valueOf((int) Math.round(progress));
            }
        });

        speedometer.setMaxSpeed(40);
        speedometer.setMajorTickStep(10);

        speedometer.setLabelTextSize(100);
        speedometer.setDefaultColor(Color.GRAY);

        sigDirections = (ImageView)findViewById(R.id.straight);
        progressBar = (ProgressBar) findViewById(R.id.loading);
        // CrossingPed = (ImageView)findViewById(R.id.pedcrossing);
        NearbyBicycle = (ImageView)findViewById(R.id.bycyling);

        sigDirections.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        // CrossingPed.setVisibility(View.GONE);
        NearbyBicycle.setVisibility(View.INVISIBLE);

        // Tipa umnii
        current_sign = (ImageView)findViewById(R.id.bycyling);
        current_sign.setVisibility(View.GONE);

        activity = this;

        try {
            fis = getAssets().open("asntable.dat");
            fis_psm =  getAssets().open("asntable.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // load and define the compiled abstract syntax
        try {
            context.setAbstractSyntax(Loader.load(context, fis));
            context_psm.setAbstractSyntax(Loader.load(context_psm, fis_psm));
            // define the value factory
            context.setValueFactory(new j2375.dsrc.asncode.ValueFactory());
            context_psm.setValueFactory(new j2375.dsrc.asncode.ValueFactory());
            // configuration of the traces
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get MAP Message from each intersection and save it to AllMAPs
        SubscribeMAP("+");

        // Retrive Bearing Data for Each Street
        //GetBearingInfo();

        // Retrive Intersection Name - ID Map
        GetIntersectionIDs();

        while (true) {
            if (AllMAPs.size()>0) {
                Log.d(TAG, "MAP Data Ready");
                break;
            }
        }


        // Retrive lat/lon of each intersection
        //IntersectionCoords();
        // Retrive Polygon Definition for Each Street
        //GetStreetList();

        ArrayList StartLoc = new ArrayList();
        StartLoc = ShowMap();

        //TestUpdateIntIDStreetPhase();
        //TestGetNextIntersection();

        // Retrive the current street name, intersection ID, and associated phase number.
        // Save it to IntID_Lane_Street_PhaseNum, which include lat & lon of the intersection
        // lat_lon_intname_surfix_LaneIdValue_+StreetName@Name_phasennum

        timer6 = new Timer();
        timer6.schedule(new UpdateIntIDStreetPhase(),1000,100);

        // To display the next intersection name and movement direction indicator for the associated phase
        timer1 = new Timer();
        timer1.schedule(new GetNextIntersection(), 1000, 1000);

        //timer2 = new Timer();
        //timer2.schedule(new UpdateFakedVehPos(),250,3600);
        //timer2.schedule(new SubscribePSM(),20,60000);

        subscribePSM(topicPSM);

        timer7 = new Timer();
        timer7.schedule(new GetPSMData(), 30, 200);

        timer3 = new Timer();
        timer3.schedule(new SubscribeSPAT(),0,100);

        timer4 = new Timer();
        timer4.schedule(new GetSignalDataVZ(), 10, 100);

        timer5 = new Timer();
        timer5.schedule(new DistToNextIntersection(),0,100);

    }

//    private void TestGetNextIntersection()
//    {
//        if (IntID_Lane_Street_PhaseNum == null) {
//            NextIntersection = "Null";
//            Log.d(TAG, " No Intersection Name is available");
//            return;
//        }
//
//        ArrayList VehPos = new ArrayList();
//        String StreetName;
//
//        c1 = Calendar.getInstance();
//        String formattedDate = df.format(c1.getTime());
//        text2.setText(formattedDate );
//
//        if (CurrPoint == null)
//        {
//            Location currentLoc = getLastKnownLocation();
//            CurrPoint = new GeoPoint(currentLoc.getLatitude(),currentLoc.getLongitude());
//            System.out.println(formattedDate+" : GPS IS NOT READY");
//        }
//
//        VehPos.add((Double)CurrPoint.getLatitude());
//        VehPos.add((Double)CurrPoint.getLongitude());
//
//        MyMarker.setPosition(CurrPoint);
//        mapController.setCenter(CurrPoint);
//
//        StreetName = IntID_Lane_Street_PhaseNum.split("_")[4];
//        Log.d(TAG,".......................................... Check point  :"+StreetName);
//        if (StreetName.equals("Null")) {
//            text7.setText(" ");
//            sigDirections.setVisibility(View.GONE);
//            progressBar.setVisibility(View.VISIBLE);
//            text9.setVisibility(View.GONE);
//            text11.setVisibility(View.VISIBLE);
//            speedometer.clearColoredRanges();
//            text10.setText(" ");
//            Log.d(TAG,"hidden");
//
//        } else {
//            sigDirections.setVisibility(View.VISIBLE);
//            progressBar.setVisibility(View.GONE);
//            text9.setVisibility(View.VISIBLE);
//            text11.setVisibility(View.GONE);
//        }
//
//        text3.setText(StreetName);
//
//        if (!StreetName.equals("Null")) {
//            //Log.d(TAG, "---------------: " + StreetName);
//            Log.d(TAG, " intersection name : "+StreetName);
//
//            sigDirections.setImageResource(R.drawable.threeway); //Display Movement Direction for the associated phase
//
//            DirectionPhNum = IntID_Lane_Street_PhaseNum.split("_")[5];
//            NextIntersection = StreetName.split("@")[1];
//            text7.setText("Toward "+NextIntersection);
//            //Log.d(TAG, "---------------: " + NextIntersection);
//
//            double Slat = (double)(Integer.valueOf(IntID_Lane_Street_PhaseNum.split("_")[0]))/10000000.0;
//            double Slon = (double)(Integer.valueOf(IntID_Lane_Street_PhaseNum.split("_")[1]))/10000000.0;
//
//            IntersectionMarker.setPosition(new GeoPoint(Slat,Slon));
//            NextIntCoord = new Location("");
//
//            NextIntCoord.setLatitude(Slat);
//            NextIntCoord.setLongitude(Slon);
//
//        }
//        else{
//            NextIntersection = "Null";
//
//        }
//    }

//    private void TestUpdateIntIDStreetPhase()
//    {
//        double x0,y0;
//
//        ArrayList VehPos = new ArrayList();
//        ArrayList IntCoord = new ArrayList();
//        String StreetName;
//
//        if (CurrPoint == null) {
//            Location currentLoc = getLastKnownLocation();
//            CurrPoint = new GeoPoint(currentLoc.getLatitude(), currentLoc.getLongitude());
//            System.out.println("GPS IS NOT READY");
//        }
//
//        //CurrPoint = new GeoPoint(40.741706695972425, -74.18036614640897);
//
//
//        x0 = (Double) CurrPoint.getLongitude();
//        y0 = (Double) CurrPoint.getLatitude();
//
//        VehPos.add(y0);
//        VehPos.add(x0);
//
//        MyMarker.setPosition(CurrPoint);
//        mapController.setCenter(CurrPoint);
//
//        IntID_Lane_Street_PhaseNum = GetStreetNamePhase(x0,y0);
//
//        System.out.println(IntID_Lane_Street_PhaseNum);
//
//    }

    public void SubscribeMAP(String tp) {
        try {
            VZClientMAP.connect(connOptsMAP);
            System.out.println("Mqtt Connected");

            VZClientMAP.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {

                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    //System.out.println(s);
                    if (!flag) {
                        flag = true;
                        try {
                            System.out.println("message arrived");
                            System.out.println(new String(mqttMessage.getPayload()));
                            // StaticMsgOuterClass.StaticMsg staticMsg = StaticMsgOuterClass.StaticMsg.parseFrom(mqttMessage.getPayload());
                            // String mapString =  staticMsg.getMsgTypeBytes().toStringUtf8();
                            decodeMapData(new String(mqttMessage.getPayload()));
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                        flag = false;

                    } else {
                        System.out.println("SKIPPED");
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });

            VZClientMAP.subscribe(topicMAP+tp);

            System.out.println("Subscribed");
            System.out.println("Listening");

        } catch (MqttException me) {
            System.out.println(me);
        }
    }

    public void SetFakePosition(){
        Double lat1 = 40.7435435512319;
        Double lon1 = -74.1861055610153;
        Double lat2 = 40.7422023220757;
        Double lon2 = -74.1819749592302;
        Double dlat = lat2-lat1;
        Double dlon = lon2-lon1;
        Double N = 20.0;
        Double ilat = dlat/N;
        Double ilon = dlon/N;
        FakeLat.add(lat1);
        FakeLon.add(lon1);

        for (int i=0;i<N.intValue();i++){
            lat1 = lat1 + ilat;
            lon1 = lon1 + ilon;
            FakeLat.add(lat1);
            FakeLon.add(lon1);

        }

    }

    public String getMacAddress(){
        try{
            List<NetworkInterface> networkInterfaceList = Collections.list(NetworkInterface.getNetworkInterfaces());
            String stringMac = "";
            for(NetworkInterface networkInterface : networkInterfaceList)
            {
                if(networkInterface.getName().equalsIgnoreCase("wlon0"));
                {
                    for(int i = 0 ;i <networkInterface.getHardwareAddress().length; i++){
                        String stringMacByte = Integer.toHexString(networkInterface.getHardwareAddress()[i]& 0xFF);
                        if(stringMacByte.length() == 1)
                        {
                            stringMacByte = "0" +stringMacByte;
                        }
                        stringMac = stringMac + stringMacByte.toUpperCase() + ":";
                    }
                    break;
                }
            }
            return stringMac;
        }catch (SocketException e)
        {
            e.printStackTrace();
        }
        return  "0";
    }

    public class UpdateFakedVehPos extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    CurrPoint = new GeoPoint(FakeLat.get(FakePosIter), FakeLon.get(FakePosIter)); VehBearing = 110.0; //Norfolk_Warren East
                    FakePosIter = FakePosIter +1;
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch (Exception e) {
                    }


                    if (FakePosIter>FakeLat.size()-1)
                        FakePosIter = 0;
                }
            });
        }
    }

    public class SubscribePSM extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Log.d(TAG, "...........................Subscribe Message............................");

                    if (IntID_Lane_Street_PhaseNum == null) {
                        Log.d(TAG, " SubscribePSM : No Intersection Name for PSM is available");
                        return;
                    }
                    if (IntID_Lane_Street_PhaseNum.split("_").length<3)
                    {
                        Log.d(TAG, " SubscribePSM: No Intersection Phase Number for PSM is available (Incomplete Data)");
                        return;
                    }

                    String IntId = IntID_Lane_Street_PhaseNum.split("_")[2];

                    if (!ClientIDs.containsKey(IntId)) {
                        Log.d(TAG, " SubscribePSM: Phase number not exist : "+IntId);
                        return;
                    }

                    //Log.d(TAG, "psm............................................Intersection ID:" + IntId+">>"+cID);

                    subscribePSM(topicPSM);

                    Log.d(TAG, "............................... Done ............................");


//                    if (IntId == null || IntId.equalsIgnoreCase("Null")) {
//                        Log.d(TAG,"1");
//                        if (VZClientPSM.isConnected()) {
//                            try {
//                                VZClientPSM.disconnect();
//                            } catch (MqttException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        cID = null;
//
//                    } else {
//                        Log.d(TAG,"2");
//
//                        if(cID == null) {
//                            cID = ClientIDs.get(IntId); // ClientIDs.put("Lock_Warren","71");
//                            Log.d(TAG,"Cid: from psm" + cID);
//                            if (cID != null) {
//                                subscribePSM(topicPSM);
//                                Log.d(TAG, " PSM Topic 1: "+topicPSM);
//
//                            }
//                        } else {
//                            Log.d(TAG,"3");
//
//                            if (!cID.equalsIgnoreCase(ClientIDs.get(IntId))) {
//                                Log.d(TAG,"4");
//
//                                if (VZClientPSM.isConnected()) {
//                                    try {
//                                        VZClientPSM.disconnect();
//                                    } catch (MqttException e) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                                cID = ClientIDs.get(IntId);
//                                if (cID != null) {
//                                    subscribePSM(topicPSM);
//                                    Log.d(TAG, " PSM Topic 2: "+topicPSM);
//
//                                }
//                            }
//                        }
//                    }
                }
            });
        }
    }

    public class SubscribeSPAT extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (IntID_Lane_Street_PhaseNum == null) {
                        Log.d(TAG, "SubscribeSPAT:No Intersection Name is available");
                        text7.setText(" ");
                        sigDirections.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);
                        text9.setVisibility(View.GONE);
                        text11.setVisibility(View.VISIBLE);
                        speedometer.clearColoredRanges();
                        text10.setText(" ");

                        return;
                    }

                    if (IntID_Lane_Street_PhaseNum.split("_").length<3)
                    {
                        Log.d(TAG, "SubscribeSPAT: No Intersection Phase Number is available (Incomplete Data)");
                        text7.setText(" ");
                        sigDirections.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);
                        text9.setVisibility(View.GONE);
                        text11.setVisibility(View.VISIBLE);
                        speedometer.clearColoredRanges();
                        text10.setText(" ");
                        return;
                    }

                    String IntId = IntID_Lane_Street_PhaseNum.split("_")[2];

                    if (!ClientIDs.containsKey(IntId)) {
                        Log.d(TAG, "SubscribeSPAT: Phase number not exist : "+IntId);
                        text7.setText(" ");
                        sigDirections.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);
                        text9.setVisibility(View.GONE);
                        text11.setVisibility(View.VISIBLE);
                        speedometer.clearColoredRanges();
                        text10.setText(" ");
                        return;
                    }

                    //Log.d(TAG, "............................................Intersection ID:" + IntId);

                    if (IntId == null || IntId.equalsIgnoreCase("Null")) {
                        if (VZClient.isConnected()) {
                            try {
                                VZClient.disconnect();
                            } catch (MqttException e) {
                                e.printStackTrace();
                            }
                        }
                        cID = null;
//                        text7.setText(" ");
//                        sigDirections.setVisibility(View.GONE);
//                        progressBar.setVisibility(View.VISIBLE);
//                        text9.setVisibility(View.GONE);
//                        text11.setVisibility(View.VISIBLE);

                    } else {
                        if(cID == null) {
                            cID = ClientIDs.get(IntId); // ClientIDs.put("Lock_Warren","71");
                            Log.d(TAG,"Cid from spat:" + cID);

                            if (cID != null) {
                                subscribeSPAT("VZCV2X/+/+/RSU/NA/NA/"+cID+"/UPER/SPAT");
                                Log.d(TAG, " SPAT Topic 1: "+"VZCV2X/+/+/RSU/NA/NA/"+cID+"/UPER/SPAT");

                            }
                            //else {
//                                text7.setText(" ");
//                                sigDirections.setVisibility(View.GONE);
//                                progressBar.setVisibility(View.VISIBLE);
//                                text9.setVisibility(View.GONE);
//                                text11.setVisibility(View.VISIBLE);
//                            }
                        } else {
                            if (!cID.equalsIgnoreCase(ClientIDs.get(IntId))) {
                                if (VZClient.isConnected()) {
                                    try {
                                        VZClient.disconnect();
                                    } catch (MqttException e) {
                                        e.printStackTrace();
                                    }
                                }
                                cID = ClientIDs.get(IntId);
                                if (cID != null) {
                                    subscribeSPAT("VZCV2X/+/+/RSU/NA/NA/"+cID+"/UPER/SPAT");
                                    Log.d(TAG, " SPAT Topic 2: "+"VZCV2X/+/+/RSU/NA/NA/"+cID+"/UPER/SPAT");

                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public String setEventState(int id) {
        String eventState = "null";
        switch (id) {
            case 0 : eventState = "unavailable";
                break;
            case 1 : eventState = "dark";
                break;
            case 2 : eventState = "stop-Then-Proceed";
                break;
            case 3 : eventState = "stop-And-Remain";
                break;
            case 4 : eventState = "pre-Movement";
                break;
            case 5 : eventState = "permissive-Movement-Allowed";
                break;
            case 6 : eventState = "protected-Movement-Allowed";
                break;
            case 7 : eventState = "permissive-clearance";
                break;
            case 8 : eventState = "protected-clearance";
                break;
            case 9 : eventState = "caution-Conflicting-Traffic";
                break;

        }
        return eventState;
    }


    class GetPSMData extends TimerTask {
        Map<String, String> JsonResults;
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // CrossingPed.setVisibility(View.GONE);
                        NearbyBicycle.setVisibility(View.GONE);
                        textPedMsg.setVisibility(View.GONE);

                        sigDirections.setImageDrawable(current_sign.getDrawable());

                        if (PSMMsgs.size() == 0) {
                            //Log.d(TAG, "No PSM Message");
                            return;
                        }

                        for (String psmstring:PSMMsgs){
                            printPSM(psmstring);
                        }

                        PSMMsgs = new ArrayList<String>();

                    }catch (Exception e) {
                        System.out.println("Error in PSM Data ");
                        e.printStackTrace();
                    }



                }
            });
        }
    }
    class GetSignalDataVZ extends TimerTask {
        Map<String, String> JsonResults;
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    c2 = Calendar.getInstance();
                    String formattedDate = df.format(c2.getTime());
                    String CurSignalStatus = null;

                    //Log.d(TAG, "Intersection Data:" + NextIntersection);

                    //NextIntersection = "Lock_Warren";
                    //DirectionPhNum = "2";

                    if (IntID_Lane_Street_PhaseNum == null) {
                        Log.d(TAG, " No Intersection Name is available");
                        text7.setText(" ");
                        sigDirections.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);
                        text9.setVisibility(View.GONE);
                        text11.setVisibility(View.VISIBLE);
                        speedometer.clearColoredRanges();
                        text10.setText(" ");
                        text3.setText(" ");
                        text4.setText(" ");
                        text5.setText(" ");
                        text6.setText(" ");

                        return;
                    }

                    if (IntID_Lane_Street_PhaseNum.split("_").length<3)
                    {
                        Log.d(TAG, " No Intersection Name is available");
                        text7.setText(" ");
                        sigDirections.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);
                        text9.setVisibility(View.GONE);
                        text11.setVisibility(View.VISIBLE);
                        speedometer.clearColoredRanges();
                        text10.setText(" ");
                        text3.setText(" ");
                        text4.setText(" ");
                        text5.setText(" ");
                        text6.setText(" ");
                        return;
                    }

                    String IntId = IntID_Lane_Street_PhaseNum.split("_")[2];

                    if (!ClientIDs.containsKey(IntId)) {
                        Log.d(TAG, " No Intersection Name is available");
                        text7.setText(" ");
                        sigDirections.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);
                        text9.setVisibility(View.GONE);
                        text11.setVisibility(View.VISIBLE);
                        speedometer.clearColoredRanges();
                        text10.setText(" ");
                        text3.setText(" ");
                        text4.setText(" ");
                        text5.setText(" ");
                        text6.setText(" ");
                        return;
                    }

                    if(spatMSG == null) {
                        Log.d(TAG,"No SPAT Message");
                        return;
                    }

                    //Log.d(TAG,"Json Size:" + jsonb);

                    if (NextIntersection != null) {
                        //Log.d(TAG, "................................................................"+NextIntersection);
                        JsonResults = new HashMap<String, String>();
                        if(spatMSG != null) {
                            IntersectionState intersectionState = (IntersectionState) spatMSG.intersections.valueList.get(0);
                            //spatMSG = null;

                            String id = String.valueOf(intersectionState.id.id.value);
                            if (!id.equals(IntId))
                                return;

                            String timeStamp = String.valueOf(intersectionState.timeStamp.value);
                            for (Object o : intersectionState.states.valueList) {
                                MovementState movementState = (MovementState) o;
                                String SG = String.valueOf(movementState.signalGroup.value);
                                if (SG.equals(DirectionPhNum)) {
                                    MovementEvent MvmtEvent = (MovementEvent) movementState.state_time_speed.valueList.get(0);
                                    String EventState = setEventState(MvmtEvent.eventState.getValue());
                                    String startTime = String.valueOf(MvmtEvent.timing.startTime.value);
                                    String minEndTime = String.valueOf(MvmtEvent.timing.minEndTime.value);
                                    String nextTime = String.valueOf(MvmtEvent.timing.nextTime.value);

                                    JsonResults.put("timeStamp",timeStamp);
                                    JsonResults.put("SigStatus",EventState);
                                    JsonResults.put("startTime",startTime);
                                    JsonResults.put("minEndTime",minEndTime);
                                    JsonResults.put("nextTime",nextTime);

                                    text4.setText(EventState);

                                    break;
                                }
                            }
                        }
                        else
                        {
                            text3.setText(" ");
                            text4.setText(" ");
                            text5.setText(" ");
                            text6.setText(" ");
                        }

                        if (JsonResults.size()>0) {
                            int RemTime = (Integer.parseInt(JsonResults.get("minEndTime")) - Integer.parseInt(JsonResults.get("timeStamp")))/10 ;

                            speedometer.clearColoredRanges();
                            sigDirections.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                            text9.setVisibility(View.VISIBLE);
                            text11.setVisibility(View.GONE);
                            text9.setTextSize(24);
                            //Log.d(TAG,"-------------------------------Here");

                            if (JsonResults.get("SigStatus").equals("protected-Movement-Allowed")) {
                                // sigDirections.setColorFilter(Color.GREEN);
                                current_sign.setColorFilter(Color.GREEN);
                                CurSignalStatus = "Green, Remaining Green: " + String.valueOf(RemTime);
                                if (String.valueOf(RemTime).equals("200")) {
                                    text9.setTextSize(16);
                                    text9.setText("Unable to Get Remaining Time(Actuated Control)");
                                }
                                else
                                    text9.setText("To Red in "+String.valueOf(RemTime)+" Seconds");
                                //text9.setText("To Red in "+String.valueOf(RemTime)+" Seconds");
                                if (DistToNextInt > 0) CalcAdvSpd_GY(RemTime);

                            } else if (JsonResults.get("SigStatus").equals("protected-clearance")) {
                                CurSignalStatus = "Yellow, Remaining Green: " + String.valueOf(RemTime);
                                // sigDirections.setColorFilter(Color.YELLOW);
                                current_sign.setColorFilter(Color.YELLOW);
                                if (String.valueOf(RemTime).equals("200")) {
                                    text9.setTextSize(16);
                                    text9.setText("Remaining Time Unavailable: Actuated Control");
                                }
                                else
                                    text9.setText("To Red in "+String.valueOf(RemTime)+" Seconds");
                                //text9.setText("To Red in "+String.valueOf(RemTime)+" Seconds");
                                if (DistToNextInt > 0) CalcAdvSpd_GY(RemTime);

                            } else if (JsonResults.get("SigStatus").equals("stop-And-Remain")) {
                                CurSignalStatus = "Red, Remaining Red: " + String.valueOf(RemTime);
                                // sigDirections.setColorFilter(Color.RED);
                                current_sign.setColorFilter(Color.RED);
                                if (String.valueOf(RemTime).equals("200")) {
                                    text9.setTextSize(16);
                                    text9.setText("Remaining Time Unavailable: Actuated Control");
                                }
                                else
                                    text9.setText("To Green in "+String.valueOf(RemTime)+" Seconds");
                                //text9.setText("To Green in "+String.valueOf(RemTime) +" Seconds");
                                if (DistToNextInt > 0) CalcAdvSpd_R(RemTime);
                            } else {
                                CurSignalStatus = "---";
                            }

                            //text4.setText(formattedDate);
                            text5.setText(CurSignalStatus);
                        }
//                        else {
//                            text7.setText(" ");
//                            sigDirections.setVisibility(View.GONE);
//                            System.out.println("no signal data");
//                            progressBar.setVisibility(View.VISIBLE);
//                            text9.setVisibility(View.GONE);
//                            text11.setVisibility(View.VISIBLE);
//                        }
                    }

                }
            });
        }

        private void CalcAdvSpd_GY(int retime)
        {
            // s = vt
            double a = 0.0; // required acceleration rate
            double av = 0.0;  //advisory speed.
            double fps = 1.46667 * VehSpeed;
            double t = DistToNextInt/fps;
            double minSpd = 1.46667 * 5.0; // unit: fps
            double maxSpd = 1.46667 * 35.0; // unit: fps

            speedometer.addColoredRange(0,40, Color.GRAY);

            av = DistToNextInt / retime;

            if (t<retime)
            {
                if (av<=minSpd) av = minSpd;
                if (av>maxSpd) {
                    text10.setText("Prepare to Stop");
                    text6.setText("Prepare to Stop");

                }
                else {
                    text10.setText("ECO speed range");
                    text6.setText("Eco Speed Range: "+round(av/1.46667)+" - " +round(maxSpd/1.46667));
                    if (!(round(av/1.46667) >= round(maxSpd/1.46667)) )
                    {
                        speedometer.addColoredRange(round(av/1.46667),round(maxSpd/1.46667),Color.GREEN);
                    }

                }
            }
            else
            {
                if (av > maxSpd) {
                    text10.setText("Prepare to Stop");
                    text6.setText("Prepare to Stop");
                }
                else{
                    text10.setText("ECO speed range");
                    text6.setText("Eco Speed Range: "+round(av/1.46667)+" - " +round(maxSpd/1.46667));
                    if (!(round(av/1.46667) >= round(maxSpd/1.46667)) )
                    {
                        speedometer.addColoredRange(round(av/1.46667),round(maxSpd/1.46667),Color.GREEN);
                    }

                }
            }


        }
        private void CalcAdvSpd_R(int retime)
        {
            // s = vt
            double a = 0.0; // required acceleration rate
            double av = 0.0;  //advisory speed.
            double fps = 1.46667 * VehSpeed;
            double t = DistToNextInt/fps;
            double minSpd = 1.46667 * 5.0; // unit: fps
            double maxSpd = 1.46667 * 35.0; // unit: fps

            speedometer.addColoredRange(0,40, Color.GRAY);

            av = DistToNextInt / retime;

            if (t>retime)
            {
                if (av>maxSpd) av = maxSpd;
                if (av<minSpd) av = minSpd;
                text10.setText("ECO speed range");
                text6.setText("Eco Speed Range: "+round(minSpd/1.46667)+" - " +round(av/1.46667));
                if (!(round(minSpd/1.46667) >= round(av/1.46667)) )
                {
                    speedometer.addColoredRange(round(minSpd/1.46667),round(av/1.46667),Color.GREEN);
                }

            }
            else
            {
                if (av > minSpd) {
                    text10.setText("ECO speed range");
                    text6.setText("Eco Speed Range: "+round(minSpd/1.46667)+" - " +round(av/1.46667));
                    if (!(round(minSpd/1.46667) >= round(av/1.46667)) )
                    {
                        speedometer.addColoredRange(round(minSpd/1.46667),round(av/1.46667),Color.GREEN);
                    }


                }
                else {
                    text10.setText("Prepare to Stop");
                    text6.setText("Prepare to Stop");
                }
            }
        }
        private void AVToMax(double av)
        {
            // To do animations
        }
    };

    private String GetStreetNamePhase(double x0,double y0)
    {
        int i=0;
        double x1,y1,x2,y2;
        double a,b,c;
        double d; // distance to the segment from x0,y0
        double x,y; // the point on the segment
        double minD = 1000.0;
        String NearestLine = null;
        String intname_surfix;
        String intname;
        String signalG;
        String maneuver;
        int N=0;
        String lat_,lon_;

        ArrayList< Map<String, Object>> nodelist = null;
        ArrayList< Map<String, Object>> conlist = null;
        Map<String, Object> aInt = null;

        Map<String, Object> intersectionList = new HashMap<String,Object>();


        for (Map.Entry<String, Object> entry : AllMAPs.entrySet() ) {
            String ky = entry.getKey();
            Object IntData = entry.getValue();

            intersectionList = (HashMap)IntData;
            ArrayList<Object> laneSet = new ArrayList<Object>();

            Object LaneSetVal = intersectionList.get("laneSet");
            intname_surfix = intersectionList.get("intersectionID").toString();

            lat_ = intersectionList.get("refPointlat").toString();
            lon_ = intersectionList.get("refPointLong").toString();

            nodelist = (ArrayList<Map<String, Object>>) LaneSetVal;

            for (Map<String, Object> lanelist: nodelist) {

                Object LaneIdValue = lanelist.get("id");
                String StreetName = lanelist.get("name").toString();
                intname = lat_+"_"+lon_+"_"+intname_surfix+"_"+LaneIdValue.toString()+"_"+StreetName;
                signalG = "-1";
                maneuver = "0";

                if (lanelist.containsKey("connectsTo")==true)
                {
                    conlist = (ArrayList<Map<String,Object>>) lanelist.get("connectsTo");
                    for (Map<String,Object> connectTo:conlist) {
                        //System.out.println("!!");
                        signalG = connectTo.get("signalGroup").toString();
                        break;
                    }
                }

                intname = intname+"_"+signalG;

                if (lanelist.containsKey("maneuvers")==true)
                {
                    maneuver = lanelist.get("maneuvers").toString();
                }

                intname = intname+"_"+maneuver;

                int lid = (int) LaneIdValue;
                Object LaneListVal = lanelist.get("nodeList");

                ArrayList latlons= (ArrayList<Object>) LaneListVal;

                N = latlons.size();
                //int it1=0;
                //int it2=2*N-1;
                i=0;
                x1=0;
                y1=0;
                x2=0;
                y2=0;
                for (Object o: latlons) {
                    Map<String, Object> coords = (Map<String, Object>) o;

                    double lon = (double) coords.get("lon");
                    double lat = (double) coords.get("lat");

                    if (i==0) {
                        x1 = lon;
                        y1 = lat;
                        i=i+1;
                    }else{
                        x2=lon;
                        y2=lat;
                        i=i+1;

                        a = (y2-y1)/(x2-x1);
                        b = -1.0;
                        c = y1 - a*x1;

                        d = Math.abs(a*x0+b*y0+c)/Math.sqrt(a*a+b*b);
                        x = (b*(b*x0-a*y0)-a*c)/(a*a+b*b);
                        y = (a*(-1.0*b*x0+a*y0)-b*c)/(a*a+b*b);

                        if (d<minD)
                        {
                            double minX,maxX;
                            double minY,maxY;

                            minX = Math.min(x1,x2);
                            maxX = Math.max(x1,x2);
                            minY = Math.min(y1,y2);
                            maxY = Math.max(y1,y2);
                            if (x>= minX && x<=maxX && y>=minY && y<=maxY && d<=MinCheckDist) {
                                //Log.d(TAG,"shortest distance from "+intname +".."+d);
                                // carVector = new Vector2f(x - x0, y - y0);
                                minD = d;
                                NearestLine = intname;
                                /*System.out.println("===========================================");
                                System.out.println("Car Pos: " + y0 + ", " + x0);
                                System.out.println("===========================================");*/
                            }
                        }

                        x1=x2;
                        y1=y2;
                    }
                }
            }
        }

        //Log.d(TAG, "NearestLine:" + NearestLine);

        return NearestLine;
    }

    private String GetStreetNamePhasePed(double x0,double y0)
    {
        int i=0;
        double x1,y1,x2,y2;
        double a,b,c;
        double d; // distance to the segment from x0,y0
        double x,y; // the point on the segment
        double minD = 1000.0;
        String NearestLine = null;
        String intname_surfix;
        String intname;
        String signalG;
        String maneuver;
        int N=0;
        String lat_,lon_;
        double MinCheckDistPed = 4.0E-5;

        ArrayList< Map<String, Object>> nodelist = null;
        ArrayList< Map<String, Object>> conlist = null;
        Map<String, Object> aInt = null;

        Map<String, Object> intersectionList = new HashMap<String,Object>();



        for (Map.Entry<String, Object> entry : AllMAPs.entrySet() ) {
            String ky = entry.getKey();
            Object IntData = entry.getValue();

            intersectionList = (HashMap)IntData;
            ArrayList<Object> laneSet = new ArrayList<Object>();

            Object LaneSetVal = intersectionList.get("laneSet");
            intname_surfix = intersectionList.get("intersectionID").toString();

            lat_ = intersectionList.get("refPointlat").toString();
            lon_ = intersectionList.get("refPointLong").toString();

            nodelist = (ArrayList<Map<String, Object>>) LaneSetVal;

            for (Map<String, Object> lanelist: nodelist) {

                Object LaneIdValue = lanelist.get("id");
                String StreetName = lanelist.get("name").toString();
                intname = lat_+"_"+lon_+"_"+intname_surfix+"_"+LaneIdValue.toString()+"_"+StreetName;
                signalG = "-1";
                maneuver = "0";

                if (lanelist.containsKey("connectsTo")==true)
                {
                    conlist = (ArrayList<Map<String,Object>>) lanelist.get("connectsTo");
                    for (Map<String,Object> connectTo:conlist) {
                        //System.out.println("!!");
                        signalG = connectTo.get("signalGroup").toString();
                        break;
                    }
                }

                intname = intname+"_"+signalG;

                if (lanelist.containsKey("maneuvers")==true)
                {
                    maneuver = lanelist.get("maneuvers").toString();
                }

                intname = intname+"_"+maneuver;

                int lid = (int) LaneIdValue;
                Object LaneListVal = lanelist.get("nodeList");

                ArrayList latlons= (ArrayList<Object>) LaneListVal;

                N = latlons.size();
                //int it1=0;
                //int it2=2*N-1;
                i=0;
                x1=0;
                y1=0;
                x2=0;
                y2=0;
                for (Object o: latlons) {
                    Map<String, Object> coords = (Map<String, Object>) o;

                    double lon = (double) coords.get("lon");
                    double lat = (double) coords.get("lat");

                    if (i==0) {
                        x1 = lon;
                        y1 = lat;
                        i=i+1;
                    }else{
                        x2=lon;
                        y2=lat;
                        i++;

                        /*System.out.println("===================================");
                        System.out.println("lon: " + x2 + ", lat: " + y2);
                        System.out.println("===================================");*/

                        a = (y2-y1)/(x2-x1);
                        b = -1.0;
                        c = y1 - a*x1;

                        d = Math.abs(a*x0+b*y0+c)/Math.sqrt(a*a+b*b);
                        x = (b*(b*x0-a*y0)-a*c)/(a*a+b*b);
                        y = (a*(-1.0*b*x0+a*y0)-b*c)/(a*a+b*b);

                        if (d<minD)
                        {
                            double minX,maxX;
                            double minY,maxY;

                            minX = Math.min(x1,x2);
                            maxX = Math.max(x1,x2);
                            minY = Math.min(y1,y2);
                            maxY = Math.max(y1,y2);
                            if (x>= minX && x<=maxX && y>=minY && y<=maxY
                            ) {
                                //Log.d(TAG,"shortest distance from "+intname +".."+d);
                                // pedVector.setX(x - x0);
                                // pedVector.setX(y - y0);

                                minD = d;
                                NearestLine = intname;
                            }
                        }

                        x1=x2;
                        y1=y2;
                    }
                }
            }
        }

        //Log.d(TAG, "NearestLine:" + NearestLine);

        return NearestLine;
    }
    public String setlayerType(int id) {
        String layerType = "null";
        switch (id) {
            case 0 : layerType = "none";
                break;
            case 1 : layerType = "mixedContent";
                break;
            case 2 : layerType = "generalMapData";
                break;
            case 3 : layerType = "intersectionData";
                break;
            case 4 : layerType = "curveData";
                break;
            case 5 : layerType = "roadwaySectionData";
                break;
            case 6 : layerType = "parkingAreaData";
                break;
            case 7 : layerType = "sharedLaneData";
                break;

        }
        return layerType;
    }


    public void decodeMapData(String MapString){
        Map<String, Object> intersectionList = new HashMap<String,Object>();
        ArrayList<Object> laneSet = new ArrayList<Object>();

        try {
            context.setIndentationShift(2);
            /* Decoding process */
            try {

                j2375.dsrc.asncode.dsrc.MessageFrame decodeMessageFrame = new j2375.dsrc.asncode.dsrc.MessageFrame();
                byte[] bytes = Hex.decodeHex(MapString.toCharArray());

                java.io.InputStream stream = new ByteArrayInputStream(bytes);
                // decode the value from an input stream
                decodeMessageFrame.uperDecode(context, stream);
                Value v =decodeMessageFrame.value.getDecodedValue();
                mapData = (MapData) v;
                System.out.println("message id :"+decodeMessageFrame.messageId.value);

                int msgIssue = mapData.msgIssueRevision.value;
                //System.out.println("msg revisison :"+msgIssue);
                int layerID = mapData.layerID.value;
                //System.out.println("layer Id :"+layerID);
                int layerTypeID = mapData.layerType.getValue();
                String layerType = setlayerType(layerTypeID);
                //System.out.println("layer type : "+layerType);

                intersectionList = new HashMap<String,Object>();
                laneSet = new ArrayList<Object>();

                for (Object o : mapData.intersections.valueList) {
                    IntersectionGeometry intersectionGeometry = (IntersectionGeometry) o;
                    intersectionList.put("revision",intersectionGeometry.revision.value);
                    intersectionList.put("intersectionID",intersectionGeometry.id.id.value);
                    String intid = String.valueOf(intersectionGeometry.id.id.value); // .toString();
                    intersectionList.put("refPointLong",intersectionGeometry.refPoint.a__long.value);
                    intersectionList.put("refPointlat",intersectionGeometry.refPoint.lat.value);
                    if (intersectionGeometry.refPoint.elevation != null) {
                        intersectionList.put("refPointElevation",intersectionGeometry.refPoint.elevation.value);
                    }
                    intersectionList.put("laneWidth",intersectionGeometry.laneWidth.value);

                    for(Object obj : intersectionGeometry.laneSet.valueList) {
                        GenericLane genericLane = (GenericLane) obj;
                        Map<String, Object> ls = new HashMap<String,Object>();
                        int laneidnum = genericLane.laneID.value;
                        ls.put("id",laneidnum);
                        ls.put("name",genericLane.name.getValue());

                        if (genericLane.egressApproach != null)
                            ls.put("egressApproach", true);
                        else
                            ls.put("egressApproach", false);

                        if (genericLane.ingressApproach != null)
                            ls.put("ingressApproach",true);
                        else
                            ls.put("ingressApproach",false);


                        LaneAttributes_Vehicle laneAttributes_vehicle = (LaneAttributes_Vehicle) genericLane.laneAttributes.laneType.getValue(); //get according to the type

                        //System.out.println("lane attribute : "+new String(laneAttributes_vehicle.getValue()));

                        ls.put("laneType",new String(laneAttributes_vehicle.getValue()));


                        String laneAttributes_directionalUse = new String(genericLane.laneAttributes.directionalUse.getValue());
                        ls.put("directionalUse",laneAttributes_directionalUse);

                        String laneAttributes_sharedWith = new String(genericLane.laneAttributes.sharedWith.getValue());
                        ls.put("sharedWith",laneAttributes_sharedWith);


                        if(genericLane.maneuvers != null) {
                            ls.put("maneuvers",new String(String.valueOf(genericLane.maneuvers.getValue()[0])));
                        }

                        NodeSetXY nodeSetXY = (NodeSetXY) genericLane.nodeList.getValue();

                        ArrayList<Object> nodelist = new ArrayList<Object>();
                        for (Object o1: nodeSetXY.valueList) {
                            NodeXY nodeXY = (NodeXY) o1;
                            Map<String, Object> nXY = new HashMap<String,Object>();
                            Node_LLmD_64b latlon = (Node_LLmD_64b) nodeXY.delta.getValue();

                            double lat = (double)((Integer) latlon.lat.value)/10000000.0;
                            double lon = (double)((Integer) latlon.lon.value)/10000000.0;
                            nXY.put("lat",lat);
                            nXY.put("lon",lon);
                            nodelist.add(nXY);
                        }
                        ls.put("nodeList",nodelist);

                        if(genericLane.connectsTo != null ) {
                            ArrayList<Object> connectsTolist = new ArrayList<Object>();
                            for (Object o2 : genericLane.connectsTo.valueList) {
                                Connection connection = (Connection) o2;
                                Map<String, Object> cData = new HashMap<String,Object>();

                                int connectingLaneID = connection.connectingLane.lane.value;
                                cData.put("lane",connectingLaneID);

                                String allowedManeuvers = new String(connection.connectingLane.maneuver.getValue());
                                cData.put("maneuver",allowedManeuvers);

                                int laneConnectionID  = connection.connectionID.value;
                                cData.put("connectionID",laneConnectionID);

                                int signalGroupId = connection.signalGroup.value;
                                cData.put("signalGroup",signalGroupId);
                                System.out.println("intid, lane, signalGroup: "+intid+","+laneidnum+","+signalGroupId);

                                int intersectionReferenceID = connection.remoteIntersection.id.value;
                                cData.put("remoteIntersectionId",intersectionReferenceID);

                                connectsTolist.add(cData);
                            }
                            ls.put("connectsTo",connectsTolist);
                        }

                        laneSet.add(ls);
                    }

                    intersectionList.put("laneSet",laneSet);

                    System.out.println("intersection : "+intersectionList.toString());

                    AllMAPs.put(intid,intersectionList);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Init failure");
            e.printStackTrace();
        }
    }

    class UpdateIntIDStreetPhase extends TimerTask{
        Polygon polygon = new Polygon();
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    double x0,y0;

                    ArrayList VehPos = new ArrayList();
                    ArrayList IntCoord = new ArrayList();
                    String StreetName;

                    if (CurrPoint == null) {
                        Location currentLoc = getLastKnownLocation();
                        CurrPoint = new GeoPoint(currentLoc.getLatitude(), currentLoc.getLongitude());
                        System.out.println("GPS IS NOT READY");
                    }

                    if (FakeLoc==true){
                        CurrPoint = new GeoPoint(FLat,FLon);
                    }

                    x0 = (Double) CurrPoint.getLongitude();
                    y0 = (Double) CurrPoint.getLatitude();

                    VehPos.add(y0);
                    VehPos.add(x0);

                    MyMarker.setPosition(CurrPoint);
                    mapController.setCenter(CurrPoint);

                    IntID_Lane_Street_PhaseNum = GetStreetNamePhase(x0,y0);


                    //System.out.println(IntID_Lane_Street_PhaseNum);

                }
            });
        }
    };

    class GetNextIntersection extends TimerTask {
        //public Polygon polygon = new Polygon();

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (IntID_Lane_Street_PhaseNum == null) {
                        NextIntersection = "Null";
                        //Log.d(TAG, " GetNextIntersection: No Intersection Name is available");

                        text7.setText(" ");
                        sigDirections.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);
                        text9.setVisibility(View.GONE);
                        text11.setVisibility(View.VISIBLE);
                        speedometer.clearColoredRanges();
                        text10.setText(" ");
                        return;
                    }

                    ArrayList VehPos = new ArrayList();
                    String StreetName;
                    String maneuver = "0";

                    c1 = Calendar.getInstance();
                    String formattedDate = df.format(c1.getTime());
                    text2.setText(formattedDate);

                    if (CurrPoint == null)
                    {
                        Location LastLoc = getLastKnownLocation();
                        CurrPoint = new GeoPoint(LastLoc.getLatitude(),LastLoc.getLongitude());
                        System.out.println(formattedDate+" : GPS IS NOT READY");
                    }

                    if (FakeLoc==true){
                        CurrPoint = new GeoPoint(FLat,FLon);
                    }

//                    VehBearing = 110.0;

                    VehPos.add((Double)CurrPoint.getLatitude());
                    VehPos.add((Double)CurrPoint.getLongitude());

                    //text.setText(CurrPoint.getLatitude()+","+CurrPoint.getLongitude());

                    MyMarker.setPosition(CurrPoint);
                    mapController.setCenter(CurrPoint);

                    StreetName = IntID_Lane_Street_PhaseNum.split("_")[4];
                    sigDirections.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    text9.setVisibility(View.VISIBLE);
                    text11.setVisibility(View.GONE);
                    /*
                    if (StreetName.equals("Null")) {
                        text7.setText(" ");
                        sigDirections.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);
                        text9.setVisibility(View.GONE);
                        text11.setVisibility(View.VISIBLE);
                        speedometer.clearColoredRanges();
                        text10.setText(" ");
                        Log.d(TAG,"hidden");

                    } else {
                        sigDirections.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        text9.setVisibility(View.VISIBLE);
                        text11.setVisibility(View.GONE);
                    }
                    */

                    /* 2022.10.12
                    // Double Check whether the next intersection is correct by using vehicle's bearing.
                    if (VehBearing>0) {
                        StreetName = CheckOppositeDir(StreetName);
                    }
                    */



                    //if (!StreetName.equals("Null")) {
                    //Log.d(TAG, "---------------: " + StreetName);
                    //Log.d(TAG, " GetNextIntersection: intersection name : "+StreetName);

                    maneuver = IntID_Lane_Street_PhaseNum.split("_")[6];

                    if (maneuver.equals("-128")){
                        // sigDirections.setImageResource(R.drawable.throughonly);
                        current_sign.setImageResource(R.drawable.throughonly);
                    }
                    if (maneuver.equals("-96")){
                        // sigDirections.setImageResource(R.drawable.right);
                        current_sign.setImageResource(R.drawable.right);
                    }
                    if (maneuver.equals("-64")){
                        // sigDirections.setImageResource(R.drawable.left);
                        current_sign.setImageResource(R.drawable.left);
                    }
                    if (maneuver.equals("-32")){
                        // sigDirections.setImageResource(R.drawable.threeway);
                        current_sign.setImageResource(R.drawable.threeway);
                    }
                    if (maneuver.equals("32")){
                        // sigDirections.setImageResource(R.drawable.rightonly);
                        current_sign.setImageResource(R.drawable.rightonly);
                    }
                    if (maneuver.equals("64")){
                        // sigDirections.setImageResource(R.drawable.leftonly);
                        current_sign.setImageResource(R.drawable.leftonly);
                    }
                    if (maneuver.equals("96")){
                        // sigDirections.setImageResource(R.drawable.leftright);
                        current_sign.setImageResource(R.drawable.leftright);
                    }

                    //sigDirections.setImageResource(R.drawable.throughonly);
                    //Display Movement Direction for the associated phase
                    // Codes below are for left-turn exclusive lane case, which needs to be revised
                    /*
                    if (StreetName.equalsIgnoreCase("3_South_First_WestMarket") || StreetName.equalsIgnoreCase("7_North_First_WestMarket") )
                    {
                        sigDirections.setImageResource(R.drawable.leftonly);
                    } else {
                        sigDirections.setImageResource(R.drawable.threeway);
                    }
                    */

                    DirectionPhNum = IntID_Lane_Street_PhaseNum.split("_")[5];
                    NextIntersection = StreetName.split("@")[1];
                    text7.setText("Toward "+NextIntersection );
                    //Log.d(TAG, "Next Intersection---------------: " + NextIntersection);

                    double Slat = (double)(Integer.valueOf(IntID_Lane_Street_PhaseNum.split("_")[0]))/10000000.0;
                    double Slon = (double)(Integer.valueOf(IntID_Lane_Street_PhaseNum.split("_")[1]))/10000000.0;

                    //Log.d(TAG, "Next Intersection Coord: " + String.valueOf(Slat)+","+String.valueOf(Slon));

                    IntersectionMarker.setPosition(new GeoPoint(Slat,Slon));
                    NextIntCoord = new Location("");

                    // My changes
                    // pos_of_next_intr.setX(Slat);
                    // pos_of_next_intr.setY(Slon);

                    NextIntCoord.setLatitude(Slat);
                    NextIntCoord.setLongitude(Slon);

                    text3.setText(StreetName+"|"+DirectionPhNum);

                    // Next Intersection

                    /* System.out.println("=============================================");
                    System.out.println("Next Intersection: " + NextIntersection);
                    System.out.println("Next Intersection: " + Slat + ", " + Slon);
                    System.out.println("============================================="); */

                    //}
                    //else{
                    //    NextIntersection = "Null";

                    //}

                }
            });
        }
    };

    class DistToNextIntersection extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    float[] distresults = new float[3];

                    if (AndroidLoc == null) {
                        Location currentLoc = getLastKnownLocation();
                        AndroidLoc = new Location("");
                        AndroidLoc.setLatitude(currentLoc.getLatitude());
                        AndroidLoc.setLongitude(currentLoc.getLongitude());
                    }

                    if (FakeLoc==true){
                        AndroidLoc.setLatitude(FLat);
                        AndroidLoc.setLongitude(FLon);
                    }

                    if (AndroidLoc != null && NextIntCoord !=null) {
                        AndroidLoc.distanceBetween(
                                AndroidLoc.getLatitude(),
                                AndroidLoc.getLongitude(),
                                NextIntCoord.getLatitude(),
                                NextIntCoord.getLongitude(),
                                distresults);
                        DistToNextInt = 3.28084 * (double) distresults[0];
                    }
                    //text8.setText(String.valueOf(DistToNextInt));
                    //Log.d(TAG, "Distance to the Next Intersection: "+DistToNextInt);
                    //text6.setText("Distance : "+round(DistToNextInt)+","+VehSpeed+","+VehBearing);

                }

            });
        }
    };

    public class WebData
    {
        public String RetriveData(String kwd)
        {
            String path = urlpath + kwd;
            try {
                url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(5000);
                conn.setConnectTimeout(5000);
                conn.setRequestMethod("GET");
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    // Reading response from input Stream
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    String output;
                    response = new StringBuffer();

                    while ((output = in.readLine()) != null) {
                        response.append(output);
                    }
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            responseText = response.toString();

            return responseText;
        }

    }


    private void GetIntersectionIDs(){

        // To be modified to get data from webservices in the next revision
        IntersectionIDs.put("First_WestMarket","101");
        IntersectionIDs.put("WestMarket_Warren","102");
        IntersectionIDs.put("Hudson_Warren","103");
        IntersectionIDs.put("Norfolk_Warren","104");
        IntersectionIDs.put("Lock_Warren","105");
        IntersectionIDs.put("Summit_Warren","106");
        IntersectionIDs.put("McCarter_Raymond","207");
        IntersectionIDs.put("Mulberry_Raymond","206");
        IntersectionIDs.put("Commerce_Raymond","205");
        IntersectionIDs.put("Broad_Raymond","204");
        IntersectionIDs.put("Halsey_Raymond","203");
        IntersectionIDs.put("Washington_Raymond","202");
        IntersectionIDs.put("University_Raymond","201");


        ClientIDs.put("101","90");
        ClientIDs.put("102","95");
        ClientIDs.put("103","93");
        ClientIDs.put("104","79");
        ClientIDs.put("106","70");
        ClientIDs.put("105","71");
        ClientIDs.put("201","115");
        ClientIDs.put("202","104");
        ClientIDs.put("203","119");
        ClientIDs.put("204","120");
        ClientIDs.put("205","111");
        ClientIDs.put("207","117");
        ClientIDs.put("206","116");

    }

    public void subscribeSPAT(String tp) {
        try {
            VZClient.connect(connOpts);
            System.out.println("Mqtt Connected to SPAT");
            VZClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {

                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    if (!flag) {
                        flag = true;
                        try {
                            j2375.dsrc.itsasbeta1.RoutedMsgOuterClass.RoutedMsg routedMsg = j2375.dsrc.itsasbeta1.RoutedMsgOuterClass.RoutedMsg.newBuilder().build().getParserForType().parseFrom(mqttMessage.getPayload());
                            String spatString = routedMsg.getMsgBytes().toStringUtf8();
                            //Log.d(TAG, " Print SPAT");
                            printSpat(spatString);

                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                        flag = false;

                    } else {
                        System.out.println("SKIPPED");
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });

            //VZClient.setCallback(this);
            //VZClient.subscribe("VZCV2X/+/+/RSU/NA/NA/"+clientId+"/UPER/SPAT");
            VZClient.subscribe(tp);


            System.out.println("Subscribed to SPAT ");
            System.out.println("Listening for SPAT");


        } catch (MqttException me2) {
            System.out.println(me2);
        }
    }

    public void subscribePSM(String tp) {
        try {
            VZClientPSM.connect(connOptsPSM);
            System.out.println("Mqtt Connected to PSM");

            VZClientPSM.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {

                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    if (!flag_psm) {
                        flag_psm = true;
                        try {
                            j2375.dsrc.itsasbeta1.RoutedMsgOuterClass.RoutedMsg routedMsg = j2375.dsrc.itsasbeta1.RoutedMsgOuterClass.RoutedMsg.newBuilder().build().getParserForType().parseFrom(mqttMessage.getPayload());
                            String psmString = routedMsg.getMsgBytes().toStringUtf8();
                            //Log.d(TAG, "Print PSM");
                            if (IntID_Lane_Street_PhaseNum != null)
                                PSMMsgs.add(psmString);
                            Log.d(TAG, String.valueOf(PSMMsgs.size()));

                            //printPSM(psmString);

                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                        flag_psm = false;

                    } else {
                        System.out.println("SKIPPED");
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });

            textPedMsg.setVisibility(View.GONE);
            // CrossingPed.setVisibility(View.GONE);
            NearbyBicycle.setVisibility(View.GONE);

            VZClientPSM.subscribe(tp);

            System.out.println("----------------------------------------------Subscribed to PSM");
            System.out.println("Listening for PSM");

        } catch (MqttException me) {
            //System.out.println(me);
        }
    }

//    // Called when the client lost the connection to the broker
//    public void connectionLost(Throwable arg0) {
//
//    }
//
//    // Called when a outgoing publish is complete
//    public void deliveryComplete(IMqttDeliveryToken arg0) {
//
//    }
//
//    public void messageArrived(String topic, MqttMessage message) {
//        if (!flag) {
//            flag = true;
//            try {
//                j2375.dsrc.itsasbeta1.RoutedMsgOuterClass.RoutedMsg routedMsg = j2375.dsrc.itsasbeta1.RoutedMsgOuterClass.RoutedMsg.newBuilder().build().getParserForType().parseFrom(message.getPayload());
//                String spatString = routedMsg.getMsgBytes().toStringUtf8();
//                Log.d(TAG, " Print SPAT");
//                printSpat(spatString);
//
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//
//            flag = false;
//
//        } else {
//            System.out.println("SKIPPED");
//        }
//    }

    // Function to calculate the Havarsine distance between two points on the

    public void printPSM(String psmString){ // Main working function
        double dis=0.0;
        float[] distresults = new float[3];

        try {
            context_psm.setIndentationShift(2);
            /* Decoding process */
            try {
                j2375.dsrc.asncode.dsrc.MessageFrame decodeMessageFrame = new j2375.dsrc.asncode.dsrc.MessageFrame();
                byte[] bytes = Hex.decodeHex(psmString.toCharArray());

                java.io.InputStream stream = new ByteArrayInputStream(bytes);
                // decode the value from an input stream
                decodeMessageFrame.uperDecode(context_psm, stream);
                Value v =decodeMessageFrame.value.getDecodedValue();
                psMsg = (PersonalSafetyMessage) v;

                double y0 = (double)(Integer.valueOf(psMsg.position.lat.value))/10000000.0;
                double x0 = (double)(Integer.valueOf(psMsg.position.a__long.value))/10000000.0;

//                double y0 = 40.74118487141314;
//                double x0 =  -74.17907991322781;

//                if (AndroidLoc == null) {
//                    Location currentLoc = getLastKnownLocation();
//                    AndroidLoc = new Location("");
//                    AndroidLoc.setLatitude(currentLoc.getLatitude());
//                    AndroidLoc.setLongitude(currentLoc.getLongitude());
//                }

                if (FakeLoc==true){
                    AndroidLoc.setLatitude(FLat);
                    AndroidLoc.setLongitude(FLon);
                }

                if (AndroidLoc != null && NextIntCoord !=null) {
                    AndroidLoc.distanceBetween(
                            AndroidLoc.getLatitude(),
                            AndroidLoc.getLongitude(),
                            y0,x0,
                            distresults);
                    dis = 3.28084 * (double) distresults[0];
                }


                if (dis>300.0)
                    return;

                String StreetNameVeh = IntID_Lane_Street_PhaseNum.split("_")[4].split(" ")[0];
                String IntIDLaneStreetPhaseNum = GetStreetNamePhasePed(x0,y0);


                Log.d(TAG, StreetNameVeh+","+String.valueOf(dis)+","+IntIDLaneStreetPhaseNum );

                if (IntIDLaneStreetPhaseNum == null)
                    return;

                String StreetNamePed = IntIDLaneStreetPhaseNum.split("_")[4].split(" ")[0];

                String id = String.valueOf(psMsg.id.getValue());
                int mSec = Integer.valueOf(psMsg.secMark.value);
                //int lat = Integer.valueOf(psMsg.position.lat.value);
                //int lon = Integer.valueOf(psMsg.position.a__long.value);
                boolean crossSta = Boolean.valueOf(psMsg.crossState.value);
                String type = String.valueOf(psMsg.basicType.getValue());

                // Main changes
                dir.setX(NextIntCoord.getLatitude() - AndroidLoc.getLatitude());
                dir.setY(NextIntCoord.getLongitude() - AndroidLoc.getLongitude());
                pedVector.setX(y0 - AndroidLoc.getLatitude());
                pedVector.setY(x0 - AndroidLoc.getLongitude());

                double dotProduct = Vector2f.dotProduct(dir, pedVector);
                double magnitude1 = dir.length();
                double magnitude2 = pedVector.length();

                double angleInRadians = 0;
                double angleInDegrees = 0;

                if (magnitude1 == 0.0 || magnitude2 == 0.0) {
                    // angleInRadians = 0;
                    // angleInDegrees = 0;
                    text1.setText("No Ped Info");
                }
                else {
                    angleInRadians = Math.acos(dotProduct / (magnitude1 * magnitude2));
                    angleInDegrees = Math.toDegrees(angleInRadians);
                    text1.setText("ped Angle: " + angleInDegrees);
                }

                System.out.println("==================================");
                System.out.println("Ped " + "x: " + pedVector.getX() + " y: " + pedVector.getY());
                System.out.println("Car " + "x: " + dir.getX() + " y: " + dir.getY());
                System.out.println("ped Angle: " + angleInDegrees);
                System.out.println("==================================");

                if (StreetNameVeh.equals(StreetNamePed) && angleInDegrees <= 90
                ) {
//                  // CrossingPed.setVisibility(View.VISIBLE);

                    // Code comes here?
                    if (type.equals("1"))
                    {
                        // CrossingPed.setVisibility(View.VISIBLE);
                        // sigDirections.setVisibility(View.GONE);
                        NearbyBicycle.setVisibility(View.VISIBLE);

                        // My Changes
                        NearbyBicycle.setImageDrawable(current_sign.getDrawable());
                        sigDirections.setImageResource(R.drawable.bicycle);
                    }
                    else if (type.equals("2"))
                    {
                        // sigDirections.setVisibility(View.GONE);
                        // CrossingPed.setVisibility(View.INVISIBLE);
                        NearbyBicycle.setVisibility(View.VISIBLE);

                        // My Changes
                        NearbyBicycle.setImageDrawable(current_sign.getDrawable());
                        sigDirections.setImageResource(R.drawable.pedcrossing);
                    }

                    textPedMsg.setVisibility(View.VISIBLE);
                    textPedMsg.setText("Ped/Bicycle Warning");
                    Log.d(TAG, id + "," + mSec + "," + crossSta + "," + type);
                }
                //PSMMsgs.add(psMsg);


            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Init failure");
            e.printStackTrace();
        }
    }

    public void printSpat(String spatString){
        try {
            context.setIndentationShift(2);
            /* Decoding process */
            try {
                j2375.dsrc.asncode.dsrc.MessageFrame decodeMessageFrame = new j2375.dsrc.asncode.dsrc.MessageFrame();
                byte[] bytes = Hex.decodeHex(spatString.toCharArray());

                java.io.InputStream stream = new ByteArrayInputStream(bytes);
                // decode the value from an input stream
                decodeMessageFrame.uperDecode(context, stream);
                Value v =decodeMessageFrame.value.getDecodedValue();
                spatMSG = (SPAT) v;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Init failure");
            e.printStackTrace();
        }
    }

    private void IntersectionCoords(){

        ArrayList<Double> Coord = new ArrayList<Double>();

        Coord.add(40.74202424898534);
        Coord.add(-74.18138481983567);
        IntCoords.put("Lock_Warren",Coord);

        Coord = new ArrayList<Double>();
        Coord.add(40.74106689044714);
        Coord.add(-74.17863040997378);
        IntCoords.put("Summit_Warren",Coord);

        Coord = new ArrayList<Double>();
        Coord.add(40.743036638196195);
        Coord.add(-74.18451160142544);
        IntCoords.put("Norfolk_Warren",Coord);

        Coord = new ArrayList<Double>();
        Coord.add(40.7436012);
        Coord.add(-74.1862551);
        IntCoords.put("Hudson_Warren",Coord);

        Coord = new ArrayList<Double>();
        Coord.add(40.74404213490806);
        Coord.add(-74.18761443827121);
        IntCoords.put("WestMarket_Warren",Coord);

        Coord = new ArrayList<Double>();
        Coord.add(40.7454785950921);
        Coord.add(-74.18975830385774);
        IntCoords.put("First_WestMarket",Coord);


    }

    private ArrayList ShowMap(){
        ArrayList StartLoc = new ArrayList();

        //polygon.setInfoWindow(new BasicInfoWindow(org.osmdroid.library.R.layout.bonuspack_bubble, map));

        mLocationManager = (LocationManager) getSystemService(android.content.Context.LOCATION_SERVICE);
        LocationListener locationListener = new MyLocationListener();

        List<String> providers = mLocationManager.getProviders(true);

        for (String provider : providers) {

            //Log.d(TAG, "Intersection Data:" + provider);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                int loc1 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
                int loc2 = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
            }
        }

        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0, locationListener);

        Location currentLoc = getLastKnownLocation();
        StartLoc.add(currentLoc.getLatitude());
        StartLoc.add(currentLoc.getLongitude());

        map = findViewById(R.id.mapView);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);


        //CurrPoint = new GeoPoint(40.74217395861606, -74.18192770067326);
        CurrPoint = new GeoPoint( (Double)StartLoc.get(0), (Double)StartLoc.get(1));

        mapController = map.getController();
        mapController.setCenter(CurrPoint);
        mapController.setZoom(17.0);

        MyMarker = new Marker(map);
        MyMarker.setPosition(CurrPoint);
        MyMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(MyMarker);

        IntersectionMarker = new Marker(map);
        IntersectionMarker.setPosition(CurrPoint);
        IntersectionMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(IntersectionMarker);

        return StartLoc;
    }

    private void GetBearingInfo() {
        String responseText = null;
        WebData StreetBearingData = new WebData();

        responseText = StreetBearingData.RetriveData("StreetBearing");

        //Street.split(",")[0].replace("[","").replace("]","").replace("\"","").replace("@","_")

        try {
            JSONArray jsonarray = new JSONArray(responseText);
            JSONObject jsonobject = jsonarray.getJSONObject(0);
            ObjBearingInfo = jsonobject.get("BearingInfo");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private String CheckOppositeDir(String Streetname)
    {
        String NextOppoDir = Streetname;
        String opposite = "Null";
        int maxB = 0;
        int minB = 0;


        try{
            opposite = ((JSONObject) ObjBearingInfo).getJSONObject(Streetname).getString("Opposite");
            String maxBearing = ((JSONObject) ObjBearingInfo).getJSONObject(Streetname).getString("MaxBearing");
            String minBearing = ((JSONObject) ObjBearingInfo).getJSONObject(Streetname).getString("MinBearing");
            maxB = Integer.parseInt(maxBearing);
            minB = Integer.parseInt(minBearing);

        }
        catch (JSONException e) {
            Log.d(TAG,"");
        }

        if (VehBearing < (double) minB || VehBearing > (double) maxB)
            NextOppoDir = opposite;
        //Log.d(TAG, "Directon was revised and the next intersection changed to: "+ NextIntersection);

        return NextOppoDir;
    }

    /*
    private static ConvertJsonToMap<String, Object> toMap(JSONObject jsonobj)  throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keys = jsonobj.keys();
        while(keys.hasNext()) {
            String key = keys.next();
            Object value = jsonobj.get(key);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }   return map;
    }

     */

    private String GetPolygons(String intname){

        String responseText = null;
        WebData PolygonData = new WebData();

        responseText = PolygonData.RetriveData(intname);
        //Log.d(TAG, "Street Polygon:" + responseText);

        List jsonList = new ArrayList();
        try
        {
            JSONArray jsonarray = new JSONArray(responseText);

            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                jsonList = Arrays.asList(jsonobject.getString("Polygon"));
                break;
            }

        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonList.toString();

    }

    private class MyLocationListener implements LocationListener {
        //Marker startMarker = new Marker(map);
        @Override
        public void onLocationChanged(Location loc) {

            double vehbearing = 0.0;

            CurrPoint = new GeoPoint(loc.getLatitude(),loc.getLongitude()); // Global location

            if (FakeLoc==true){
                CurrPoint = new GeoPoint(FLat,FLon);
            }

            text.setText(CurrPoint.getLatitude()+","+CurrPoint.getLongitude());

            AndroidLoc = new Location("");
            AndroidLoc.setLatitude(loc.getLatitude());
            AndroidLoc.setLongitude(loc.getLongitude());
            VehSpeed = round(2.23694 * 10.0*loc.getSpeed())/10.0; // MPH
            vehbearing = round(10.0*loc.getBearing())/10.0;

            if (vehbearing>0) VehBearing = vehbearing;

            // Toast.makeText(getBaseContext(), "Spd: " + VehSpeed + " B1: " + vehbearing+" B2: "+VehBearing , Toast.LENGTH_SHORT).show();
            speedometer.setSpeed(VehSpeed, 500, 0);
            /*
            // for testing
            AndroidLoc.setLatitude(CurrPoint.getLatitude());
            AndroidLoc.setLongitude(CurrPoint.getLongitude());
            VehSpeed = 20.0;
            VehBearing = 110.0;
            */
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }

    private Location getLastKnownLocation() {
        mLocationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                System.out.println("permission check");
            }
            Location l = mLocationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }
}
