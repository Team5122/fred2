package org.usfirst.frc5122.Fred2.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Debug extends Command {
	String DebugCrap_m;
    public Debug(String DebugCrap) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	DebugCrap_m = DebugCrap;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println(DebugCrap_m);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
