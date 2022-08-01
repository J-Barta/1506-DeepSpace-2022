package frc.robot.util;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Auton.NSidedRoute;
import frc.robot.commands.Auton.Straight;
import frc.robot.commands.Auton.StraightReturn;
import frc.robot.util.AllRobotSubsystems;

import java.util.HashMap;
import java.util.Map;

public class AutonomousLoader {
    Map<Route, Command> autoRoutes = new HashMap<>();

    private SendableChooser chooser;

    public AutonomousLoader(AllRobotSubsystems subsystems) {
//        autoRoutes.put(Route.Straight, new Straight(subsystems.drivetrain));
//        autoRoutes.put(Route.StraightReturn, new StraightReturn(subsystems.drivetrain));
//        autoRoutes.put(Route.Square, new NSidedRoute(subsystems.drivetrain, 4));
//        autoRoutes.put(Route.Pentagon, new NSidedRoute(subsystems.drivetrain, 5));
//        autoRoutes.put(Route.Octagon, new NSidedRoute(subsystems.drivetrain, 8));

        this.chooser = composeSendableChooser();
    }

    private SendableChooser composeSendableChooser() {
        SendableChooser chooser = new SendableChooser();
        for(Map.Entry<Route, Command> e : autoRoutes.entrySet()) {
            chooser.addOption(e.getKey().name(), e.getKey());
        }

        return chooser;
    }

    public SendableChooser getSendableChooser() {
        return chooser;
    }

    public Command getCurrentSelection() {
        return autoRoutes.get(chooser.getSelected());
    }

    public enum Route {
        Straight,
        StraightReturn,
        Square,
        Pentagon,
        Octagon
    }
}
