// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5122.Fred2.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc5122.Fred2.Robot;
import org.usfirst.frc5122.Fred2.RobotMap;

/**
 *
 */
public class  A_ElevatorControl extends Command {
	private double speed;
	private double org;
	private double duration;

	
    public A_ElevatorControl(double duration, double speed) {
        //forward is in inches
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.speed = speed;
    	this.duration = duration;
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lift);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	org = timeSinceInitialized();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lift.moveLift(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return timeSinceInitialized() > duration + org;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.print(" end");
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}