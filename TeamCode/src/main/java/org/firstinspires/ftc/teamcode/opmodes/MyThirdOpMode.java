package org.firstinspires.ftc.teamcode.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

public class MyThirdOpMode extends LinearOpMode {
    private Blinker control_Hub;
    private Gyroscope imu;
    private DcMotor right_rear;
    private DcMotor right_front;
    private DcMotor left_front;
    private DcMotor left_rear;




    @Override
    public void runOpMode() {
        control_Hub = hardwareMap.get(Blinker.class, "Control Hub");
        imu = hardwareMap.get(Gyroscope.class, "imu");
        left_front = hardwareMap.get(DcMotor.class, "left_front");
        left_rear = hardwareMap.get(DcMotor.class, "left_rear");
        right_front = hardwareMap.get(DcMotor.class, "right_front");
        right_rear = hardwareMap.get(DcMotor.class, "right_rear");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();
            double G1rightStickY = - gamepad1.right_stick_y;
            double G1leftStickY = gamepad1.left_stick_y;

            boolean G1rightBumper = gamepad1.right_bumper;
            boolean G1leftBumper = gamepad1.left_bumper;
            /*
            double horizontal = 0.5 * gamepad1.left_stick_y;
            double vertical = -0.5 * gamepad1.left_stick_x;
            double turn = -0.5 * gamepad1.right_stick_x;

            left_rear.setPower(vertical+turn-horizontal);
            left_front.setPower(vertical+turn+horizontal);
            right_rear.setPower(vertical-turn+horizontal);
            right_front.setPower(vertical-turn-horizontal);
            */



            if(G1rightBumper){
                right_rear.setPower(0.5);
                right_front.setPower(-0.5);
                left_front.setPower(0.5);
                left_rear.setPower(-0.5);
            }
            else if (G1leftBumper){
                right_rear.setPower(-0.5);
                right_front.setPower(0.5);
                left_front.setPower(0.5);
                left_rear.setPower(-0.5);
            }
            else {
                right_rear.setPower(-G1rightStickY);
                right_front.setPower(-G1rightStickY);
                left_front.setPower(G1leftStickY);
                left_rear.setPower(G1leftStickY);
            }
        }
    }
}
