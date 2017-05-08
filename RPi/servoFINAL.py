import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
GPIO.setup(2, GPIO.OUT)
pwm = GPIO.PWM(2, 100)
pwm.start(5)
angle = 0
while True:
    angle = raw_input('Angle : ')
    duty = float(angle) / 10.0 + 2.5
    pwm.ChangeDutyCycle(duty)
