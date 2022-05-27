from memory import Memory
from registers import IRegister
from registers import FRegister
import timingmodel
import program
import config
import machine
import sys

if __name__ == '__main__' :
    p = program.Program()
    p.buildCodeFromFile(sys.argv[1])
    
    config.machine.execProgram(p)