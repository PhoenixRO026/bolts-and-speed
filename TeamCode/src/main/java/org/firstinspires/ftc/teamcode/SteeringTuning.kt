package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.Servo

@TeleOp
class SteeringTuning : LinearOpMode() {
    override fun runOpMode() {
        val servo = hardwareMap.get(Servo::class.java, "servo")
        var servoPos = 0.5

        waitForStart()

        servo.position = servoPos

        var previousTime = System.currentTimeMillis() / 1000.0
        var currentTime: Double
        var deltaTime: Double

        while (opModeIsActive()) {
            currentTime = System.currentTimeMillis() / 1000.0
            deltaTime = currentTime - previousTime
            previousTime = currentTime

            if (gamepad1.dpad_left) {
                servoPos -= deltaTime * 0.1
            } else if (gamepad1.dpad_right) {
                servoPos += deltaTime * 0.1
            }

            servoPos = servoPos.coerceIn(0.0, 1.0)

            servo.position = servoPos

            telemetry.addData("pos", servoPos)
            telemetry.update()
        }
    }
}