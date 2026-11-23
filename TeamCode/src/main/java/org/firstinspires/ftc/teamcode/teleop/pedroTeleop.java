package org.firstinspires.ftc.teamcode.teleop;

import com.bylazar.field.FieldManager;
import com.bylazar.field.PanelsField;
import com.bylazar.telemetry.PanelsTelemetry;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedro.Constants;

@TeleOp
public class pedroTeleop extends OpMode {
    private Follower follower;
    Telemetry panelsTelemetry;
    private FieldManager panelsField;

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        panelsTelemetry = PanelsTelemetry.INSTANCE.getFtcTelemetry();
        panelsField = PanelsField.INSTANCE.getField();
    }
    @Override
    public void loop() {
        // Assign variables to the various inputs
        double forward = -gamepad1.left_stick_y;
        double lateral = -gamepad1.left_stick_x;
        double turn = -gamepad1.right_stick_x;

        // Pedro pathing driving with the follower
        follower.manual(forward, lateral, turn);
        follower.update();
        Pose robotPose = follower.pose(); // Gets pose of follower

        // Panels Telemetry: should also output to driver station
        panelsTelemetry.addData("Robot X", robotPose.x());
        panelsTelemetry.addData("Robot Y", robotPose.y());
        panelsTelemetry.addData("Robot Heading", Math.toDegrees(robotPose.heading()));
        panelsTelemetry.update();

        updateField(robotPose.x(), robotPose.y(), robotPose.heading());
    }

    public void updateField(double x, double y, double heading) {
        panelsField.moveCursor(x, y);
        panelsField.circle(1.5); // Draw a circle with radius 1.5
        panelsField.moveCursor(x + (Math.cos(Math.toRadians(heading)) * 3), y + (Math.sin(Math.toRadians(heading)) * 3));
        panelsField.line(x, y); // Draw line to indicate heading
        panelsField.update();
    }
}
