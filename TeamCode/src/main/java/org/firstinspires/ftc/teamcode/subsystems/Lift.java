package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.robotcorelib.util.Subsystem;

public class Lift extends Subsystem {
    private DcMotor lift;
    private double stickPower;
    private boolean hold = false;
    private int holdPosition;
    private final double HOLD_POS_GAIN = 0.01;

    private final double CONVERSION_SPEED = 0.02;
    private final int LIMIT_RANGE = 400;
    private final int MAX_HEIGHT = 6000;
    private final int L_HIGH = MAX_HEIGHT - LIMIT_RANGE;


    public void init(){
        lift = hardwareMap.dcMotor.get("lift");
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void run(double stickPower) {
        int pos = lift.getCurrentPosition();
        double outputPower;

        // Sigmoid
        if(stickPower > 0) {
            hold = false;
            outputPower = stickPower / (1 + Math.exp(CONVERSION_SPEED * (pos - (MAX_HEIGHT - (LIMIT_RANGE / 2.0)))));
        } else if(stickPower < 0) {
            hold = false;
            outputPower = stickPower / (1 + Math.exp(CONVERSION_SPEED * (LIMIT_RANGE/2.0 - pos)));
        } else {
            if(!hold) {
                holdPosition = pos;
                hold = true;
            }

            int error = holdPosition - pos;
            outputPower = error * HOLD_POS_GAIN;

//            outputPower = 0;
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
    }

    public void test(double stickPower) {
        lift.setPower(stickPower);
        telemetry.addData("lift pos", lift.getCurrentPosition());
    }


}
