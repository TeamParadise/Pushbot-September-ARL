// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;

public class DriveAuto extends CommandBase {
  private final Timer m_Timer = new Timer();
  /** Creates a new DriveAuto. */
  public DriveAuto() {
    addRequirements(RobotContainer.m_Drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Timer.restart();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_Timer.get() < 2) {
      RobotContainer.m_Drivetrain.driveArcade(0.10, 0.10);
    } else {
      RobotContainer.m_Drivetrain.driveArcade(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
