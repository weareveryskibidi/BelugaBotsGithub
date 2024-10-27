package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo; //Important
@TeleOp
public class TeleOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("lf_drive");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("rf_drive");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("lb_drive");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("rb_drive");

        // Define a speed variable that can scale the power (you can adjust this value as needed)
        double speed = 1;  // Set the speed multiplier (0.5 for half speed, 1.0 for full speed)

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // If the stop is requested, exit the loop
        if (isStopRequested()) return;

        while (opModeIsActive()) {
            // Get joystick input for direction and rotation
            double y = -gamepad1.left_stick_y;  // Forward and backward
            double x = gamepad1.left_stick_x * 1.1;  // Strafing
            double rx = gamepad1.right_stick_x;  // Rotation

            // Calculate the denominator for normalizing motor power
            double deno = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

            // Calculate power for each motor with the speed variable applied
            double frontLeftPower = (y + x - rx) / deno * speed;
            double backLeftPower = (y - x + rx) / deno * speed;
            double frontRightPower = (y - x - rx) / deno * speed;
            double backRightPower = -(y + x - rx) / deno * speed;

            // Set motor powers
            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);
        }
        // Declare your servo
        private Servo slideServo;

        // Define positions for linear slide
        private static final double RETRACTED_POSITION = 0.0;  // Replace with your retracted position
        private static final double EXTENDED_POSITION = 1.0;   // Replace with your extended position

        @Override
        public void init() {
            // Initialize servo
            slideServo = hardwareMap.get(Servo.class, "slideServo");

            // Set initial position to retracted
            slideServo.setPosition(RETRACTED_POSITION);
        }
    }
}
