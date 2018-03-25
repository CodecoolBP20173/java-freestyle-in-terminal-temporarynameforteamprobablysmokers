#!/bin/sh

export CLASSPATH_ONE=/home/gergelyk89/codecool/1TWJava/java-oop-terminal-library-temporarynameforteamprobablysmokers/src
export CLASSPATH_TWO=/home/gergelyk89/codecool/1TWJava/java-freestyle-in-terminal-temporarynameforteamprobablysmokers/src

cd $CLASSPATH_ONE
javac com/codecool/termlib/*.java
javac -classpath . $CLASSPATH_TWO/com/codecool/app/*.java
cd
cd $CLASSPATH_TWO
java -classpath $CLASSPATH_ONE:. com.codecool.app.Main
