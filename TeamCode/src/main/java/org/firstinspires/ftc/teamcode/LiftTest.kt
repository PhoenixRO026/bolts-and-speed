package org.firstinspires.ftc.teamcode.teleop.tests

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple

@TeleOp
class LiftTest : LinearOpMode() {
    override fun runOpMode() {
        val liftMotorRight = hardwareMap.get(DcMotor:: class.java, "motorR")
        val liftMotorLeft = hardwareMap.get(DcMotor:: class.java, "motorL")

        liftMotorLeft.direction = DcMotorSimple.Direction.REVERSE


        waitForStart()

        while(opModeIsActive()) {
            val speed = gamepad1.right_stick_y.toDouble()

            liftMotorLeft.power = speed
            liftMotorRight.power = speed
        }
    }
}