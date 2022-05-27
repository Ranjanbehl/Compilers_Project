LIB_ANTLR ?= /usr/local/share/antlr.jar
ANTLR_TOOL ?= antlr
ANTLR_SCRIPT := MicroC.g4
SRC_DIRS := src/ast/*.java src/ast/visitor/*.java src/compiler/*.java src/assembly/*.java src/assembly/instructions/*.java

all: compiler

compiler:
	rm -rf build classes
	mkdir build classes
	$(ANTLR_TOOL) -o build/compiler $(ANTLR_SCRIPT)
	javac -cp $(CLASSPATH):$(LIB_ANTLR) -d classes $(SRC_DIRS) build/compiler/*.java

clean:
	rm -rf classes build
