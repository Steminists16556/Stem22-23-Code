package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Morticia (Blocks to Java)")
public class Morticia extends LinearOpMode {

  //private Servo armServo;
  private DcMotor frontright;
  private DcMotor frontleft;
  private DcMotor backright;
  private DcMotor backleft;
  //private DcMotor armMotor;
  //private DcMotor carouselMotor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    float targetPower2;

    armServo = hardwareMap.get(Servo.class, "armServo");
    frontright = hardwareMap.get(DcMotor.class, "front right");
    frontleft = hardwareMap.get(DcMotor.class, "front left");
    backright = hardwareMap.get(DcMotor.class, "back right");
    backleft = hardwareMap.get(DcMotor.class, "back left");
    //armMotor = hardwareMap.get(DcMotor.class, "armMotor");
    //carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");

    waitForStart();
    armServo.setPosition(1);
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // forward and backwards
        targetPower2 = gamepad1.left_stick_y;
        frontright.setPower(targetPower2);
        targetPower2 = -gamepad1.left_stick_y;
        frontleft.setPower(targetPower2);
        targetPower2 = -gamepad1.left_stick_y;
        backright.setPower(targetPower2);
        targetPower2 = gamepad1.left_stick_y;
        backleft.setPower(targetPower2);
        telemetry.update();
        // left and right
        targetPower2 = gamepad1.right_stick_x;
        frontright.setPower(targetPower2);
        targetPower2 = gamepad1.right_stick_x;
        frontleft.setPower(targetPower2);
        targetPower2 = gamepad1.right_stick_x;
        backright.setPower(targetPower2);
        targetPower2 = gamepad1.right_stick_x;
        backleft.setPower(targetPower2);
        telemetry.update();
        // turning
        targetPower2 = -gamepad1.left_stick_x;
        frontright.setPower(targetPower2);
        targetPower2 = -gamepad1.left_stick_x;
        frontleft.setPower(targetPower2);
        targetPower2 = gamepad1.left_stick_x;
        backright.setPower(targetPower2);
        targetPower2 = gamepad1.left_stick_x;
        backleft.setPower(targetPower2);
        // Carousel Motor 
        //targetPower2 = gamepad2.right_stick_y;
        //carouselMotor.setPower(targetPower2);
        // arm motor
        /**targetPower2 = gamepad2.left_stick_y / 2;
        armMotor.setPower(targetPower2);
        // servor
        if (gamepad2.a) {
          armServo.setPosition(0);
        } else {
          armServo.setPosition(0.5);
        }    */
        // idk
      }
    }
  }
}
