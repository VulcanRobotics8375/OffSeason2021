package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robotcorelib.util.Subsystem;

public class Intake extends Subsystem {

    private DcMotor intake;
    private DcMotor transfer;
    private Servo deploy;
    // mat you are a legend;
    @Override
    public void init() {
        intake = hardwareMap.dcMotor.get("intake");
        transfer = hardwareMap.dcMotor.get("transfer");
        deploy = hardwareMap.servo.get("deploy");
        deploy.setPosition(1);
    }

    public void run(boolean rolling, boolean flat) {

        if(rolling) {
            deploy.setPosition(0.7);
            intake.setPower(1);
            transfer.setPower(1);
        } else if(flat){
            intake.setPower(-1);
            transfer.setPower(1);
            deploy.setPosition(1);
        }
        else {
            deploy.setPosition(0.7);
            intake.setPower(0);
            transfer.setPower(0);
        }

    }


}
