from typing import Protocol
# --- slide ---
class SuperPower(Protocol):
    def exercise(self) -> str: ...

class Fly:
    def exercise(self): return "Up, Up, and Away!"
class Fight:
    def exercise(self): return "KaBaam!"

class Hero:
    def __init__(self, *powers: SuperPower) -> None:
        self.powers = list(powers)     # has-a
    def act(self) -> str:
        return " / ".join(
            p.exercise() for p in self.powers)

print(Hero(Fly(), Fight()).act())
# -> 'Up, Up, and Away! / KaBaam!'
