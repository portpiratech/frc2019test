package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */ 
public class LimitSwitch extends Subsystem {
	private DigitalInput limitSwitch;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void Grab(){
		limitSwitch = new DigitalInput(RobotMap.testLimitSwitchId);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean readSwitch(){
    	return limitSwitch.get();
    	
    }
}

