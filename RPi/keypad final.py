from KEYPAD import *

kp=keypad()

while True:
    digit = None
    while digit == None:
        digit = kp.getKey()
        
    print digit
    time.sleep(0.5)
