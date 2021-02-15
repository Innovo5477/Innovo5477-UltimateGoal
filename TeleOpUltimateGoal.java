package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Innovo TeleOp 2021", group="Innovo")
public class TeleOpUltimateGoal extends OpMode {

    HardwareMapUltimateGoal robot = new HardwareMapUltimateGoal(); // use the class created to define a Pushbot's hardware
    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {

        RobotMoveUltimateGoal.drive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x, robot);

        telemetry.addData("Say", "Hello Driver");

        if(gamepad1.a){
            robot.intakeMotor1.setPower(1);
            robot.intakeMotor2.setPower(1);
        }

        //if(gamepad1.b)
           // RobotMoveUltimateGoal.alignWithGoal();

    }
}
