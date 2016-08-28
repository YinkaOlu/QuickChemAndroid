package besupreme.com.quickchem;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private final String mURL = "https://quikchem.herokuapp.com/api/allElements";
    private static final String TAG = MainActivity.class.getSimpleName();
    public PeriodicTable mPeriodicTable;

    public ProgressBar intialLoadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intialLoadingBar = (ProgressBar) findViewById(R.id.initialProgressBar);


        if( isNetworkAvailable() ){
            OkHttpClient mClient = new OkHttpClient();
            Log.i(TAG, mURL);
            Request mRequest = new Request.Builder().url(mURL).build();
            Call call = mClient.newCall(mRequest);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e(TAG, "Failed to connect to network");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.i(TAG, "Response from Server");
                    String elementJSONResponse = response.body().string();
                    Log.i(TAG, elementJSONResponse);
                    mPeriodicTable = parseElements(elementJSONResponse);
                    mPeriodicTable.getAlkali_metal();
                    mPeriodicTable.getAlkaline_earth_metals();
                    mPeriodicTable.getLanthanide();
                    mPeriodicTable.getActinide();
                    mPeriodicTable.getTranstionMetal();
                    mPeriodicTable.getPost_​transition_metal();
                    mPeriodicTable.getMetalloid();
                    mPeriodicTable.getPolyatomic_nonmetal();
                    mPeriodicTable.getDiatomic_nonmetal();
                    mPeriodicTable.getNoble_gas();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            intialLoadingBar.setVisibility(View.INVISIBLE);
                        }
                    });

                }
            });
        }


    }

    private PeriodicTable parseElements(String mElementJSONResponse) {
        PeriodicTable periodTable;
        ArrayList<Element> elements = new ArrayList<>();
        Log.i(TAG, "Parsing element Response");

        try {
            JSONArray elementJSONArray = new JSONArray(mElementJSONResponse);
            for(int i = 0; i < elementJSONArray.length(); i++){
                JSONObject elementJSONObject = elementJSONArray.getJSONObject(i);
                Log.i(TAG, elementJSONObject.getString("symbol"));

                Element newElement = jsonToElement(elementJSONObject);
                elements.add(newElement);
            }
        } catch (JSONException mE) {mE.printStackTrace();}

        periodTable = new PeriodicTable(elements);
        return periodTable;
    }

    private Element jsonToElement(JSONObject mElementJSONObject) throws JSONException {
        Log.i(TAG, "Converting JSON of Element for: " + mElementJSONObject.getString("symbol"));
        Element element = new Element( mElementJSONObject.getString("symbol") );

        setElementAttribute(element, "summary", mElementJSONObject);
        setElementAttribute(element, "appearance", mElementJSONObject);
        setElementAttribute(element, "atomic_number", mElementJSONObject);
        setElementAttribute(element, "group", mElementJSONObject);
        setElementAttribute(element, "period", mElementJSONObject);
        setElementAttribute(element, "element_category", mElementJSONObject);
        setElementAttribute(element, "standard_atomic_weight", mElementJSONObject);
        setElementAttribute(element, "electron_configuration", mElementJSONObject);
        setElementAttribute(element, "per_shell", mElementJSONObject);
        setElementAttribute(element, "phase", mElementJSONObject);
        setElementAttribute(element, "melting_point", mElementJSONObject);
        setElementAttribute(element, "boiling_point", mElementJSONObject);
        setElementAttribute(element, "density", mElementJSONObject);
        setElementAttribute(element, "heat_of_fusion", mElementJSONObject);
        setElementAttribute(element, "heat_of_vaporization", mElementJSONObject);
        setElementAttribute(element, "molar_heat_capacity", mElementJSONObject);
        setElementAttribute(element, "ionization_energies", mElementJSONObject);
        setElementAttribute(element, "covalent_radius", mElementJSONObject);
        setElementAttribute(element, "crystal_structure", mElementJSONObject);
        setElementAttribute(element, "discovery", mElementJSONObject);

        return element;
    }

    private void setElementAttribute(Element mElement, String attribute, JSONObject mElementJSONObject) throws JSONException {
//        Log.i(TAG, "Setting element attribute: "+ attribute);
        if( mElementJSONObject.has(attribute) ){
//            Log.i(TAG, "JSON has: "+attribute);

            String attributeValue = mElementJSONObject.getString(attribute);
//            Log.i(TAG, "Value of JSON"+attributeValue);
            switch (attribute){
                case "summary":
                    mElement.setSummary(attributeValue);
                    break;
                case "appearance":
                    mElement.setAppearance(attributeValue);
                    break;
                case "atomic_number":
                    mElement.setAtomic_number(attributeValue);
                    break;
                case "group":
                    mElement.setGroup(attributeValue);
                    break;
                case "period":
                    mElement.setPeriod(attributeValue);
                    break;
                case "element_category":
                    mElement.setElement_category(attributeValue);
                    break;
                case "standard_atomic_weight":
                    mElement.setStandard_atomic_weight(attributeValue);
                    break;
                case "electron_configuration":
                    mElement.setElectron_configuration(attributeValue);
                    break;
                case "per_shell":
                    mElement.setPer_shell(attributeValue);
                    break;
                case "phase":
                    mElement.setPhase(attributeValue);
                    break;
                case "melting_point":
                    mElement.setMelting_point(attributeValue);
                    break;
                case "boiling-point":
                    mElement.setBoiling_point(attributeValue);
                    break;
                case "density":
                    mElement.setDensity(attributeValue);
                    break;
                case "heat_of_fusion":
                    mElement.setHeat_of_fusion(attributeValue);
                    break;
                case "heat_of_vaporization":
                    mElement.setHeat_of_vaporization(attributeValue);
                    break;
                case "molar_heat_capacity":
                    mElement.setMolar_heat_capacity(attributeValue);
                    break;
                case "ionization_energies":
                    mElement.setIonization_energies(attributeValue);
                    break;
                case "covalent_radius":
                    mElement.setCovalent_radius(attributeValue);
                    break;
                case "crystal_structure":
                    mElement.setCrystal_structure(attributeValue);
                    break;
                case "discovery":
                    mElement.setDiscovery(attributeValue);
                    break;
            }
        }
    }



    private boolean isNetworkAvailable() {
        Log.i(TAG, "Checking Network Available");
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isNetworkAvailable = false;

        if (networkInfo != null && networkInfo.isConnected()) {
            isNetworkAvailable = true;
            Log.i(TAG, "Network is Available");
        }
        return isNetworkAvailable;
    }
}
