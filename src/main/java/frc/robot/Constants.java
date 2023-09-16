// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  // Constants for controllers connected to the Driver Station (i.e. Xbox controllers)
  public static class ControllerConstants {
    // Specify a deadzone for the controller to prevent joystick drift from moving the robot
    public static final double kDeadzone = 0.1;
  }
  // Constants for encoders
  public static class EncoderConstants {
    // Specify number of "ticks" (increases or decreases in encoder output) per revolution
    public static final int kNeoTicks = 42;
    // Specify formula that allows us to convert ticks to feet driven by the robot
    public static final double kTicksToFeet = 1.0 / kNeoTicks * 7 * Math.PI / 12.75 * 4; // Ticks * Wheel Diameter / Gearbox Ratio
  }
  // Constants for motor (controllers)
  public static class MotorConstants {
    // Specify all our motor ports
    public static final int kBackRightMotorPort = 1;
    public static final int kFrontRightMotorPort = 2;
    public static final int kBackLeftMotorPort = 3;
    public static final int kFrontLeftMotorPort = 4;
    // Specify our drivetrain motor "SmartCurrentLimit" and LoopRate (how long it takes motors to reach full power)
    public static final int kDrivetrainMotorCurrent = 55;
    public static final double kDrivetrainMotorLoopRate = 0.5;
  }
  // Constants for operators (Driver Station)
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  // Constants for PID control
  public static class PIDConstants {
    // Specify P, I, and D values for the Drivetrain.
    public static final double kPDrivetrain = 0.25;
    public static final double kIDrivetrain = 0;
    public static final double kDDrivetrain = 0;
    // Specify the tolerance (how close to final setpoint) before we consider it close enough. (Approximately) measured in feet.
    public static final double kDrivetrainTolerance = 0.08;
  }
}
