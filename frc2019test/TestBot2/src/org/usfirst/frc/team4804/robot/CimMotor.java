package org.usfirst.frc.team4804.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public final class CimMotor {
	private TalonSRX motor;
	
	public CimMotor(int channel) {
		motor = new TalonSRX(channel);
	}

	public TalonSRX getMotor() {
		return motor;
	}

	public void setMotor(TalonSRX motor) {
		this.motor = motor;
	}
	
	public void setSpeed(double speed){
		motor.set(ControlMode.PercentOutput, speed);
	}
	
	public void setVelocity(double targetVelocity){
		motor.set(ControlMode.Velocity, targetVelocity);
	}
	

}
