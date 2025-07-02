package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import kotlin.math.*

@TeleOp
class TeleOp : LinearOpMode(){
    override fun runOpMode() {
        val motorRight = hardwareMap.get(DcMotor::class.java, "motorR")
        val motorLeft = hardwareMap.get(DcMotor::class.java, "motorL")
        val servo = hardwareMap.get(DcMotor::class.java, "servo")

        motorLeft.direction = DcMotorSimple.Direction.REVERSE

        waitForStart()

        while(opModeIsActive()) {
            val power = -gamepad1.left_stick_y.toDouble()
            motorRight.power = min(1.0, power)
            motorLeft.power = min(1.0, power)

            val direction = gamepad1.right_stick_x.toDouble()
            servo.power = direction
        }
    }
}