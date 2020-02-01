/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  VictorSPX victorFL = new VictorSPX(0);
  VictorSPX victorRL = new VictorSPX(1);
  VictorSPX victorFR = new VictorSPX(2);
  VictorSPX victorRR = new VictorSPX(3);
  Joystick gamepad = new Joystick(0);
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    victorFL.follow(victorRL);
    victorFR.follow(victorRR);

    victorRL.setInverted(false);
    victorFL.setInverted(InvertType.FollowMaster);

    victorRR.setInverted(false);
    victorFR.setInverted(InvertType.FollowMaster);
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    double leftStick = gamepad.getRawAxis(1)*-1;
    double rightStick = gamepad.getRawAxis(5)*1;
    victorRL.set(ControlMode.PercentOutput, leftStick);
    victorRR.set(ControlMode.PercentOutput, rightStick);
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void disabledInit(){
  }
}
