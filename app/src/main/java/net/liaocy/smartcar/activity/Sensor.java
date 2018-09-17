package net.liaocy.smartcar.activity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import net.liaocy.smartcar.AppContext;
import net.liaocy.smartcar.R;
import net.liaocy.smartcar.biz.BizSensor;
import net.liaocy.smartcar.model.Acceleration;

import java.util.ArrayList;
import java.util.List;


public class Sensor extends Fragment {

    private final String TAG = "BizSensor";

    private BizSensor bizSensor;
    private LineChart chartAcceleration;
    private TextView txtAcceleration;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sensor, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        this.chartAcceleration = this.getView().findViewById(R.id.chartAcceleration);
        this.chartAcceleration.getDescription().setText("");
        this.chartAcceleration.setDragEnabled(true);
        this.chartAcceleration.setScaleEnabled(true);
        this.chartAcceleration.setPinchZoom(true);


        this.txtAcceleration = this.getView().findViewById(R.id.txtAcceleration);

        this.bizSensor = ((AppContext) getActivity().getApplication()).getInstance().getBizSensor();

        RefreshAcceleration();
    }

    private void RefreshAcceleration() {
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txtAcceleration.setText(bizSensor.getCurrentAcceleration().toString());

                            List<Acceleration> accs = bizSensor.getAccelerations();

                            List<Entry> rs = new ArrayList<>();

                            for (int i = 0; i < accs.size(); i++) {
                                rs.add(new Entry(i, accs.get(i).getR()));
                            }

                            LineDataSet dataSetR = new LineDataSet(rs, "R");
                            dataSetR.setColor(Color.BLUE);
                            dataSetR.setDrawCircles(false);

                            LineData lineDataR = new LineData(dataSetR);



                            chartAcceleration.setData(lineDataR);

                            chartAcceleration.notifyDataSetChanged();
                            chartAcceleration.invalidate();


                        }
                    });
                }
            }
        }.start();

    }
}
