package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robotcorelib.util.Subsystem;

public class Lift extends Subsystem {
    private DcMotor lift;
    private Servo release;
    private double stickPower;

    private final double CONVERSION_SPEED = 0.03;
    private final int LIMIT_RANGE = 200;
    private final int MAX_HEIGHT = 6000;
    private final int L_HIGH = MAX_HEIGHT - LIMIT_RANGE;

    private final double CLOSED_POS = 0.1;
    private final double OPENED_POS = 0.9;
    private boolean open = true;
    private boolean buttonPress = false;


    public void init(){
        release = hardwareMap.servo.get("release");
        lift = hardwareMap.dcMotor.get("lift");
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void run(double stickPower, boolean buttonPress) {
        int pos = lift.getCurrentPosition();
        double outputPower;

        // Sigmoid
        if(stickPower > 0) {
            outputPower = stickPower / (1 + Math.exp(CONVERSION_SPEED * (pos - (MAX_HEIGHT - (LIMIT_RANGE / 2.0)))));
        } else if(stickPower < 0) {
            outputPower = stickPower / (1 + Math.exp(CONVERSION_SPEED * (LIMIT_RANGE/2.0 - pos)));
        } else {
            outputPower = 0;
        }

        // Trapezoidal/Linear
//        if(stickPower > 0) {
//            if(pos < L_HIGH) {
//                outputPower = stickPower;
//            }    else {
//                outputPower = stickPower - (stickPower / LIMIT_RANGE) * (pos - L_HIGH);
//            }
//        } else if(stickPower < 0) {
//            if(pos < LIMIT_RANGE) {
//                outputPower = (stickPower / LIMIT_RANGE) * pos;
//            } else {
//                outputPower = stickPower;
//            }
//        } else {
//            outputPower = 0;
//        }
        
        lift.setPower(outputPower);
        if(buttonPress && !this.buttonPress) {
            this.buttonPress = true;
            open = !open;
        }
        if(!buttonPress && this.buttonPress) {
            this.buttonPress = false;
        }
        if(open) {
            release.setPosition(OPENED_POS);
        } else {
            release.setPosition(CLOSED_POS);
        }
    }

    public void test(double stickPower) {
        lift.setPower(stickPower);
        telemetry.addData("lift pos", lift.getCurrentPosition());
    }


}
