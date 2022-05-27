import machine
import timingmodel

machine = machine.Machine(numIntRegisters = 256, numFloatRegisters = 256, timingModel = timingmodel.basicTimingModel)