LIB_ANTLR ?= /usr/local/share/antlr.jar
ANTLR_TOOL ?= antlr
ANTLR_SCRIPT := MicroC.g4

all: compiler

compiler:
	rm -rf build classes
	mkdir build classes
	$(ANTLR_TOOL) -o build $(ANTLR_SCRIPT)
	javac -cp $(CLASSPATH):$(LIB_ANTLR) -d classes src/*.java build/*.java

clean:
	rm -rf classes build	
