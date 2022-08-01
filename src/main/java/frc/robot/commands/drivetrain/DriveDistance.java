package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDistance extends CommandBase{
    private Drivetrain drivetrain;

    public DriveDistance(Drivetrain dt, double distance) {
        this.drivetrain = dt;
        addRequirements(dt);
    }

    public void initialize() {
        
    }
    
}
