from AC import AirConditioner
from CC import ClimatControl

if __name__ == '__main__':
    # ac = AirConditioner(20,"V1",False)
    # ac.showInfo()
    # ac.changeTemp(22)
    # ac.onOff()
    # ac.changeTemp(22)

    cc = ClimatControl(20,"V2",True,True)
    cc.showInfo()
    cc.changeTemp(12)
    cc.CConOff()
    cc.changeTemp(12)