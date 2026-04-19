CLASSPATH=bin/
junit5=junit-platform-console-standalone-6.0.0-RC3.jar
all:
	javac src/main/java/*.java -d $(CLASSPATH) -cp $(CLASSPATH):$(junit5)
