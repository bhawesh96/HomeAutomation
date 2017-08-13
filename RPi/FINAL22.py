import urllib2
import numpy as np
import ftplib
import requests
import Adafruit_DHT
import time
import cv2
import serial
import RPi.GPIO as GPIO
GPIO.setwarnings(False)

#ser = serial.Serial("/dev/ttyACM0", 9600)
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
def soil():
    soilval = ser.read()
    soildata = {'soildata' : soilval}
    r3 = requests.get('http://cribblservices.esy.es/vedanth/php/soil.php', params = soildata)
    print "Soil data uploaded : " + str(soilval)
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
    response = urllib2.urlopen('http://cribblservices.esy.es/vedanth/php/main.txt')
    status = response.read()
    return (status)
  
while True:
#	IR()
#	soil()
	x = fetch()
	print x
	if(len(x) == 6):
		p=x[0]
		q=x[1]
		r=x[2]
		s=x[3]
		t=x[4]
		u=x[5]
		print p+q+r+s+t+u
	
	print ''
	

	print "Room1 : " + p
	print "Room2 : " + q
	print "Hall LED3 : " + r
	print "Hall LED4 : " + s
	print "Hall FAN : " + t
	if(p  == '1'):
		GPIO.output(LED2,True)
		print 'led2on'
	elif(p  == '0'):
		GPIO.output(LED2, False)
	if(q == '1'):
		GPIO.output(LED1, True)
		print 'led1on'
	elif(q == '0'):
		GPIO.output(LED1, False)
	if(r == '1'):
		GPIO.output(LED3, True)
	elif(r == '0'):
		GPIO.output(LED3, False)
	if(s == '1'):
		GPIO.output(LED4, True)
	elif(s == '0'):
		GPIO.output(LED4, False)
	if(t == '1'):
		GPIO.output(FAN, True)
	elif(t == '0'):
		GPIO.output(FAN, False)
#	dth()
#	IR()	

