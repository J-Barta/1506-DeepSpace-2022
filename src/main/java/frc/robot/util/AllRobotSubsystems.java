package frc.robot.util;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class AllRobotSubsystems {
    private Drivetrain drivetrain;
    private Intake intake;
    private Shooter shooter;

    public AllRobotSubsystems(Drivetrain drivetrain, Intake intake, Shooter shooter) {
        this.drivetrain = drivetrain;
        this.intake = intake;
        this.shooter = shooter;
    }
}
