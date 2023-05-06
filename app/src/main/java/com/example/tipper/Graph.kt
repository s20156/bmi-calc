package com.example.tipper

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.PointsGraphSeries

class Graph : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graph_layout)
        val graphView = findViewById<View>(R.id.graphView) as GraphView
        val staticLabelsFormatter = StaticLabelsFormatter(graphView)
        val series = PointsGraphSeries(
            arrayOf(
                DataPoint(0.0, 25.0),
                DataPoint(1.0, 22.0),
                DataPoint(2.0, 24.0),
                DataPoint(3.0, 26.0),
                DataPoint(4.0, 21.0),
                DataPoint(5.0, 20.0),
                DataPoint(6.0, 23.0)
            )
        )
        graphView.addSeries(series)
        staticLabelsFormatter.setHorizontalLabels(arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun"))
        val gridLabelRenderer = graphView.gridLabelRenderer
        gridLabelRenderer.labelFormatter = staticLabelsFormatter
        series.color = R.color.colorPrimaryDark
        graphView.title = getString(R.string.graph_title)
        graphView.legendRenderer.isVisible = true
        graphView.legendRenderer.align = LegendRenderer.LegendAlign.BOTTOM
        gridLabelRenderer.horizontalAxisTitle = getString(R.string.month)
        gridLabelRenderer.verticalAxisTitle = getString(R.string.bmi)
    }
}