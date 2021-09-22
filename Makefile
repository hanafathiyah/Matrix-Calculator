all: clean build run

build:
	@mvn package assembly:single

run:
	@java -jar bin/tubes-algeo.jar

clean:
	@mvn clean

clear: clean

.PHONY: run build all clean clear
