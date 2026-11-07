from abc import ABC, abstractmethod
# --- slide ---
class IngredientFactory(ABC):     # the repo's shape
    @abstractmethod
    def make_dough(self) -> str: ...
    @abstractmethod
    def make_sauce(self) -> str: ...
    @abstractmethod
    def make_cheese(self) -> str: ...
    @abstractmethod
    def make_sausage(self) -> str: ...
    @abstractmethod
    def make_pepperoni(self) -> str: ...

class VeggieKitchen(IngredientFactory):
    # make_dough / make_sauce / make_cheese ...
    def make_sausage(self) -> str:
        raise NotImplementedError   # forced to
    def make_pepperoni(self) -> str:
        raise NotImplementedError   # forced to
