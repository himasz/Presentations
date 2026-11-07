from c4a_abstract_factory import (ChicagoIngredients,
    IngredientFactory, NewYorkIngredients)
# --- slide ---
class CheesePizza:
    def __init__(self, f: IngredientFactory) -> None:
        self._f = f                 # injected family
    def prepare(self) -> list[str]:
        f = self._f                  # a matching set
        return [f.dough(), f.sauce(), f.cheese()]

print(CheesePizza(ChicagoIngredients()).prepare())
# -> ['deep dish', 'plum tomato', 'mozzarella']
print(CheesePizza(NewYorkIngredients()).prepare())
# -> ['thin crust', 'marinara', 'reggiano']
