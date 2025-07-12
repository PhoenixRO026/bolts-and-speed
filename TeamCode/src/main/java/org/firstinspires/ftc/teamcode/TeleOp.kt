package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Servo
import kotlin.math.*

@TeleOp
class TeleOp : LinearOpMode(){
    override fun runOpMode() {
        val motorRight = hardwareMap.get(DcMotor::class.java, "motorR")
        val motorLeft = hardwareMap.get(DcMotor::class.java, "motorL")
        val servo = hardwareMap.get(Servo::class.java, "servo")

        val servoMin = 0.279 - 0.05
        val servoMax = 0.493 +  0.05

        var servoPos: Double
        var input: Double

        motorLeft.direction = DcMotorSimple.Direction.REVERSE

        waitForStart()

        while(opModeIsActive()) {
            val back = gamepad1.left_trigger.toDouble()
            val forward = gamepad1.right_trigger.toDouble()
            val power = forward - back
            motorRight.power = power
            motorLeft.power = power

            val direction = gamepad1.left_stick_x.toDouble()
            input = direction
            servoPos = input * 0.5 + 0.5
            servoPos = servoPos * (servoMax - servoMin) + servoMin
            servo.position = servoPos

            telemetry.addData("pos", servoPos)
            telemetry.addData("input", input)
            telemetry.update()
        }
    }
}