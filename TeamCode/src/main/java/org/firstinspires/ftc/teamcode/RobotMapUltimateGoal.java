package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


/**
 * Created by Innovo 5477 2020-2021.
 */
public class RobotMapUltimateGoal extends LinearOpMode {
    //motors powers
    public static double FL_MotorPow, FR_MotorPow, BL_MotorPow, BR_MotorPow;

    //motor
    public static DcMotor FL_Motor, FR_Motor, BL_Motor, BR_Motor, vertMotor, horizMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        FL_Motor = hardwareMap.get(DcMotor.class, "FLm");
        FR_Motor = hardwareMap.get(DcMotor.class, "FRm");
        BL_Motor = hardwareMap.get(DcMotor.class, "BLm");
        BR_Motor = hardwareMap.get(DcMotor.class, "BRm");

        FR_Motor.setDirection(DcMotor.Direction.REVERSE);
        BR_Motor.setDirection(DcMotor.Direction.REVERSE);
    }




}
