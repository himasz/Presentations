from e1a_strategy_powers import Fly, SuperPower, WeaveWeb
# --- slide ---
class Hero:
    def __init__(self, power: SuperPower) -> None:
        self._power = power
    def do_hero_stuff(self) -> str:
        return self._power.exercise_power()
    def change_super_power(self, power: SuperPower):
        self._power = power        # swap at runtime

class SpiderMan(Hero):
    def __init__(self): super().__init__(WeaveWeb())

spidey = SpiderMan()
spidey.do_hero_stuff() # Catches Thieves Like Flies!
spidey.change_super_power(Fly())
spidey.do_hero_stuff() # Up, Up, and Away!
