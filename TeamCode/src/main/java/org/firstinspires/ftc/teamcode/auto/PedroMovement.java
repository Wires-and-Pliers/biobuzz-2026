package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.pedropathing.follower.Follower;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import static com.pedropathing.api.Paths.*;
import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import com.pedropathing.ivy.Command;
import static com.pedropathing.ivy.groups.Groups.sequential;

@Autonomous
public class PedroMovement extends OpMode{
    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();
    // Poses
    private final Pose startPose = p.of(0, 0, 90);
    private final Pose park = p.of(10, 40, 90);

    private final Pose end = p.of(10, 40, 90);
    private final Pose point1Control1 = p.of(-10, 20, 0);

    private boolean configured = false;

    public Path curveTest() {
        return curve(startPose, point1Control1, end).linear(startPose, end);
    }

    private Path lineTest() {
        return line(startPose, park).linear(startPose, park);
    }
    private Command autoRoutineCurve() {
        return sequential(
                follow(follower, curveTest())
        );
    }
    private Command autoRoutineLine() {
        return sequential(
                follow(follower, lineTest())
        );
    }

    @Override
    public void init() {
        Scheduler.reset();

        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);
        follower.update();

    }

    @Override
    public void loop() {

        telemetry.addLine("a for curve test, b for line test");
        telemetry.update();
        if (!configured) {
            if (gamepad1.aWasPressed()) {
                schedule(autoRoutineCurve());
                configured = true;
            } else if (gamepad1.bWasPressed()) {
                schedule(autoRoutineLine());
                configured = true;
            }
        } else {
        follower.update();
        Scheduler.execute();
        }
    }
}
