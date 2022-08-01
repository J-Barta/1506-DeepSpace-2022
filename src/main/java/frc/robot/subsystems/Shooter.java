/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

  private VictorSP shooter_l, shooter_r;

  public Shooter() {
    //shooter_l = new VictorSP(Constants.shooter_l);
    // shooter_r = new VictorSP(Constants.shooter_r);
  }

  public void runShooter(double power) {
 //   shooter_l.set(-power);
 //   shooter_r.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
