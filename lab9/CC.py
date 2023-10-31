from AC import AirConditioner

class ClimatControl(AirConditioner):

    autoreg = False

    def __init__(self, temp, model, enabled, autoreg):
        super().__init__(temp, model, enabled)
        self.autoreg = autoreg

    def CConOff(self):
        if self.autoreg:
            self.autoreg = False
        else:
            self.autoreg = True

    def showInfo(self):
        print("Temperature is", self.temp)
        print("Model is", self.model)
        print("AC is {}".format("enabled" if self.enabled else "disabled"))
        print("CC is {}".format("enabled" if self.autoreg else "disabled"))

    def changeTemp(self, temp):
        if self.autoreg:
            print("You have to turn off the CC first")
        else:
            if self.enabled:
                self.temp = temp
                print("Temp changed to ", temp)
            else:
                print("You have to turn on AC first")