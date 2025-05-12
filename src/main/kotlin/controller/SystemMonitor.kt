package io.github.guinunesdev.thermowatch.controller

import oshi.SystemInfo
import oshi.hardware.CentralProcessor
import oshi.hardware.GraphicsCard
import oshi.hardware.HardwareAbstractionLayer

class SystemMonitor {
    private val systemInfo = SystemInfo()
    private val processor: CentralProcessor = systemInfo.hardware.processor
    private val sensors = systemInfo.hardware.sensors
    private var previousTicks = processor.systemCpuLoadTicks
    private val si: SystemInfo = SystemInfo()
    private val hardware: HardwareAbstractionLayer = si.hardware
    private val gpu: GraphicsCard? = hardware.graphicsCards.firstOrNull()

    fun getCpuUsage(): Double {
        val currentTicks = processor.systemCpuLoadTicks
        val load = processor.getSystemCpuLoadBetweenTicks(previousTicks)
        previousTicks = currentTicks
        return load * 100
    }

    fun getCpuTemperature(): Double {
        val temp = sensors.cpuTemperature
        return if (temp.isNaN() || temp <= 0.0) Double.NaN else temp
    }

    fun getGpuTemperature(): Double {
        return Double.NaN
    }
}
