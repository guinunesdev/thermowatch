package io.github.guinunesdev.thermowatch

import io.github.guinunesdev.thermowatch.controller.SystemMonitor
import javafx.application.Application
import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.chart.LineChart
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage
import kotlin.concurrent.fixedRateTimer
import kotlin.math.roundToInt

fun main() {
    Application.launch(Main::class.java)
}

class Main : Application() {

    private val monitor = SystemMonitor()

    override fun start(primaryStage: Stage) {
        val font = Font.font("Courier New", 26.0)

        val titleLabel = Label("THERMOWATCH")
        titleLabel.font = Font.font("Courier New", 34.0)
        titleLabel.id = "titleLabel"

        val cpuUsageLabel = Label("Uso CPU: --%")
        val cpuTempLabel = Label("Temp CPU: --°C")
        val gpuTempLabel = Label("Temp GPU: --°C")

        cpuUsageLabel.font = font
        cpuTempLabel.font = font
        gpuTempLabel.font = font

        val cpuUsageChart = createLineChart("Uso da CPU")
        val cpuTempChart = createLineChart("Temperatura da CPU")
        val gpuTempChart = createLineChart("Temperatura da GPU")

        fixedRateTimer("SystemMonitoring", initialDelay = 0L, period = 1000L) {
            Platform.runLater {
                val usage = monitor.getCpuUsage()
                val cpuTemp = monitor.getCpuTemperature()
                val gpuTemp = monitor.getGpuTemperature()

                cpuUsageLabel.text = "Uso CPU: ${usage.roundToInt()}%"
                cpuTempLabel.text = "Temp CPU: ${cpuTemp.roundToInt()}°C"
                gpuTempLabel.text = if (gpuTemp.isNaN()) "Temp GPU: N/A" else "Temp GPU: ${gpuTemp.roundToInt()}°C"
                addDataToChart(cpuUsageChart, usage)
                addDataToChart(cpuTempChart, cpuTemp)
                addDataToChart(gpuTempChart, gpuTemp)
            }
        }

        val root = StackPane()
        val layout = VBox(20.0, titleLabel, cpuUsageLabel, cpuTempLabel, gpuTempLabel, cpuUsageChart, cpuTempChart, gpuTempChart)
        layout.alignment = Pos.CENTER
        root.children.add(layout)

        val scene = Scene(root, 600.0, 600.0)
        scene.stylesheets.add("styles.css")

        primaryStage.title = "ThermoWatch"
        primaryStage.scene = scene
        primaryStage.show()
    }

    private fun createLineChart(title: String): LineChart<Number, Number> {
        val xAxis = NumberAxis()
        val yAxis = NumberAxis()
        xAxis.label = "Tempo"
        yAxis.label = "Valor"

        val chart = LineChart(xAxis, yAxis)
        chart.title = title
        chart.animated = false

        return chart
    }

    private fun addDataToChart(chart: LineChart<Number, Number>, value: Double) {
        val series = XYChart.Series<Number, Number>()
        series.data.add(XYChart.Data<Number, Number>(System.currentTimeMillis(), value))

        if (chart.data.isNotEmpty()) {
            chart.data[0].data.add(series.data[0])
            if (chart.data[0].data.size > 30) {
                chart.data[0].data.removeAt(0)
            }
        } else {
            chart.data.add(series)
        }
    }
}

