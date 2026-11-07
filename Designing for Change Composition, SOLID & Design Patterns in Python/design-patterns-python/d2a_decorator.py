class BaseCar:
    drive = attack = defend = 100

class ArmoredCar:                  # wraps ANY car
    def __init__(self, car) -> None:
        self._car = car
    @property
    def drive(self) -> int:
        return self._car.drive - 20
    @property
    def attack(self) -> int:
        return self._car.attack
    @property
    def defend(self) -> int:
        return self._car.defend + 40

armored = ArmoredCar(BaseCar())
print(armored.drive, armored.defend)    # 80 140
