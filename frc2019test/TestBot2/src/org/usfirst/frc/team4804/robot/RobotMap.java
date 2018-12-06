package org.usfirst.frc.team4804.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//XBox controller IDs
	public static int xboxControlId = 0;
	public static int leftStickXId = 0;
	public static int rightStickXId = 4;
	public static int rightStickYId = 5;
	public static int leftStickYId = 1;
	public static final int DRIVER_CONTROLLER_ID = 0;
	public static final int OPERATOR_CONTROLLER_ID = 1;
	
	//CANbus device IDs
	public static int leftMotorControllerId = 11;
	public static int rightMotorControllerId = 6;
	public static int actuatorMotorId = 4;
	public static final int PCM_ID = 1; //Compressor/Pneumatics Control Module (used for DoubleSolenoids)
	public static int grabberMotorId = 5; //changed to 11 temporarily since there is only one seat motor
	
	//Analog device IDs
	public static int actuatorPotentiometerId = 0;
	public static int grabberEncoderId = 1;
	//Digital device IDs (DIO)
	public static int encoderChannelA = 0;
	public static int encoderChannelB = 1;
	
	//Solenoid port IDs
	public static int solenoid1_port1 = 0; //DoubleSolenoid
	public static int solenoid1_port2 = 1; //DoubleSolenoid
	public static int solenoid2_port1 = 2; //DoubleSolenoid
	public static int solenoid2_port2 = 3; //DoubleSolenoid
	
	public static double joystickTolerance = 0.15;
	// DriveTrain:
	public static double driveSpeedMultiplier = 0.8;
	public static double driveSpeedDpadMultiplier = 0.8;
	public static double autoApproachSpeedMultiplier = 0.50;
	public static double distanceToleranceMeters = 0.02;
	public static double distanceSetpointMeters = 0.5;
	public static double wheelDiameter = 200/1000; //200mm diameter converted to meters
	public static int kTimeoutMs = 10;
	public static int kPIDLoopIdx = 0;
	
	//Conveyer
	public static int conveyorLimitId = 7;
	public static double conveyorSpeed = .5;
	public static int conveyorId = 11;
	
	//Grabber
	public static int grabberMaxCurrent = 5;
	
	//test limit switch
	public static int testLimitSwitchId = 3;
}
