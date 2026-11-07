from typing import Protocol
# --- slide ---
class Character(Protocol):    # what the game wants
    def chase(self) -> int: ...
    def flee(self) -> int: ...
    def attack(self) -> int: ...

class Moose:                  # what we actually have
    def run(self) -> int: return 5
    def charge(self) -> int: return 10

class MooseAdapter:           # translates the calls
    def __init__(self, moose: Moose) -> None:
        self._m = moose
    def chase(self) -> int: return self._m.run()
    def flee(self) -> int: return self._m.run()
    def attack(self) -> int: return self._m.charge()

m: Character = MooseAdapter(Moose())
print(m.chase(), m.flee(), m.attack())   # 5 5 10
