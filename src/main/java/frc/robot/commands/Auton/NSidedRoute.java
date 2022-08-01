package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import frc.robot.commands.Drivetrain.DriveDistance;
//import frc.robot.commands.Drivetrain.TurnToAngleProfiled;
import frc.robot.subsystems.Drivetrain;


import java.util.ArrayList;
import java.util.List;

public class NSidedRoute extends SequentialCommandGroup {

    public NSidedRoute(Drivetrain dt, int n) {
        double turnAmount = ((n-2) * 180.0 ) / n;

        List<Command> commands = new ArrayList<>();

        for(int i = 0; i<n; i++) {
//            commands.add(new DriveDistance(dt, 0.5));
//            commands.add(new TurnToAngleProfiled(dt, turnAmount));
        }

        Command[] array = new Command[commands.size()];
        for(int i = 0; i < commands.size(); i++) array[i] = commands.get(i);

        addCommands(array);
    }
}
