package com.example.medd.task13;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import com.android.volley.toolbox.JsonArrayRequest;


public class TripPlanner extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_planner);
        final Spinner mode_spinner = (Spinner) findViewById(R.id.spinner_mode);
        // Spinner click listener
        mode_spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> mode = new ArrayList<String>();
        mode.add("Mode");
        mode.add("Vehicle");
        mode.add("Train");
        mode.add("Subway");
         // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter_mode = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,mode);
        // Drop down layout style - list view with radio button
        dataAdapter_mode.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        mode_spinner.setAdapter(dataAdapter_mode);

        final Spinner route_spinner = (Spinner) findViewById(R.id.spinner_route_desc);
        // Spinner click listener
        mode_spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> route_desc_list = new ArrayList<String>();
        route_desc_list.add("Best route");
        route_desc_list.add("Fewer Transfers");
        route_desc_list.add("Less walking");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter_route = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,route_desc_list);
        // Drop down layout style - list view with radio button
        dataAdapter_route.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        route_spinner.setAdapter(dataAdapter_route);

        Button plan=(Button)findViewById(R.id.plan);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(TripPlanner.this,PlannedTrip.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trip_planner, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}
