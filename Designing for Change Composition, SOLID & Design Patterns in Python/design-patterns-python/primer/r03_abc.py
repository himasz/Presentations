from abc import ABC, abstractmethod

class PizzaStore(ABC):
    def order(self) -> str:
        return "ordered " + self.create()
    @abstractmethod
    def create(self) -> str: ...

class NYStore(PizzaStore):
    def create(self) -> str: return "thin crust"

print(NYStore().order())     #> ordered thin crust
# PizzaStore()  -> TypeError: Can't instantiate
