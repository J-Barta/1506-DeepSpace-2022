/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterCommand extends CommandBase {
  private Shooter ss;
  private double power;
  /**
   * Creates a new ShooterSubsystem.
   */
  public ShooterCommand(Shooter ss, double power) {
    this.ss = ss;
    this.power = power;
    addRequirements(ss);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.ss.runShooter(power);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.ss.runShooter(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
