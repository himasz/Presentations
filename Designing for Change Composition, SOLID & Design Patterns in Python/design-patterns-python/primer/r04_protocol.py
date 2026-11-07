from typing import Protocol

class SuperPower(Protocol):
    def exercise_power(self) -> str: ...

class Fly:                   # no base class
    def exercise_power(self) -> str: return "Up!"

class Wing:                  # same shape, unrelated
    def exercise_power(self) -> str: return "Up!"

p: SuperPower = Fly()        # OK: the shape fits
w: SuperPower = Wing()       # also OK
print(p.exercise_power())    #> Up!
