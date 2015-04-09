package com.CompassDemo;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
import org.openintents.sensorsimulator.hardware.Sensor;
import org.openintents.sensorsimulator.hardware.SensorEvent;
import org.openintents.sensorsimulator.hardware.SensorEventListener;
import org.openintents.sensorsimulator.hardware.SensorManagerSimulator;

public class CompassDemo extends Activity implements SensorEventListener
{
	private SensorManagerSimulator sensorManager;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
        
        //mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE); 
        sensorManager = SensorManagerSimulator.getSystemService(this, SENSOR_SERVICE);
        sensorManager.connectSimulator();        
    }
    
    @Override
    protected void onResume() {
        super.onResume();     
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_FASTEST);
    }
    
    @Override
    protected void onStop() 
    {
        sensorManager.unregisterListener(this);
        super.onStop();
    }
    
    @Override 
    protected void onPause() 
    {
    	super.onPause();
    	sensorManager.unregisterListener(this);    	
    }

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) 
	{
        Compass myCompass = (Compass)findViewById(R.id.compass);
        myCompass.SetAngle(sensorEvent.values[0]);		
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {		
	}
	
}