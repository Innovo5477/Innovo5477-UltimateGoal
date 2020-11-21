package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Innovo TeleOp 2020", group="Teleop")
public class TeleOpUltimateGoal extends OpMode {

    @Override
    public void init() {
        //add deadzone ?

    }

    @Override
    public void loop() {
        RobotMoveUltimateGoal.drive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
    }
}
