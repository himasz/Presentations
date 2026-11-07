from dataclasses import dataclass
from typing import Protocol
# --- slide ---
@dataclass(frozen=True)
class GameResult:
    winner: str
    loser: str
    score: str

class Observer(Protocol):
    def update(self, r: GameResult) -> None: ...
class SportsAggregator:             # the subject
    def __init__(self) -> None:
        self._observers: list[Observer] = []
    def register(self, o: Observer) -> None:
        self._observers.append(o)
    def unregister(self, o: Observer) -> None:
        self._observers.remove(o)
    def add_game_result(self, r: GameResult):
        for o in list(self._observers):
            o.update(r)         # push to everyone
