from typing import Callable
from pizza import (Pizza, PizzaType, CheesePizza,
                   PepperoniPizza, SausagePizza)

Maker = Callable[[], Pizza]          # a type alias

class SimplePizzaFactory:
    _registry: dict[PizzaType, Maker] = {
        PizzaType.CHEESE: CheesePizza,
        PizzaType.PEPPERONI: PepperoniPizza,
        PizzaType.SAUSAGE: SausagePizza,
    }
    def create_pizza(self, kind: PizzaType) -> Pizza:
        return self._registry[kind]()   # KeyError

factory = SimplePizzaFactory()
pizza = factory.create_pizza(PizzaType.CHEESE)
