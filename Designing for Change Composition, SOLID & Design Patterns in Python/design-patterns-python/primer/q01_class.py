class Hero:
    def __init__(self, power: str) -> None:
        self._power = power      # creates the field

    def act(self) -> str:
        return "I can " + self._power

h = Hero("fly")                  # no `new`
print(h.act())                   #> I can fly
print(h._power)                  #> fly
