package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcontroller.external.samples.externalhardware.RobotHardware;

@TeleOp(name="Scrimmage TeleOp")


public class TeleOpScrimmageTest extends OpMode {

    DcMotor frontLeftDrive = null;
    DcMotor backLeftDrive = null;
    DcMotor frontRightDrive = null;
    DcMotor backRightDrive = null;
    IMU imu;

    Movement Move = null;

    @Override

    public void init(){

        Move = new Movement();

    }


    public void loop(){

        Move.move(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

    }

}
