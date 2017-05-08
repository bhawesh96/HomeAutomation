import urllib2
#import RPi.GPIO as GPIO
#GPIO.setwarnings(False)

#GPIO.setmode(GPIO.BCM)
#GPIO.setup(4, GPIO.OUT)
while(1):
        response = urllib2.urlopen('http://localhost/bys')
        status = response.read()
        print status
                
