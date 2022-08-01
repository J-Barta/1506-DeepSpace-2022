/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

  private VictorSPX elevator2, elevator3;
  private TalonSRX elevator1;

  public Elevator() {
    elevator1 = new TalonSRX(Constants.elevator1);
    elevator2 = new VictorSPX(Constants.elevator2);
    elevator3 = new VictorSPX(Constants.elevator3);
  }

  public void runElevator(double power) {
    elevator1.set(ControlMode.PercentOutput, power);
    elevator2.set(ControlMode.PercentOutput, power);
    elevator3.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
