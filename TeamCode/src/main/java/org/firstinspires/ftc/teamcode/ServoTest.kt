package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Servo
import kotlin.math.*

@TeleOp
class ServoTest : LinearOpMode(){
    override fun runOpMode() {
        val servo = hardwareMap.get(Servo::class.java, "servo")

        waitForStart()

        while(opModeIsActive()) {
            val direction = gamepad1.left_stick_x.toDouble()
            servo.position = direction


//            telemetry.addData("pos", servoPos)
//            telemetry.addData("input", input)
//            telemetry.update()
        }
    }
}