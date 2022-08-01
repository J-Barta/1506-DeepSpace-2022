package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import frc.robot.commands.Drivetrain.DriveDistance;
// import frc.robot.commands.Drivetrain.TurnToAngleProfiled;
import frc.robot.subsystems.Drivetrain;

public class StraightReturn extends SequentialCommandGroup {

    public StraightReturn(Drivetrain dt) {
        addCommands(
                // new DriveDistance(dt, 1),
                // new TurnToAngleProfiled(dt, 180),
                // new DriveDistance(dt, 1)
        );
    }
}
