import urllib2
import RPi.GPIO as GPIO
true = 1
temp=''
print 'd'
GPIO.setmode(GPIO.BCM)
GPIO.setup(4, GPIO.OUT)
while(true):
        response = urllib2.urlopen('http://bhawesh.esy.es/automation/buttonStatus.txt')
        status = response.read()
        if temp!=status:
                print status
                if(status == 'ON'):
                        GPIO.output(4,True)
                elif(status == 'OFF'):
                        GPIO.output(4,False)
        temp=status
                
