/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class HatchCommand extends CommandBase {
  private Intake ss;
  private boolean open;
  /**
   * Creates a new ShooterSubsystem.
   */
  public HatchCommand(Intake ss, boolean open) {
    this.ss = ss;
    this.open = open;
    addRequirements(ss);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.ss.hatch(this.open);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
