from typing import Protocol
# --- slide ---
class IngredientFactory(Protocol):     # one family
    def dough(self) -> str: ...
    def sauce(self) -> str: ...
    def cheese(self) -> str: ...

class NewYorkIngredients:
    def dough(self): return "thin crust"
    def sauce(self): return "marinara"
    def cheese(self): return "reggiano"

class ChicagoIngredients:
    def dough(self): return "deep dish"
    def sauce(self): return "plum tomato"
    def cheese(self): return "mozzarella"
