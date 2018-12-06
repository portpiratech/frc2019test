package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadUnload extends Command {
	
	private boolean isLoad;
	
    public LoadUnload(boolean isLoad) {
        // Use requires() here to declare subsystem dependencies
        this.isLoad = isLoad;    	
    	requires(Robot.conveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isLoad = true){
    		Robot.conveyor.convey(1.0, 1);//tweak later
    	}
    	else{
    		Robot.conveyor.convey(1.0, -1);//tweak later
    	}
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
