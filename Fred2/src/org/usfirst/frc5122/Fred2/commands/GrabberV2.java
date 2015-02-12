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

/**
 *
 */
public class  GrabberV2 extends Command {

    public GrabberV2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.toteGrabber);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Arm Init");
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getAux().getRawAxis(0) < -0.5){
    		Robot.toteGrabber.grab();
    		System.out.println("My arm should be out");
    	}else if(Robot.oi.getAux().getRawAxis(0) > 0.5){
    		Robot.toteGrabber.grab();
    		System.out.println("My arm should be out");
    	}else if(Robot.oi.getAux().getRawButton(2)){
    		Robot.toteGrabber.grab();
    	}else{
    		Robot.toteGrabber.ungrab();
    	}
    	if(Robot.oi.getAux().getRawAxis(5) < -0.5){
    		Robot.lift.push();
    		System.out.println("I should be going out");
    	}else if(Robot.oi.getAux().getRawButton(1)){
        	Robot.lift.push();
    	}else{
    		Robot.lift.unpush();
    	}
    	if(Robot.oi.getAux().getRawButton(3)){
    		Robot.lift.push();
    		Robot.toteGrabber.grab();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        System.out.println("Arm Finished? Nope");
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.toteGrabber.ungrab();
    	System.out.println("My arm should be in");
    	Robot.lift.unpush();
    	System.out.println("I should be going in");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
