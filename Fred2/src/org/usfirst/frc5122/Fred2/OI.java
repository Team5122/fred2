// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5122.Fred2;

import org.usfirst.frc5122.Fred2.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick driver;
    public JoystickButton push;
    public JoystickButton grab;
    public JoystickButton lightOn;
    public Joystick aux;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
 

        aux = new Joystick(1);
        
        lightOn = new JoystickButton(aux, 4);
        lightOn.whileHeld(new Light());
        grab = new JoystickButton(aux, 2);
        grab.whileHeld(new ToteGrab());
        push = new JoystickButton(aux, 1);
        push.whileHeld(new TotePusher());
        driver = new Joystick(0);
        

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("TotePusher", new TotePusher());

        SmartDashboard.putData("LiftControl", new LiftControl());

        SmartDashboard.putData("HDrive", new HDrive());

        SmartDashboard.putData("ToteGrab", new ToteGrab());

        SmartDashboard.putData("Light", new Light());

        //SmartDashboard.putData("A_HDriveStrafe", new A_HDriveStrafe());

        //SmartDashboard.putData("A_HDriveForward", new A_HDriveForward());

        SmartDashboard.putData("A_DriveForPID", new A_DriveForPID(36));
        
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriver() {
        return driver;
    }

    public Joystick getAux() {
        return aux;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public double getLeftTrigger() {
    	return getAux().getRawAxis(2);
	}
	public double getRightTrigger() {
		return getAux().getRawAxis(3);
	}
}

