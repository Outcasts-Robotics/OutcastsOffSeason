package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


enum launcherState{
    IDLE ,
    SPINNING
}
public class Launcher {
    DcMotor flywheel1;
    DcMotor flywheel2;
    Servo gate;
    launcherState state;
    public Launcher(HardwareMap hardwareMap){
        this.gate = hardwareMap.get(Servo.class, "gateServo");
    }

    final double GATE_OPEN_POS = .3;
    final double GATE_CLOSED_POS = .1;

    public void closeGate(){
        this.gate.setPosition(GATE_CLOSED_POS);
    }

    public void openGate(){
        this.gate.setPosition(GATE_OPEN_POS);
    }

    public double getGatePos(){
        return this.gate.getPosition();
    }






}
