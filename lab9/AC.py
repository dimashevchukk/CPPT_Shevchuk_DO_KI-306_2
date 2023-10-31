class AirConditioner:

    temp = 0
    model = "unknown"
    enabled = False

    def __init__(self, temp, model, enabled):
        self.temp = temp
        self.model = model
        self.enabled = enabled

    def showInfo(self):
        print("Temperature is", self.temp)
        print("Model is", self.model)
        print("AC is {}".format("enabled" if self.enabled else "disabled"))

    def changeTemp(self, temp):
        if self.enabled:
            self.temp = temp
            print("Temp changed to ", temp)
        else:
            print("You have to turn on AC first")

    def onOff(self):
        if self.enabled:
            self.enabled = False
        else:
            self.enabled = True
        print("AC is {}".format("enabled" if self.enabled else "disabled"))