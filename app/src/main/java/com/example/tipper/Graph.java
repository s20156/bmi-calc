package com.example.tipper;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class Graph extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_layout);
        GraphView graphView = (GraphView) findViewById(R.id.graphView);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graphView);
        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 25),
                new DataPoint(1, 22),
                new DataPoint(2, 24),
                new DataPoint(3, 26),
                new DataPoint(4, 21),
                new DataPoint(5, 20),
                new DataPoint(6, 23),
        });
        graphView.addSeries(series);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun"});

        GridLabelRenderer gridLabelRenderer = graphView.getGridLabelRenderer();
        gridLabelRenderer.setLabelFormatter(staticLabelsFormatter);
        series.setColor(R.color.colorPrimaryDark);
        graphView.setTitle(getString(R.string.graph_title));
        graphView.getLegendRenderer().setVisible(true);
        graphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);
        gridLabelRenderer.setHorizontalAxisTitle(getString(R.string.month));
        gridLabelRenderer.setVerticalAxisTitle(getString(R.string.bmi));
    }
}
