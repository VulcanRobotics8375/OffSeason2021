package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotcorelib.util.Subsystem;

public class Intake extends Subsystem {
    private DcMotor intake;

    private double intakePower;

    public void init(){
        intake = hardwareMap.dcMotor.get("odo_right");
    }

    public void run(boolean buttonIntake, boolean buttonOuttake){
        if(buttonIntake){
            intake.setPower(1);
        }else if (buttonOuttake){
            intake.setPower(-1);
        }else {
            intake.setPower(0);
        }






    }

}
