/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private TalonSRX r1_drive, l1_drive;
  private VictorSPX r2_drive, r3_drive, l2_drive, l3_drive;

  public DriveSubsystem() {
    r1_drive = new TalonSRX(Constants.r1_drive);
    r2_drive = new VictorSPX(Constants.r2_drive);
    r3_drive = new VictorSPX(Constants.r3_drive);
    l1_drive = new TalonSRX(Constants.l1_drive);
    l2_drive = new VictorSPX(Constants.l2_drive);
    l3_drive = new VictorSPX(Constants.l3_drive);
  }

  public void arcadeDrive(double turnPower, double forwardPower) {
    //forwardPower = -forwardPower;
    double leftPwr = forwardPower + turnPower;
    double rightPwr = forwardPower - turnPower;
    r1_drive.set(ControlMode.PercentOutput, rightPwr);
    r2_drive.set(ControlMode.PercentOutput, rightPwr);
    r3_drive.set(ControlMode.PercentOutput, rightPwr);
    l1_drive.set(ControlMode.PercentOutput, leftPwr);
    l2_drive.set(ControlMode.PercentOutput, leftPwr);
    l3_drive.set(ControlMode.PercentOutput, leftPwr);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void setDefaultCommand(Command defaultCommand) {
    super.setDefaultCommand(defaultCommand);
  }
}
