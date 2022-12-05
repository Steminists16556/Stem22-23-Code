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
  private Servo rightServo;
  private Servo leftServo;
  

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
    rightServo = hardwareMap.get(Servo.class,"rightServo");
    leftServo = hardwareMap.get(Servo.class,"leftServo");
    
    
    waitForStart();
    
    arm.getCurrentPosition();
    arm.getTargetPosition();
    
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // forward and backwards
        //frt
        targetPower2 = -gamepad1.left_stick_y;
        frontRight.setPower(targetPower2);
        targetPower2 = -gamepad1.left_stick_y;
        frontLeft.setPower(targetPower2);
        //bck
        targetPower2 = -gamepad1.left_stick_y;
        backRight.setPower(targetPower2);
        targetPower2 = gamepad1.left_stick_y;
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
        //if()
        //{
          
        //}
        //targetPower2 = -gamepad2.left_stick_y * 0.7;
        targetPower2 = -gamepad2.left_stick_y;
        arm.setPower(targetPower2 * 0.7);
        //arm.setPower(0.8);
        
        
        //servo
        if(gamepad2.a)
        {
          rightServo.setPosition(0.6);
          leftServo.setPosition(0.0);
        }
        else
        {
          rightServo.setPosition(0.0);
          leftServo.setPosition(0.4);
        }
        
      }
    }
  }
}
