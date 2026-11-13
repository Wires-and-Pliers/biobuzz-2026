package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class MovementTestAuto extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init () {


    }

    @Override
    public void loop() {
        Movement mov = new Movement();
        //mov.move(0,.5,0);

    }


}
