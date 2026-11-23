package org.firstinspires.ftc.teamcode.teleop

import com.bylazar.field.PanelsField
import com.bylazar.telemetry.PanelsTelemetry
import com.pedropathing.follower.Follower
import com.pedropathing.follower.ManualDrive
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.pedro.Constants
import com.bylazar.gamepad.PanelsGamepad

@TeleOp(name = "Pedro Pathing Teleop with Panels Kotlin")
class PedroTeleop : OpMode() {
    val controller1 = PanelsGamepad.firstManager
    private var follower: Follower? = null
    private val panelsField = PanelsField.field
    val panelsTelemetry = PanelsTelemetry.ftcTelemetry

    override fun init() {
        follower = Constants.create(hardwareMap)
    }

    override fun loop() {
        // Init controller1 as gamepad1
        val controller1 = controller1.asCombinedFTCGamepad(gamepad1)

        val forward = -gamepad1.left_stick_y.toDouble()
        val lateral = -gamepad1.left_stick_x.toDouble()
        val turn = -gamepad1.right_stick_x.toDouble()

        // Drive
        ManualDrive.driveOrHold(follower, forward, lateral, turn)
        follower!!.update()
        val robotPose = follower!!.pose() // returns a Pose object: gets pose of robot

        // Telemetry
        panelsTelemetry.addData("Robot X", robotPose.x())
        panelsTelemetry.addData("Robot Y", robotPose.y())
        panelsTelemetry.addData("Robot Heading", Math.toDegrees(robotPose.heading()))
        panelsTelemetry.update()

        // Draw stuff on field
        panelsField.moveCursor(robotPose.x(), robotPose.y())
        panelsField.circle(2.0)
        panelsField.update()
    }
}