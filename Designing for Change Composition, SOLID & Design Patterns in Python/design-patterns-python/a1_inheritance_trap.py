class Hero:
    def act(self) -> str: return "Run away"

class FlyingHero(Hero):
    def act(self) -> str: return "Up, Up, and Away!"

class FightingHero(Hero):
    def act(self) -> str: return "KaBaam!"

# Needs both? Yet another subclass...
class FlyingFightingHero(FlyingHero, FightingHero):
    pass

print(FlyingFightingHero().act())
# -> 'Up, Up, and Away!'
#    the MRO picked one; KaBaam! is lost
