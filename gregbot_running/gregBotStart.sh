#!/bin/bash

echo Starting Gregbot...
if [ -f logfile.txt ]
then
	echo Moving old logfile.txt into logfile_old.txt....
	mv logfile.txt logfile_old.txt
fi

cd ~
cd GregBot/
#screen -dmS GregBot bash -c 'java -jar GregBot-1.0-SNAPSHOT.jar | tee logfile.txt'
if   ! screen -ls | grep -q "GregBot"; then
	echo ERROR - GregBot failed to initialise.	
	exit 0
fi
echo Gregbot started successfully!
