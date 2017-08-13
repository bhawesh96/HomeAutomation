import urllib2
import numpy as np
import ftplib
import requests
import Adafruit_DHT
import time
import cv2
import RPi.GPIO as GPIO
GPIO.setwarnings(False)

#Room1
LED1 = 3
dth = 4

#Room2
LED2 = 17
IRpin = 27
buzzer =22

#Hall 
LED3 = 6
LED4 = 13
FAN = 19
servo = 26	

#Outputs
GPIO.setmode(GPIO.BCM)
#GPIO.setup(dth, GPIO.OUT)
GPIO.setup(servo, GPIO.OUT)
GPIO.setup(buzzer, GPIO.OUT)
GPIO.setup(LED1, GPIO.OUT)
GPIO.setup(LED2, GPIO.OUT)
GPIO.setup(LED3, GPIO.OUT)
GPIO.setup(LED4, GPIO.OUT)
GPIO.setup(FAN, GPIO.OUT)
#PWM
pwm = GPIO.PWM(servo, 100)
pwm.start(5)


#Inputs
GPIO.setup(IRpin, GPIO.IN)


GPIO.output(LED1, False)
GPIO.output(LED2, False)
GPIO.output(LED3, False)
GPIO.output(LED4, False)
GPIO.output(FAN, False)
GPIO.output(servo, False)
GPIO.output(buzzer, False)
ir_state = False
def dth():
    humidity, temperature = Adafruit_DHT.read_retry( Adafruit_DHT.DHT11,4 )
    if humidity is not None and temperature is not None:
        #return (temperature, humidity)
        tempdata = {'temperature' : temperature}
        moisturedata = {'moisture' : humidity}
        r1 = requests.get('http://cribblservices.esy.es/vedanth/php/temp.php' , params = tempdata)
        r2 = requests.get('http://cribblservices.esy.es/vedanth/php/moisture.php' , params = moisturedata)
	print "DTH uploaded : " + str(temperature)
	print "DTH uploaded : " + str(humidity)
    else:
        print "Failed to get reading. Try again!"

def capture():
    cap = cv2.VideoCapture(0 )
    ret, frame = cap.read()
    cv2.imwrite('cap.jpg', frame)
    cap.release()
    cv2.destroyAllWindows()

def security_upload():
    session = ftplib.FTP('cribblservices.esy.es','username','password')
    file = open('cap.jpg','rb')
    session.storbinary('STOR photo.jpg', file)     # send the file
    file.close()                                    # close file and FTP
    session.quit()
    print 'done'


def IR():
    ir_state = GPIO.input(IRpin)
    if ir_state == True:
        GPIO.output(buzzer, True)
        print 'camera'
        capture()
        security_upload()
        print 'done'
        GPIO.output(buzzer, False)
        time.sleep(1)
        
        
def doorclose():
    angle = 100
    duty = float(angle) / 10.0 + 2.5
    pwm.ChangeDutyCycle(duty)

def dooropen():    
    angle = 0
    duty = float(angle) / 10.0 + 2.5
    pwm.ChangeDutyCycle(duty)



def fetch():
    response1 = urllib2.urlopen('http://cribblservices.esy.es/vedanth/php/room1.txt')
    status1 = response1.read()
    response2 = urllib2.urlopen('http://cribblservices.esy.es/vedanth/php/room2.txt')
    status2 = response2.read()
    response3 = urllib2.urlopen('http://cribblservices.esy.es/vedanth/php/hall.txt')
    status3 = response3.read()
    return (status1, status2, status3)
   
  
while True:
#	IR()
	x = fetch()
	y = x[1]
	z = x[0]
	a = x[2][0]
#	a=0
	b = x[2][1]
#	b=0
	c = x[2][2]
#	c=0
	print "Room1 : " + z
	print "Room2 : " + y
	print "Hall LED3 : " + a
	print "Hall LED4 : " + b
	print "Hall FAN : " + c
	if(y  == '1'):
		GPIO.output(LED2,True)
	elif(y  == '0'):
		GPIO.output(LED2, False)
	if(z == '1'):
		GPIO.output(LED1, True)
	elif(z == '0'):
		GPIO.output(LED1, False)
	if(a == '1'):
		GPIO.output(LED3, True)
	elif(a == '0'):
		GPIO.output(LED3, False)
	if(b == '1'):
		GPIO.output(LED4, True)
	elif(b == '0'):
		GPIO.output(LED4, False)
	if(c == '1'):
		GPIO.output(FAN, True)
	elif(c == '0'):
		GPIO.output(FAN, False)
#	dth()
	IR()
			

