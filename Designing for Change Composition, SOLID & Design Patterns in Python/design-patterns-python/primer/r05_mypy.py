from typing import Protocol
# --- slide ---
class Escaper(Protocol):
    def chase(self) -> int: ...
    def flee(self) -> int: ...

class BadGuyAdapter:               # no flee()
    def chase(self) -> int: return 30

def retreat(party: list[Escaper]) -> int:
    return sum(c.flee() for c in party)

retreat([BadGuyAdapter()])
# $ mypy r05_mypy.py
#! List item 0 has incompatible type "BadGuyAdapter";
#!   expected "Escaper"
#! note: "BadGuyAdapter" is missing following
#!     flee
