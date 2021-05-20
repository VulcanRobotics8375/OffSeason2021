package org.firstinspires.ftc.teamcode.robotcorelib.robot;

import org.firstinspires.ftc.teamcode.robotcorelib.drive.StandardTrackingWheelLocalizer;
import org.firstinspires.ftc.teamcode.robotcorelib.util.Subsystem;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

import java.util.ArrayList;

//Configuration class for all subsystems to interface with the system properly.
public class RobotConfig {
    public ArrayList<Subsystem> subsystems = new ArrayList<>();

    //localization
    public StandardTrackingWheelLocalizer localizer;

    //Subsystem objects go here
    public Drivetrain drivetrain;

    //initialization of subsystems goes here
    public void init() {
        localizer = new StandardTrackingWheelLocalizer(Robot.getHardwareMap());
        drivetrain = new Drivetrain();
    }

}
