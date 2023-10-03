// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Taxi extends SequentialCommandGroup {
  /** Creates a new Taxi. */
  public Taxi() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //Drive Back
      new DriveDistance(4),
      new WaitCommand(0.5),
      
      //Push Cube In
      new DriveDistance(-4.5),
      new WaitCommand(0.5),

      //Taxi Out
      new DriveDistance(12),
      new WaitCommand(0.1),
      RobotContainer.m_Drivetrain.setCoastMode()  
    );
  }
}
