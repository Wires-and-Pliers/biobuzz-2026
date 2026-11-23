package org.firstinspires.ftc.teamcode

import com.bylazar.field.PanelsField
import com.bylazar.telemetry.PanelsTelemetry
import org.firstinspires.ftc.robotcore.external.Telemetry

class panels {
    val panelsField = PanelsField.field
    val panelsTelemetry = PanelsTelemetry.ftcTelemetry

    fun addTelemetry(caption: String, value: Double){
        panelsTelemetry.addData(caption, value)
    }

    fun fieldUpdate(x: Double, y: Double){
        panelsField.moveCursor(x, y)
        panelsField.circle(2.0)
        panelsField.update()
    }
}