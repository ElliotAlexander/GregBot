#!/bin/bash

echo Starting Twitter-Picture-Bot...
if [ -f logfile.txt ]
then
	echo Moving old logfile.txt into logfile_old.txt....
	mv logfile.txt logfile_old.txt
fi

screen -dmS Twitter-Picture-Bot bash -c 'java -jar Twitter-Picture-Bot-1.0-SNAPSHOT.jar | tee logfile.txt'
if   ! screen -ls | grep -q "Twitter-Picture-Bot"; then
	echo ERROR - Twitter-Picture-Bot failed to initialise.	
	exit 0
fi
echo Twitter-Picture-Bot started successfully!
