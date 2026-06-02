package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Launcher;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;

import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(group = "TeleOp", name="TestOpMode")
public class teleOp extends OpMode {
    MecanumDrive drive;
    Launcher launcher;
    TelemetryManager telemetry = PanelsTelemetry.INSTANCE.getTelemetry();
    @Override
    public void init() {
        drive = new MecanumDrive(hardwareMap);
        launcher = new Launcher(hardwareMap);
        ColorSensor colorSensor = hardwareMap.get(ColorSensor.class, "color");

    }

    @Override
    public void loop() {
        drive.update(gamepad1);

        if(gamepad1.cross){
            drive.stop();
        }

        telemetry.addData("pos", launcher.getGatePos());
        telemetry.update();




    }
}
