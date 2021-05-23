package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robotcorelib.opmode.TeleOpPipeline;
import org.firstinspires.ftc.teamcode.robotcorelib.robot.Robot;
@TeleOp(name = "main")
public class Main extends TeleOpPipeline {

    public void init() {
        super.init();


    }

    public void start() {
        super.start();

    }

    public void loop() {
        Robot.updateGlobalPosition();
        subsystems.intake.run(gamepad1.a, gamepad1.b);


    }

}
