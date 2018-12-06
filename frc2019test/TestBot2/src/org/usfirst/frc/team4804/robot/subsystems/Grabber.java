package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.SeatMotor;
import org.usfirst.frc.team4804.robot.commands.Grab;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.AnalogTriggerOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.AnalogTriggerOutput.AnalogTriggerType;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Grabber extends Subsystem {
	//This is a very basic version of grabber's program
	
	private SeatMotor grabberMotor;
	private AnalogInput grabberAnalogInput;
	private AnalogTrigger grabberAnalogTrigger;
	private AnalogTriggerOutput grabberAnalogTriggerOutput;
	private int count;
	private boolean encState;
	private long lastTime;
	
	//Encoder is 174.9:1 gear ratio (174.9 counts per revolution)
	//(50ish reads per second)/(174.9 counts) = 0.285 speed necessary for full encoder resolution
	private double speedMult = 0.28;
	
	public Grabber(){
		grabberMotor = new SeatMotor(RobotMap.grabberMotorId);
		//grabberAnalogInput = new AnalogInput(RobotMap.grabberEncoderId);
		//grabberAnalogTrigger = new AnalogTrigger(grabberAnalogInput);
		grabberAnalogTrigger = new AnalogTrigger(RobotMap.grabberEncoderId);
		grabberAnalogTrigger.setLimitsVoltage(3.0, 3.75);
		//grabberAnalogTriggerOutput = new AnalogTriggerOutput(grabberAnalogTrigger, AnalogTriggerType.kRisingPulse);
		
		count = 0;
		encState = getEncoderState();
		
		grabberMotor.getMotor().enableCurrentLimit(true);
		grabberMotor.getMotor().configPeakCurrentLimit(0, 0);
		grabberMotor.getMotor().configContinuousCurrentLimit(RobotMap.grabberMaxCurrent, 500);
		
		lastTime = System.currentTimeMillis();
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
		//setDefaultCommand(new Grab());
    }
	
	public void close(double setSpeed) {
		//count();
		//smartDashboardOutput();
		
		
		
    	//double clampSpeed = -OI.operatorController.getY(Hand.kLeft);
    	
    	//Encoder is 174.9:1 gear ratio (174.9 counts per revolution)
    	//(50ish reads per second)/(174.9 counts) = 0.285 speed necessary for full encoder resolution
	
		grabberMotor.setSpeed(setSpeed);
    	
    	
    	
    	//Code to count the max number of pulses per second
		/*count++;
		SmartDashboard.putNumber("Seat motor encoder count test", count);
		
		if(System.currentTimeMillis() - lastTime > 1000) {
			SmartDashboard.putNumber("Highest count", count);
			count = 0;
			lastTime = System.currentTimeMillis();
		}*/
	}

	public void smartDashboardOutput() {
		SmartDashboard.putNumber("Seat motor encoder index", grabberAnalogTrigger.getIndex());
    	SmartDashboard.putBoolean("Seat motor encoder bool", getEncoderState());
    	SmartDashboard.putNumber("Seat motor encoder count test", count);
    
	}
	
	public double getMotorCurrent() {
		return grabberMotor.getMotor().getOutputCurrent();
	}
	
	public boolean getEncoderState(){
		 return grabberAnalogTrigger.getTriggerState();
	}
	
	public double getMotorOutputPercentSignum() {
		return Math.signum(grabberMotor.getMotor().getMotorOutputPercent());
	}
	
	public void count() {
		//SmartDashboard.putBoolean("Analog trigger output", grabberAnalogTriggerOutput.get());
		/*if(grabberAnalogTriggerOutput.get()) {
			if(getMotorOutputPercentSignum() == 1.0) {
				count++;
			} else if(getMotorOutputPercentSignum() == -1.0) {
				count--;
			}
		}*/
		System.out.println(count);
		//Catches the rising edges
		if(encState != getEncoderState() && getEncoderState()) { 
			/*if(Math.signum(grabberMotor.getMotor().getMotorOutputPercent()) == 1) {
				count++;
			} else if(Math.signum(grabberMotor.getMotor().getMotorOutputPercent()) == -1) {
				count--;
			}*/
			count++;
		}
		encState = getEncoderState();
		
		//if it is supposed to have 175 pulses(i'm not entirely sure) it worked at ~1/4 speed
	}

	public void resetCount() {
		count = 0;
	}

	public int getCount() {
		return count;
	}
	

}

