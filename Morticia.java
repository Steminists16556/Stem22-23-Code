package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Morticia (Blocks to Java)")
public class Morticia extends LinearOpMode {

  //wheel
  private DcMotor frontRight;
  private DcMotor frontLeft;
  private DcMotor backRight;
  private DcMotor backLeft;
  //arm
  private DcMotor arm;
  private Servo servo;
  

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    float targetPower2;

    //wheel
    frontRight = hardwareMap.get(DcMotor.class, "frontRight");
    frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
    backRight = hardwareMap.get(DcMotor.class, "backRight");
    backLeft = hardwareMap.get(DcMotor.class, "backLeft");
    //arm motor
    arm = hardwareMap.get(DcMotor.class, "arm");
    arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    //servo
    servo = hardwareMap.get(Servo.class,"servo");
    
    
    waitForStart();
    
    arm.getCurrentPosition();
    arm.getTargetPosition();
    
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // forward and backwards
        //frt
        targetPower2 = gamepad1.left_stick_y;
        frontRight.setPower(targetPower2);
        targetPower2 = gamepad1.left_stick_y;
        frontLeft.setPower(targetPower2);
        //bck
        targetPower2 = gamepad1.left_stick_y;
        backRight.setPower(targetPower2);
        targetPower2 = -gamepad1.left_stick_y;
        backLeft.setPower(targetPower2);
        telemetry.update();
        
        
        // left and right
        //frt
        targetPower2 = gamepad1.left_stick_x;
        frontRight.setPower(targetPower2);
        targetPower2 = -gamepad1.left_stick_x;
        frontLeft.setPower(targetPower2);
        //bck
        targetPower2 = -gamepad1.left_stick_x;
        backRight.setPower(targetPower2);
        targetPower2 = -gamepad1.left_stick_x;
        backLeft.setPower(targetPower2);
        telemetry.update();
        
        // turning
        //frt
        targetPower2 = gamepad1.right_stick_x;
        frontRight.setPower(targetPower2);
        targetPower2 = -gamepad1.right_stick_x;
        frontLeft.setPower(targetPower2);
        //bck
        targetPower2 = gamepad1.right_stick_x;
        backRight.setPower(targetPower2);
        targetPower2 = gamepad1.right_stick_x;
        backLeft.setPower(targetPower2);
        
        //arm motor
        targetPower2 = gamepad2.right_stick_y /2;
        arm.setPower(targetPower2);
        
        //servo
        if(gamepad1.a)
        {
          servo.setPosition(0.5);
        }
        else
        {
          servo.setPosition(1);
        }
        
      }
    }
  }
}
