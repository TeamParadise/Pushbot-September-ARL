// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  // Initalize motor controllers
  public CANSparkMax backLeftMotor = new CANSparkMax(Constants.MotorConstants.kBackLeftMotorPort, MotorType.kBrushless);
  public CANSparkMax frontLeftMotor = new CANSparkMax(Constants.MotorConstants.kFrontLeftMotorPort, MotorType.kBrushless);
  public CANSparkMax backRightMotor = new CANSparkMax(Constants.MotorConstants.kBackRightMotorPort, MotorType.kBrushless);
  public CANSparkMax frontRightMotor = new CANSparkMax(Constants.MotorConstants.kFrontRightMotorPort, MotorType.kBrushless);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    configMotors();
  }

  private void configMotors() {
    // Restore motors to factory defaults
    backLeftMotor.restoreFactoryDefaults();
    frontLeftMotor.restoreFactoryDefaults();
    backRightMotor.restoreFactoryDefaults();
    frontRightMotor.restoreFactoryDefaults();

    backLeftMotor.setIdleMode(IdleMode.kCoast);
    frontLeftMotor.setIdleMode(IdleMode.kCoast);
    backRightMotor.setIdleMode(IdleMode.kCoast);
    frontRightMotor.setIdleMode(IdleMode.kCoast);

    // backLeftMotor.setOpenLoopRampRate(1);
    // frontLeftMotor.setOpenLoopRampRate(1);
    // backRightMotor.setOpenLoopRampRate(1);
    // frontRightMotor.setOpenLoopRampRate(1);

    backLeftMotor.setSmartCurrentLimit(55);
    frontLeftMotor.setSmartCurrentLimit(55);
    backRightMotor.setSmartCurrentLimit(55);
    frontRightMotor.setSmartCurrentLimit(55);

    // Set front motors to follow back back motors
    backLeftMotor.follow(frontLeftMotor, false);
    backRightMotor.follow(frontRightMotor, false);

    backLeftMotor.setInverted(true);
    frontLeftMotor.setInverted(true);
    backRightMotor.setInverted(false);
    frontRightMotor.setInverted(false);

    frontLeftMotor.getEncoder().setPosition(0);
    frontRightMotor.getEncoder().setPosition(0);
  }

  public void driveArcade(double xSpeed, double ySpeed) {

    double leftSpeed = ySpeed * (1) - xSpeed * (1);
    double rightSpeed = ySpeed * (1) + xSpeed * (1);
    SmartDashboard.putNumber("leftSpeed", leftSpeed);
    SmartDashboard.putNumber("rightSpeed", rightSpeed);
    SmartDashboard.putNumber("encoder real", frontLeftMotor.getEncoder().getPosition());
    frontLeftMotor.set(leftSpeed);
    frontRightMotor.set(rightSpeed);
  }


  public void DriveTank(double leftSpeed, double rightSpeed) {
    frontLeftMotor.set(MathUtil.clamp(leftSpeed, -0.1, 0.1));
    frontRightMotor.set(MathUtil.clamp(rightSpeed, -0.1, 0.1));
    SmartDashboard.putNumber("leftSpeed", MathUtil.clamp(leftSpeed, -0.1, 0.1));
    SmartDashboard.putNumber("rightSpeed", MathUtil.clamp(rightSpeed, -0.1, 0.1));
    SmartDashboard.putNumber("encoder", getDistance());
  }

  public double getDistance() {
    return frontLeftMotor.getEncoder().getPosition() * Constants.EncoderConstants.tickToFeet;
  }

  public CommandBase setBrakeMode() {
    return runOnce(
        () -> {
          backLeftMotor.setIdleMode(IdleMode.kBrake); 
          frontLeftMotor.setIdleMode(IdleMode.kBrake);
          backRightMotor.setIdleMode(IdleMode.kBrake);
          frontRightMotor.setIdleMode(IdleMode.kBrake);
        });
  }

  public CommandBase setCoastMode() {
    return runOnce(
        () -> {
          backLeftMotor.setIdleMode(IdleMode.kCoast);
          frontLeftMotor.setIdleMode(IdleMode.kCoast);
          backRightMotor.setIdleMode(IdleMode.kCoast);
          frontRightMotor.setIdleMode(IdleMode.kCoast);
        });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
