JC = javac
JVM = java
JFLAGS = -cp "."
RUNFLAGS = -cp "./src" 

FILES = ./src/Graph/*.java ./src/GUI/*.java ./src/Metro/*.java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(FILES)

CLASSES = \
			./src/Graph/Edge.java \
			./src/Graph/Graph.java \
			./src/Graph/Node.java \
			./src/GUI/GUIUndergroundGreece.java \
			./src/Metro/Astar.java \
			./src/Metro/Metro.java \
			./src/Metro/Station.java \

classes = $(CLASSES:.java=.class)


default: $(classes)

run: 
	$(JVM) $(RUNFLAGS) GUI.GUIUndergroundGreece -vmargs "-Xmx512m"

clean:
	$(RM) -r ./src/Graph/*.class
	$(RM) -r ./src/Metro/*.class
	$(RM) -r ./src/GUI/*.class