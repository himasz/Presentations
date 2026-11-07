from typing import Protocol
from characters import BadGuy
# --- slide ---
class Combatant(Protocol):
    def chase(self) -> int: ...
    def attack(self) -> int: ...

class Escaper(Combatant, Protocol):
    def flee(self) -> int: ...

class BadGuyAdapter:        # no flee() promised
    def __init__(self, bad_guy: BadGuy):
        self._g = bad_guy
    def chase(self) -> int: return self._g.drive()
    def attack(self) -> int: return self._g.shoot()

def retreat(party: list[Escaper]) -> int:
    return sum(c.flee() for c in party)

# retreat([BadGuyAdapter(BadGuy())])
#   -> mypy error: BadGuyAdapter is not an Escaper
