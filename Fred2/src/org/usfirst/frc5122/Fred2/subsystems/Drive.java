// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5122.Fred2.subsystems;

import org.usfirst.frc5122.Fred2.RobotMap;
import org.usfirst.frc5122.Fred2.commands.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drive extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftFront = RobotMap.driveLeftFront;
    SpeedController leftRear = RobotMap.driveLeftRear;
    SpeedController rightFront = RobotMap.driveRightFront;
    SpeedController rightRear = RobotMap.driveRightRear;
    RobotDrive drivetrain = RobotMap.driveDrivetrain;
    SpeedController strafe = RobotMap.driveStrafe;
    Gyro gyro = RobotMap.drivegyro;
    Encoder leftEncoder = RobotMap.driveLeftEncoder;
    Encoder rightEncoder = RobotMap.driveRightEncoder;
    Encoder strafeEncoder = RobotMap.driveStrafeEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new HDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void HDrive(double moveValue, double turnValue, double strafeValue) {
    	drivetrain.arcadeDrive(-moveValue, -turnValue);
    	strafe.set(strafeValue);
    }
    public void stop(){
    	drivetrain.arcadeDrive(0, 0);
    	strafe.set(0);
    }
    private double deadzone(double input, double deadzone) {
    	if (Math.abs(input) < deadzone) {
    		return (0);
    	} else {
    		return (input);
    	}
    }
    private double deadzone(double input) {
    	return deadzone(input, .2);
    }
    
    //when the robot resets clear the gyro error
    public void resetGyro() {
    	System.out.println("Resetting Gyro");
    	gyro.reset();
    	prevTurn = 0;
    	targetHeading = 0;
    	error = 0;
    }
    
    private double prevTurn = 0;
    private double targetHeading = 0;
    private double error = 0;
    private final double Kp = 0.03; //.05
    //Hdrive with strafe gyro compensation
    public void hDrive(double drive, double turn, double slide){
    	drive = deadzone(drive);
    	turn = deadzone(turn);
    	slide = deadzone(slide);
    	// if any input is given, snap out of Move state
//    	if (drive != 0 || turn != 0 || slide != 0) {
//    		moveStateFB = STATE_IDLE;
//    	}
    	// Heading hold
    	double heading = gyro.getAngle();


    	if (turn == 0 ) {
    		if (prevTurn != 0) {
    			targetHeading = heading;
    			prevTurn = 0;
    		}
    		
    		
    		// Calculate PID
    		error = targetHeading - heading;
    		if (error > 180) {
    			error = heading - (360 - targetHeading);
    		}
    		

    		turn = error * Kp;
    		if (turn > 1.0) {
    			turn = 1.0;
    		} else if (turn < -1.0) {
    			
    			turn = -1.0;
    		}

    	// Turn rate was given, don't hold heading
    	} else {
    		prevTurn = turn;
    	}
    	// Drive
    	HDrive(drive, turn, slide);
    }
    
    
}

