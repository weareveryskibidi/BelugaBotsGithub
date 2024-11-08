ckage org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class DCSYNC extends LinearOpMode {
    Dcmotor one =  hardwareMap.get(DcMotor.class, "First Motor");
    Dcmotor two = hardwareMap.get(DcMotor.class, "Second Motor");

    one.setDirection(DcMotor.Direction.REVERSE);
    two.setDirection(DcMotor.Direction.FORWARD);

}