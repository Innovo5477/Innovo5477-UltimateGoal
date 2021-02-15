package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

//contains the drive methods. Uses robotmap.
public class RobotMoveUltimateGoal extends LinearOpMode {
    //one joystick for translation, one for rotation.

    public static void drive(double x, double y, double xTurn, HardwareMapUltimateGoal robot){
        //Translation (includes strafing)
        //get x and y values.
        y *= -1; //apparently up is negative, so we are going to reverse that.
       double theta = Math.atan2(y, x);
       double magnitude = Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);

       double pow1, pow2; //pow 1 is for FL and BR motor. pow 2 is for FR and BL motor.

        //strafe
        pow1 = Math.sin(theta + Math.PI / 4)*magnitude;
        pow2 = Math.sin(theta - Math.PI / 4)*magnitude;

        robot.FL_MotorPow = pow1;
        robot.BR_MotorPow = pow1;
        robot.FR_MotorPow = pow2;
        robot.BL_MotorPow = pow2;

        //rotation
        robot.BL_MotorPow  += xTurn/1.5; //adding to one side and subtracting from the other is too powerful, so we divide it xTurn by 1/5.
        robot.FL_MotorPow  += xTurn/1.5;  //1.5 is a kinda arbitrary number determined by preference
        robot.BR_MotorPow  -= xTurn/1.5;
        robot.FR_MotorPow  -= xTurn/1.5;

        //equalize
        double[] motorPowers = {robot.BL_MotorPow, robot.BR_MotorPow, robot.FL_MotorPow, robot.BR_MotorPow};
        //go throuhg the array of powers, and divide all of them by eachother. The highest power will be the one with a quotient greater than 1.
        for (int i = 0; i < motorPowers.length; i++){
            if ((motorPowers[i] / motorPowers[0] >= 1)  && (motorPowers[i] / motorPowers[1] >= 1)
                    && (motorPowers[i] / motorPowers[2] >= 1)  && (motorPowers[i] / motorPowers[3] >= 1)){
                for  (int j = 0; j < motorPowers.length; j++)
                    motorPowers[j] /= motorPowers[i]; //divide all powers by the largest power

                i = motorPowers.length;
            }
        }

        robot.FL_Motor.setPower(HardwareMapUltimateGoal.FL_MotorPow);
        robot.BR_Motor.setPower(HardwareMapUltimateGoal.BR_MotorPow);
        robot.FR_Motor.setPower(HardwareMapUltimateGoal.FR_MotorPow);
        robot.BL_Motor.setPower(HardwareMapUltimateGoal.BL_MotorPow);

    }

    static void alignWithGoal(double distance, double targetDistance){
        //distance will be the parameter that will constantly be receiving input from distance sensor
        //targetDistance will stay constant: TBD
       double distanceToBeTravelled = targetDistance - distance;
     //  while (distanceToBeTravelled > )
           //find unit of measurement
           //try and create a function to keep the robot travelling until the distance is reached


        //get distance from distance sensor to position the robot a "default" distance radially away from the goal
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }

}
