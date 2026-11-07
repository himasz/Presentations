from abc import ABC, abstractmethod

class SuperPower(ABC):
    @abstractmethod
    def exercise_power(self) -> str: ...

class Fly(SuperPower):          # must inherit
    def exercise_power(self) -> str:
        return "Up, Up, and Away!"

power: SuperPower = Fly()
# SuperPower()  -> TypeError: can't instantiate
# A subclass that forgets exercise_power()
#   -> TypeError the moment you create one
