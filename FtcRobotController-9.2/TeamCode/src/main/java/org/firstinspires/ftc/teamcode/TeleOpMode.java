package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class TeleOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("lf_drive");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("rf_drive");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("lb_drive");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("rb_drive");

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        //test these to see if bot goes forward when told to, if fails then swap from right to left, or vice versa

        waitForStart();

        if(isStopRequested()) return;

        while(opModeIsActive()) {
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1; //imp strafe counter (remember to change if needed)
            double rx = gamepad1.right_stick_x;

            double deno = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y+x+rx) / deno;
            double backLeftPower = (y-x+rx) / deno;
            double frontRightPower = (y-x-rx) / deno;
            double backRightPower = (y+x-rx) / deno;

//            double frontLeftPower = (y) / deno;
//            double backLeftPower = (x) / deno;
//            double frontRightPower = (rx) / deno;
//            double backRightPower = (0) / deno;



            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);
   
        }

    }
}