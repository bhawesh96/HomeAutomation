void setup(){
  Serial.begin(9600);
}
char soildata;
void loop(){

//soil data
int soil = analogRead(A0);
if(soil<400)
soildata = '2'; //wet
else if(soil>400 && soil <700)
soildata = '1';//fine
else if(soil > 700)
soildata = '0';  //dry

//Serial.write(soildata);
Serial.println(soil);
// delay(2000);


  }
