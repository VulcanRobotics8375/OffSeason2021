package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.robotcorelib.util.Subsystem;

public class Drivetrain extends Subsystem {

    private DcMotor fl, fr, bl, br;


    @Override
    public void init() {
        fl = hardwareMap.dcMotor.get("front_left");
        fr = hardwareMap.dcMotor.get("front_right");
        bl = hardwareMap.dcMotor.get("back_left");
        br = hardwareMap.dcMotor.get("back_right");

        setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setDrivetrainMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        fl.setDirection(DcMotorSimple.Direction.FORWARD);
        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.FORWARD);
        br.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setPowers(double fl, double fr, double bl, double br) {
        this.fl.setPower(fl);
        this.fr.setPower(fr);
        this.bl.setPower(bl);
        this.br.setPower(br);
    }


    public void mechanumDrive(double forward, double strafe, double turn) {
        double theta = Math.atan2(forward, strafe) - Math.PI / 4.0;
        // Godly Math Trick: sin(x+pi/4) = cos(x-pi/4)
        double hyp = Math.hypot(strafe, forward);
        double speed = (hyp/1.07)*(0.62*Math.pow(hyp, 2)+0.45);
        double flSpeed = speed * Math.sin(theta) + turn;
        double frSpeed = speed * Math.cos(theta) - turn;
        double blSpeed = speed * Math.cos(theta) + turn;
        double brSpeed = speed * Math.sin(theta) - turn;
        setPowers(flSpeed, frSpeed, blSpeed, brSpeed);
    }

    public void setPowers(double[] powers) {
        this.fl.setPower(powers[0]);
        this.fl.setPower(powers[1]);
        this.fl.setPower(powers[2]);
        this.fl.setPower(powers[3]);

    }

    public void setDrivetrainMode(DcMotor.RunMode runMode) {
        fl.setMode(runMode);
        fr.setMode(runMode);
        bl.setMode(runMode);
        br.setMode(runMode);
    }
}
