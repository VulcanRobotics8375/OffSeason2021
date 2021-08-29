package org.firstinspires.ftc.teamcode.robotcorelib.robot;

import org.firstinspires.ftc.teamcode.robotcorelib.drive.StandardTrackingWheelLocalizer;
import org.firstinspires.ftc.teamcode.robotcorelib.util.Subsystem;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

import java.util.ArrayList;


//Configuration class for all subsystems to interface with the system properly.
public class RobotConfig {
    public ArrayList<Subsystem> subsystems = new ArrayList<>();

    //localization
    public StandardTrackingWheelLocalizer localizer;

    //Subsystem objects go here
    public Drivetrain drivetrain;
    public Intake intake;
    public Lift lift;

    //initialization of subsystems goes here
    public void init() {
        localizer = new StandardTrackingWheelLocalizer(Robot.getHardwareMap());
        drivetrain = new Drivetrain();
        intake = new Intake();
        lift = new Lift();

    }

}
