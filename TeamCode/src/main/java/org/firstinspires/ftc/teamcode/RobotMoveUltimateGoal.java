package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

//contains the drive methods. Uses robotmap.
public class RobotMoveUltimateGoal extends LinearOpMode {
    //one joystick for translation, one for rotation.

    public static void drive(double x, double y, double xTurn){
        //Translation (includes strafing)
        //get x and y values.
       double theta = Math.atan2(y, x);
       double magnitude = Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);

       double pow1, pow2; //pow 1 is for FL and BR motor. pow 2 is for FR and BL motor.

        //rotation
        pow1 = Math.sin(theta + Math.PI / 4) + xTurn;
        pow2 = Math.sin(theta - Math.PI / 4) + xTurn;

        if(pow1 > 1){
            pow1 /= pow1;
            pow2 /= pow1;
        }

        else if(pow2 > 1){
            pow2 /= pow2;
            pow1 /= pow2;
        }

        RobotMapUltimateGoal.FL_MotorPow = pow1;
        RobotMapUltimateGoal.BR_MotorPow = pow1;
        RobotMapUltimateGoal.FR_MotorPow = pow2;
        RobotMapUltimateGoal.BL_MotorPow = pow2;

        RobotMapUltimateGoal.FL_Motor.setPower(RobotMapUltimateGoal.FL_MotorPow);
        RobotMapUltimateGoal.BR_Motor.setPower(RobotMapUltimateGoal.BR_MotorPow);
        RobotMapUltimateGoal.FR_Motor.setPower(RobotMapUltimateGoal.FR_MotorPow);
        RobotMapUltimateGoal.BL_Motor.setPower(RobotMapUltimateGoal.BL_MotorPow);

    }

    @Override
    public void runOpMode() throws InterruptedException {

    }

}
