from typing import Protocol
# --- slide ---
class SuperPower(Protocol):
    def exercise_power(self) -> str: ...

class Fly:
    def exercise_power(self) -> str:
        return "Up, Up, and Away!"

class WeaveWeb:
    def exercise_power(self) -> str:
        return "Catches Thieves Like Flies!"

# Each power is a small, swappable object.
# Python could also just pass a function.
