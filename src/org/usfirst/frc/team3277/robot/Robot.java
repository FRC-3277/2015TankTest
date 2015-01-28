
package org.usfirst.frc.team3277.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.MotorSafetyHelper;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANJaguar.NeutralMode;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	final int LEFT_FRONT_JAG = 2;
   	final int RIGHT_FRONT_JAG = 3;
   	
   	Command autonomousCommand;
   	CANJaguar LeftFront;
   	CANJaguar RightFront;
   	RobotDrive FRCRobotDrive;
   	MotorSafety motorSafety;
    MotorSafetyHelper watchdog;
    SendableChooser autoChooser;
    
    CameraServer server;
   
   	Joystick joystick1;
   
    public void robotInit() 
    {
    	//watchdog = new MotorSafetyHelper(motorSafety);
    	
    	try {
			LeftFront = new CANJaguar(LEFT_FRONT_JAG);
			LeftFront.configNeutralMode(NeutralMode.Brake);
			LeftFront.enableControl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	try {
			RightFront = new CANJaguar(RIGHT_FRONT_JAG);
			RightFront.configNeutralMode(NeutralMode.Brake);
			RightFront.enableControl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
    	FRCRobotDrive = new RobotDrive(LeftFront,RightFront);
    	// Reverse motor direction to correct wheel direction.
    	//FRCRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);

    	//FRCRobotDrive.setSafetyEnabled(true);
    	//FRCRobotDrive.setExpiration(10000);
    	//SmartDashboard.putString("Hmmmm", "Drive Robot!  Expired" + FRCRobotDrive.getExpiration());
    	joystick1 = new Joystick(0);
    
    	  server = CameraServer.getInstance();
          server.setQuality(50);
          //the camera name (ex "cam0") can be found through the roborio web interface
          server.startAutomaticCapture("cam1");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
//    	autonomousCommand = (Command) autoChooser.getSelected();
//    	FRCRobotDrive.setSafetyEnabled(false);
//    	autonomousCommand.start();
    }
    
    public void teleopInit()
    {
    	// Cuts out autonomous code if still running.
    	//if (autonomousCommand != null) autonomousCommand.cancel();
    	//FRCRobotDrive.setSafetyEnabled(true);
    	//FRCRobotDrive.setExpiration(1000);
    	//FRCRobotDrive.arcadeDrive(Joystick1.getY(), Joystick1.getTwist());//((int)Joystick1.getX(), (int)Joystick1.getY());
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
    	//while(isOperatorControl() && isEnabled())
    	//{ 
	    	//watchdog.feed();
    		//getWatchdog().setEnabled(true);
	    	//FRCRobotDrive.tankDrive(0.5, 0.5);
    		//FRCRobotDrive.tankDrive(joystick1.getY(),joystick1.getTwist());
    	//	FRCRobotDrive.arcadeDrive(joystick1);
//	    	try {
				FRCRobotDrive.arcadeDrive(joystick1.getY(),-joystick1.getTwist());//(outputMagnitude, curve);//(0.7, 0.1);
//				//FRCRobotDrive. 
//			} catch (Exception e) {
//				//e.printStackTrace();
//				SmartDashboard.putString("Error", e.getMessage());
//			}
//	    	//FRCRobotDrive.arcadeDrive(Joystick1);
	    	//Timer.delay(0.01);
	    	//RightFront.set(-0.7);
	    	//LeftFront.set(0.7);
    	//}
 	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
