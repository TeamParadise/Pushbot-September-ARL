// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveDistance extends PIDCommand {
  /** Creates a new DriveDistance. */
  public DriveDistance(double distance) {

    super(
        // The controller that the command will use
        new PIDController(0.28, 0, 0),
        // This should return the measurement
        RobotContainer.m_Drivetrain::getDistance,
        // This should return the setpoint (can also be a constant)
        distance,
        // This uses the output
        output -> RobotContainer.m_Drivetrain.DriveTank(output, output));
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Drivetrain);
    // Configure additional PID options by calling `getController` here.

    getController().setTolerance(0.08);
  }

  @Override
  public void initialize() {
    RobotContainer.m_Drivetrain.frontLeftMotor.getEncoder().setPosition(0);
    RobotContainer.m_Drivetrain.frontRightMotor.getEncoder().setPosition(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
