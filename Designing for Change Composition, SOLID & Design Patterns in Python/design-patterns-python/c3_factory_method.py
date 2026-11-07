from abc import ABC, abstractmethod
from pizza import Pizza, PizzaType
# --- slide ---
class PizzaStore(ABC):
    def order_pizza(self, kind: PizzaType) -> Pizza:
        p = self.create_pizza(kind)  # factory method
        p.prepare(); p.bake(); p.cut(); p.box()
        return p

    @abstractmethod
    def create_pizza(self, kind) -> Pizza: ...

class NewYorkStore(PizzaStore):
    def create_pizza(self, kind: PizzaType) -> Pizza:
        return Pizza(kind, dough="thin")

class ChicagoStore(PizzaStore):
    def create_pizza(self, kind: PizzaType) -> Pizza:
        return Pizza(kind, dough="deep dish")

pizza = ChicagoStore().order_pizza(PizzaType.SAUSAGE)
