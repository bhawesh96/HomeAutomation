import Adafruit_DHT
import time
while True:
    ### Assume 
    humidity, temperature = Adafruit_DHT.read_retry( Adafruit_DHT.DHT11, 4 )
    if humidity is not None and temperature is not None:
        print "Temp={0:f}*C  Humidity={1:f}%".format(temperature, humidity)
        
    else:
        print "Failed to get reading. Try again!"

    #Sleep some time
    time.sleep( 1 )
