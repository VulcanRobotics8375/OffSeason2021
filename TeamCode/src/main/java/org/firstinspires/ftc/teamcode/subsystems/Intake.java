package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotcorelib.util.Subsystem;

public class Intake extends Subsystem {
    private DcMotor intake;
    private boolean buttonPress;

    public void init(){
        intake = hardwareMap.dcMotor.get("intake");
    }

    public void run(boolean buttonPress){
        if(buttonPress){
            intake.setPower(1);
        }else{
            intake.setPower(0);
        }



    }

}
