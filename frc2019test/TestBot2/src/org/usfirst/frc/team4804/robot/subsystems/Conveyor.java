package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.SeatMotor;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Conveyor extends Subsystem {
	
	private SeatMotor conveyorMotor;
    private DigitalInput limitSwitch;
    
    public Conveyor(){
    	conveyorMotor = new SeatMotor(RobotMap.conveyorId);
    	
    	limitSwitch = new DigitalInput(RobotMap.conveyorLimitId);
    }

    public void initDefaultCommand() {
        
    }
    
    /**
     * 
     * @param timeSec
     * @param direction determines if its going forward if positive and backwards if negative. Expect it to be +/-1
     */
    public void convey(double timeSec, int direction){
    	
    	//If limitSwitch is not on robot
    	/*conveyorMotor.setSpeed(RobotMap.conveyorSpeed * direction);
    	Timer.delay(timeSec);
    	conveyorMotor.setSpeed(0);*/
    	
    	//If limitSwitch exists
    	conveyorMotor.setSpeed(RobotMap.conveyorSpeed);
    	SmartDashboard.putBoolean("LimitSwitch state", limitSwitch.get());
    	/*while(!limitSwitch.get()){
    		
    	}*/
    	conveyorMotor.setSpeed(0);
    }
}

