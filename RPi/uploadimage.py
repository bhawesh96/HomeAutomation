import ftplib
session = ftplib.FTP('cribblservices.esy.es','u553917010','Clandestine@1996')
file = open('img.png','rb')
print 'h'# file to send
session.storbinary('STOR photo.png', file)     # send the file
print 'x'
file.close()                                    # close file and FTP
session.quit()
print 'done'
