import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)
GPIO.setup(4, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)
import grovepi
sensor = 4
while True:
	print GPIO.input(4)
	time.sleep(0.5)
