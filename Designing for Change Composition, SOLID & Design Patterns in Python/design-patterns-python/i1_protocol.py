from typing import Protocol

class SuperPower(Protocol):
    def exercise_power(self) -> str: ...

class Fly:                  # no base class at all
    def exercise_power(self) -> str:
        return "Up, Up, and Away!"

power: SuperPower = Fly()
# Fits by shape ("duck typing"), and
# mypy / pyright verify the shape for you.
# Great for code you don't own.
