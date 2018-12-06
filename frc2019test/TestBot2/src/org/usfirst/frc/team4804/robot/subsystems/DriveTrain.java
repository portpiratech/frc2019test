package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.CimMotor;
import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private CimMotor leftMotor;
	private CimMotor rightMotor;
	private Encoder backLeftEnc;
	private ADXRS450_Gyro gyro;
	
	public DriveTrain() {
		leftMotor = new CimMotor(RobotMap.leftMotorControllerId);
		rightMotor = new CimMotor(RobotMap.rightMotorControllerId);
		backLeftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		gyro = new ADXRS450_Gyro();
		
		SmartDashboard.putNumber("% input", 0.5);
		
		//motor setup for velocity/encoder settings
		leftMotor.getMotor().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 1, RobotMap.kTimeoutMs);
    	leftMotor.getMotor().setSensorPhase(true);
    	leftMotor.getMotor().config_kF(RobotMap.kPIDLoopIdx, 0.2844, RobotMap.kTimeoutMs);
    	leftMotor.getMotor().config_kP(RobotMap.kPIDLoopIdx, 0.1705, RobotMap.kTimeoutMs);
    	leftMotor.getMotor().config_kI(RobotMap.kPIDLoopIdx, 0, RobotMap.kTimeoutMs);
    	leftMotor.getMotor().config_kD(RobotMap.kPIDLoopIdx, 0, RobotMap.kTimeoutMs);

	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }
    
    public void tankDrive() {  	
    	//variableType variableName = Class.controllerName.getY(hand);
    	
    	double leftY = OI.driverController.getY(Hand.kLeft);
    	double rightY = OI.driverController.getY(Hand.kRight);
    	
    	/*double targetVelocity =  4096 * 500.0 / 600;
    	leftMotor.setVelocity(targetVelocity);    using velocity to set motor speed is currenttly not working */
    	
    	//motorControlerName.set(controlMode, value);
    	double speedTest = SmartDashboard.getNumber("% input", 0.5);
    	leftMotor.setSpeed(leftY);
    	//rightMotor.setSpeed(rightY);
    	gyro.reset();
    	double gyroAngle = gyro.getAngle();
    	SmartDashboard.putNumber("Gyro Angle", gyroAngle);
    	
    
    	
    	
    	double targetVelocity_UnitsPer100ms = speedTest * 4096 * 500.0 / 600; //(4096 units/rev)*(500 rpm)/(600 100ms/min) = u/100ms
    	/* 1500 RPM in either direction */
    	//leftMotor.setVelocity(targetVelocity_UnitsPer100ms);
    	
    	double outputPercent = leftMotor.getMotor().getMotorOutputPercent();
    	double velocity = leftMotor.getMotor().getSensorCollection().getQuadratureVelocity(); //encoder units per 100ms.
    							//Being within ~600 u/100ms is fine
    	//velocity *= 600;
    	//double velocityLeft = velocity/60;
    	//velocityLeft *= Math.PI*0.33; //velocity in feet per second
    	SmartDashboard.putNumber("target velocity", targetVelocity_UnitsPer100ms);
    	SmartDashboard.putNumber("output %", outputPercent);
    	SmartDashboard.putNumber("velocity", velocity); //currently not working?
    }
 }

