/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int r1_drive = 25; // Talon SRX
    public static final int r2_drive = 20; // Victor SPX
    public static final int r3_drive = 22; // Victor SPX

    public static final int l1_drive = 31; // Talon SRX
    public static final int l2_drive = 33; // Victor SPX
    public static final int l3_drive = 35; // Victor SPX

    public static final int winch = 9; // Victor SP
    
    public static final int elevator1 = 30; // Talon SRX
    public static final int elevator2 = 21; // Victor SPX
    public static final int elevator3 = 32; // Victor SPX

    public static final int rearLegs = 24; // Talon SRX
    public static final int frontLegs = 26; // Talon SRX

    public static final int wrist = 28; // Talon SRX

    public static final int ballGrabber = 34; // Victor SPX

    public static final int legWheels = 23; // Victor SPX

    // Solenoids
    public static final int ball1 = 0, ball2 = 1;
    public static final int hatch1 = 2, hatch2 = 3;
}
