package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.MoveActuator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LinearActuator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX lineMotor;
	//12 inches long
	AnalogPotentiometer pot = new AnalogPotentiometer(RobotMap.actuatorPotentiometerId, 12);
	
	public LinearActuator() {
		lineMotor = new TalonSRX(RobotMap.actuatorMotorId);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveActuator());
    }
    
    public void moveMotor() {
    	double rightY = OI.driverController.getY(Hand.kRight);
    	
    	lineMotor.set(ControlMode.PercentOutput, rightY);
    	
    	SmartDashboard.putNumber("Potentiometer reading", pot.get());
    }
}

