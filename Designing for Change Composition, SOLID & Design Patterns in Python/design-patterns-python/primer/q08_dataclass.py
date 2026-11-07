from dataclasses import dataclass, field
# --- slide ---
@dataclass(frozen=True)                # immutable
class GameResult:
    winner: str
    loser: str
    score: str

r = GameResult("Ox", "Elk", "2-1")
print(r)
#> GameResult(winner='Ox', loser='Elk', score='2-1')
print(r == GameResult("Ox", "Elk", "2-1"))
#> True
@dataclass
class Pizza:
    kind: str
    dough: str = "regular"                # default
    steps: list[str] = field(default_factory=list)
print(Pizza("cheese"))
#> Pizza(kind='cheese', dough='regular', steps=[])
