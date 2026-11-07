class Hero:
    def act(self) -> str: return "Run away"
class FlyingHero(Hero):
    def act(self) -> str: return "Up, Up, and Away!"
class FightingHero(Hero):
    def act(self) -> str: return "KaBaam!"
class FlyingFightingHero(FlyingHero, FightingHero):
    pass                               # empty body

print(FlyingFightingHero().act())
#> Up, Up, and Away!
for cls in FlyingFightingHero.__mro__:  # the order
    print(cls.__name__)
#> FlyingFightingHero
#> FlyingHero
#> FightingHero
#> Hero
#> object
