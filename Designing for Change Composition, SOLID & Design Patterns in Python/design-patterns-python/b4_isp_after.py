from typing import Protocol
# --- slide ---
class BaseIngredients(Protocol):
    def make_dough(self) -> str: ...
    def make_sauce(self) -> str: ...
    def make_cheese(self) -> str: ...

class MeatIngredients(Protocol):
    def make_sausage(self) -> str: ...
    def make_pepperoni(self) -> str: ...

class VeggieKitchen:          # only what it does
    def make_dough(self): return "wheat"
    def make_sauce(self): return "tomato"
    def make_cheese(self): return "vegan"

def cheese_pizza(k: BaseIngredients) -> list[str]:
    return [k.make_dough(), k.make_sauce(),
            k.make_cheese()]
