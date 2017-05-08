import RPi.GPIO as GPIO

led = 4
GPIO.setmode(GPIO.BCM)
GPIO.setup(led, GPIO.OUT)

pwm = GPIO.PWM(led, 500)
pwm.start(100)

while True:
    duty_c = raw_input('0-100 : ')
    duty = int(duty_c)*10
    pwm.ChangeDutyCycle(duty)
