package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static Follower create(HardwareMap h) {
        // return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }

    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("front_left_drive");
        c.frontRightName.set("front_right_drive");
        c.backLeftName.set("back_left_drive");
        c.backRightName.set("back_right_drive");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(1.4726575716273993);
        c.yPodOffset.set(-3.164455684151237);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.12015278882032815);
                Controller secondaryTranslationalForward = Controller.proportional(0.04439324492746458);
                Controller primaryTranslationalLateral = Controller.proportional(0.18732575099750123);
                Controller secondaryTranslationalLateral = Controller.proportional(0.0692118595573236);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.017381464904289875));
                c.brake.set(Controller.proportionalFeedforward(0.014774245168646394));

                c.headingFeedback.set(Controller.proportional(3.347507400877543));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.03629897058275631, 0.0057894012618661846));

                c.linearBrakeCoefficients.set(Matrix.diag(0.07455395364765025, 0.03213365976704069));
                c.quadraticBrakeCoefficients.set(Matrix.diag(5.835058447013216E-4, 0.0016303672546612326));

                c.maxAchievableForwardVelocity.set(58.30553959601);
                c.maxAchievableStrafeVelocity.set(51.49840250376246);
                c.naturalForwardDeceleration.set(41.33956631316647);
                c.naturalStrafeDeceleration.set(57.62331177416041);
            }
    );

}