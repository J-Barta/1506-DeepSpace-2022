/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.util.AllRobotSubsystems;
import frc.robot.util.AutonomousLoader;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain drivetrain = new Drivetrain();
  private final Shooter shooter = new Shooter();
  private final Elevator elevatorSubsystem = new Elevator();
  private final Intake intakeSintakebsystem = new Intake();

  
  public Joystick driveController = new Joystick(0);

  private AutonomousLoader autoLoader = new AutonomousLoader(new AllRobotSubsystems(drivetrain, intakeSintakebsystem, shooter));

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    SmartDashboard.putData("drivetrain", drivetrain);

    // Configure the button bindings
    configureButtonBindings();
    // Set Default Commands
    setDefaultCommands();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      JoystickButton y = new JoystickButton(driveController, 4);
      JoystickButton x = new JoystickButton(driveController, 3);
      JoystickButton b = new JoystickButton(driveController, 2);
      JoystickButton a = new JoystickButton(driveController, 1);
      JoystickButton rb = new JoystickButton(driveController, 6);
      JoystickButton lb = new JoystickButton(driveController, 5);

      a.whenPressed(new HatchCommand(intakeSintakebsystem, true));
      a.whenReleased(new HatchCommand(intakeSintakebsystem, false));
      y.whenPressed(new BallCommand(intakeSintakebsystem, false));
      y.whenReleased(new BallCommand(intakeSintakebsystem, true));
      rb.whileHeld(new IntakeCommand(intakeSintakebsystem, -1));
      lb.whileHeld(new IntakeCommand(intakeSintakebsystem, 1));
  }

  private void setDefaultCommands() {
    drivetrain.setDefaultCommand(new DriveCommand(drivetrain, driveController));
    elevatorSubsystem.setDefaultCommand(new ElevatorCommand(elevatorSubsystem, driveController));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
