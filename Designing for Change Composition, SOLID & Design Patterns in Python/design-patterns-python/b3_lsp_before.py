from typing import Protocol
from characters import BadGuy
# --- slide ---
class Character(Protocol):
    def chase(self) -> int: ...
    def flee(self) -> int: ...
    def attack(self) -> int: ...

class BadGuyAdapter:                # from the repo
    def __init__(self, bad_guy: BadGuy):
        self._g = bad_guy
    def chase(self) -> int: return self._g.drive()
    def attack(self) -> int: return self._g.shoot()
    def flee(self) -> int:
        raise Exception("Bad guys don't flee!")

def retreat(party: list[Character]) -> int:
    return sum(c.flee() for c in party)

# retreat([BadGuyAdapter(BadGuy())])  -> crash
