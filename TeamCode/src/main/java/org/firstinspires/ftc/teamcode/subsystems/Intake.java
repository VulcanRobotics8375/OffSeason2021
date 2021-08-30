package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotcorelib.util.Subsystem;

@SuppressWarnings("FieldCanBeLocal")
public class Intake extends Subsystem {
    private DcMotor intake;

    private final double intakePower = 1.0;

    public void init(){
        intake = hardwareMap.dcMotor.get("odo_right");
    }

    public void run(boolean buttonIntake, boolean buttonOuttake){
        if(buttonIntake){
            intake.setPower(intakePower);
        }else if (buttonOuttake){
            intake.setPower(-intakePower);
        }else {
            intake.setPower(0);
        }


    }

}
