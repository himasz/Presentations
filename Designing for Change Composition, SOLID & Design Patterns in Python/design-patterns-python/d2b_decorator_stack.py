from d2a_decorator import ArmoredCar, BaseCar
# --- slide ---
class RaceCar:                     # another wrapper
    def __init__(self, car) -> None:
        self._car = car
    @property
    def drive(self) -> int:
        return self._car.drive + 40
    @property
    def attack(self) -> int:
        return self._car.attack - 10
    @property
    def defend(self) -> int:
        return self._car.defend - 10

# Wrappers stack: read it inside out
car = RaceCar(ArmoredCar(ArmoredCar(BaseCar())))
print(car.drive, car.attack, car.defend)
# -> 100 90 170
