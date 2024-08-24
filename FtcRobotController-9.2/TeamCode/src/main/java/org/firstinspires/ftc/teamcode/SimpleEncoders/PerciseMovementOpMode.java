package org.firstinspires.ftc.teamcode.SimpleEncoders;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class PerciseMovementOpMode extends LinearOpMode {

    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        frontLeftMotor = hardwareMap.dcMotor.get("lf_drive");
        frontRightMotor = hardwareMap.dcMotor.get("rf_drive");
        backLeftMotor = hardwareMap.dcMotor.get("lb_drive");
        backRightMotor = hardwareMap.dcMotor.get("rb_drive");

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {
            move(5 ,1000, 0.5);
            sleep(1000);
        }
    }

    public void move(int x, int ticks, double speed) {
        frontLeftMotor.setTargetPosition(frontLeftMotor.getCurrentPosition() + ticks);
        frontRightMotor.setTargetPosition(frontRightMotor.getCurrentPosition() + ticks);
        backLeftMotor.setTargetPosition(backLeftMotor.getCurrentPosition() + ticks);
        backRightMotor.setTargetPosition(backRightMotor.getCurrentPosition() + ticks);

        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(speed);
        backLeftMotor.setPower(speed);
        backRightMotor.setPower(speed);

        while (frontLeftMotor.isBusy() && frontRightMotor.isBusy() && backLeftMotor.isBusy() && backRightMotor.isBusy()) {
            // Wait for the motors to finish moving
            telemetry.addData("Motor Status", "Moving...");
            telemetry.addData("Front Left Motor Position", frontLeftMotor.getCurrentPosition());
            telemetry.addData("Front Right Motor Position", frontRightMotor.getCurrentPosition());
            telemetry.addData("Back Left Motor Position", backLeftMotor.getCurrentPosition());
            telemetry.addData("Back Right Motor Position", backRightMotor.getCurrentPosition());
            telemetry.update();
        }

        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }
}