package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robotcorelib.util.Subsystem;

public class Shooter extends Subsystem {
    private DcMotor shooterMotor;
    private Servo shooterServo;
    private boolean shooterOn;
    private boolean shooterToggle;

    @Override
    public void init() {
        shooterMotor = hardwareMap.dcMotor.get("shooter_one");
        shooterServo = hardwareMap.servo.get("shooterServo");
        shooterOn = false;
        shooterToggle = false;
    }

    public void run(boolean on) {
       if(on && !shooterToggle) {
           shooterToggle = true;
           shooterOn = !shooterOn;
       }
       if(!on && shooterToggle) {
           shooterToggle = false;
       }


        if(shooterOn) {
            shooterMotor.setPower(0.9);
        }
        else shooterMotor.setPower(0);

    }

}

