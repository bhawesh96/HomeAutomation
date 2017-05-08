import RPi.GPIO as GPIO
import time
inp = 3
GPIO.setmode(GPIO.BCM)
GPIO.setup(inp, GPIO.IN)

while True:
    ips = GPIO.input(inp)
    if ips == True:
        print 'motion detected'
        time.sleep(1)
    else:
        print 'still'
