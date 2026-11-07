class BaseCar: drive = 100
class ArmoredCar:
    def __init__(self, car) -> None: self._car = car
    @property                    # computed attribute
    def drive(self) -> int:
        return self._car.drive - 20

car = ArmoredCar(BaseCar())
print(car.drive)                 #> 80
class Temperature:
    def __init__(self) -> None: self._c = 0.0
    @property
    def celsius(self) -> float: return self._c
    @celsius.setter
    def celsius(self, value: float) -> None:
        self._c = max(value, -273.15)
t = Temperature(); t.celsius = -500
print(t.celsius)                 #> -273.15
