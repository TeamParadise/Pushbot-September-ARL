// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveArcade extends CommandBase {
  /** Creates a new DriveArcade. */
  public DriveArcade() {
    addRequirements(RobotContainer.m_Drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double ySpeed = MathUtil.applyDeadband(RobotContainer.m_driverController.getLeftY(), Constants.ControllerConstants.kDeadzone);
    double xSpeed = MathUtil.applyDeadband(RobotContainer.m_driverController.getRightX(), Constants.ControllerConstants.kDeadzone);

    RobotContainer.m_Drivetrain.driveArcade(xSpeed, ySpeed);
    SmartDashboard.putNumber("Left Joystick Y value", RobotContainer.m_driverController.getLeftY());
    SmartDashboard.putNumber("Right Joystick X value", RobotContainer.m_driverController.getRightX());
    SmartDashboard.putNumber("ySpeed", ySpeed);
    SmartDashboard.putNumber("xSpeed", xSpeed);
    SmartDashboard.putNumber("encoder", RobotContainer.m_Drivetrain.getDistance());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_Drivetrain.driveArcade(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
