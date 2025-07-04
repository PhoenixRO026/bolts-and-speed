package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry

@TeleOp
class LiftTest : LinearOpMode() {
    override fun runOpMode() {
        telemetry = MultipleTelemetry(telemetry, FtcDashboard.getInstance().telemetry)

        val liftMotorRight = hardwareMap.get(DcMotor:: class.java, "motorR")
        val liftMotorLeft = hardwareMap.get(DcMotor:: class.java, "motorL")

        liftMotorRight.direction = DcMotorSimple.Direction.REVERSE


        waitForStart()

        while(opModeIsActive()) {
            val speed = gamepad1.right_trigger.toDouble() - gamepad1.left_trigger.toDouble()

            telemetry.addData("buton A ", gamepad1.a)

            liftMotorLeft.power = speed
            liftMotorRight.power = speed

            telemetry.addData("speed", speed)
            telemetry.update()
        }
    }
}