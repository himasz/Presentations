class Hero:
    def __init__(self, name: str) -> None:
        self.name = name
    def act(self) -> str:
        return f"{self.name} runs away"

class FlyingHero(Hero):              # extends Hero
    def __init__(self, name: str, speed: int):
        super().__init__(name)       # the parent's
        self.speed = speed
    def act(self) -> str:            # override
        return f"{self.name} flies at {self.speed}"

for h in [Hero("Joe"), FlyingHero("Kara", 900)]:
    print(h.act())
#> Joe runs away
#> Kara flies at 900
print(isinstance(FlyingHero("K", 1), Hero))  #> True
