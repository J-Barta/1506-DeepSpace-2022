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
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  private TalonSRX r1_drive, l1_drive;
  private VictorSPX r2_drive, r3_drive, l2_drive, l3_drive;

  private AHRS navX = new AHRS(SPI.Port.kMXP);

  private DifferentialDriveOdometry odo = new DifferentialDriveOdometry(new Rotation2d(), new Pose2d());
  

  public Drivetrain() {
    r1_drive = new TalonSRX(Constants.r1_drive);
    r2_drive = new VictorSPX(Constants.r2_drive);
    r3_drive = new VictorSPX(Constants.r3_drive);
    l1_drive = new TalonSRX(Constants.l1_drive);
    l2_drive = new VictorSPX(Constants.l2_drive);
    l3_drive = new VictorSPX(Constants.l3_drive);

    r2_drive.follow(r1_drive);
    r3_drive.follow(r1_drive);
    l2_drive.follow(l1_drive);
    l3_drive.follow(l1_drive);
  }

  public void arcadeDrive(double turnPower, double forwardPower) {
    //forwardPower = -forwardPower;
    double leftPwr = forwardPower + turnPower;
    double rightPwr = forwardPower - turnPower;
    r1_drive.set(ControlMode.PercentOutput, rightPwr);
    l1_drive.set(ControlMode.PercentOutput, leftPwr);
  }

  @Override
  public void periodic() {
    //TODO : update odometry
    //TODO: Run PID loops
  }

  /**
   * m/s
   * @return
   */
  public double getLeftVelo() {
    return -l1_drive.getSelectedSensorVelocity();
  }

  public double getLeftPos() {
    return -l1_drive.getSelectedSensorPosition();
  }

  public double getRightVelo() {
    return -r1_drive.getSelectedSensorVelocity();
  }

  public double getRightPos() {
    return -r1_drive.getSelectedSensorPosition();
  }

  public Rotation2d getNavX() {
    return Rotation2d.fromDegrees(navX.getAngle());
  }

  public void setAdditionGyroAngle(Rotation2d angle) {
    navX.setAngleAdjustment(angle.getDegrees());
  }

  public void resetNavX() {
    navX.reset();
  }


  @Override
  public void initSendable(SendableBuilder builder ) {
    super.initSendable(builder);
    builder.addDoubleProperty("l1_encoder_pos", () -> getLeftPos(), null);
    builder.addDoubleProperty("l1_encoder_velo", () -> getLeftVelo(), null);

    builder.addDoubleProperty("r1_encoder_pos", () -> getRightPos(), null);
    builder.addDoubleProperty("r1_encoder_velo", () -> getRightVelo(), null);
  }
}
