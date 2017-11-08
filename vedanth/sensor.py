import requests
# temp = raw_input("Temperature sesnor value : ")
# mois = raw_input("Moisture sesnor value : ")
# soil = raw_input("Soil sesnor value : ")

temp = 29
mois = 98
soil = 1

url = "http://localhost/ITTLab/HomeAutomation/vedanth/php/"
requests.get(url + "temp.php?temperature=" + str(temp));
requests.get(url + "moisture.php?moisture=" + str(mois));
requests.get(url + "soil.php?soildata=" + str(soil));