package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.Servo;

import org.apache.commons.math3.util.OpenIntToDoubleHashMap;

public class Release {
    private Servo release;

    private final double CLOSED_POS = 0.1;
    private final double OPENED_POS = 0.9;
    private boolean open = true;
    private boolean buttonPress = false;

    public void init(){
        release = hardwareMap.servo.get("release");
    }

    public void run(boolean buttonPress) {
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

}
