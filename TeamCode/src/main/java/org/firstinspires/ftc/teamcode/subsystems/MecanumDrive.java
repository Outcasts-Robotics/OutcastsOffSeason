package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrive {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    public MecanumDrive(HardwareMap hardwareMap){
        this.frontLeft = hardwareMap.get(DcMotor.class , "frontLeft");
        this.frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        this.backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        this.backRight = hardwareMap.get(DcMotor.class, "backRight");

        this.frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



    }

    public void update(Gamepad gamepad){
        double strafe = gamepad.left_stick_x;
        double forward = -gamepad.left_stick_y;
        double rotate = gamepad.right_stick_x;

        this.frontLeft.setPower(forward + strafe + rotate);
        this.backLeft.setPower(forward - strafe + rotate);
        this.frontRight.setPower(forward - strafe - rotate);
        this.backRight.setPower(forward + strafe - rotate);
    }

    public void stop(){
        this.frontLeft.setPower(0);
        this.frontRight.setPower(0);
        this.backLeft.setPower(0);
        this.backRight.setPower(0);
    }
}
