from abc import ABC, abstractmethod
# --- slide ---
class PizzaStore(ABC):
    def create_pizza_for_delivery(self) -> list[str]:
        return [self.take_order(),     # the template
                self.process_payment(),
                self.make_pizza(),
                self.cook_pizza(),
                self.deliver_pizza()]

    def process_payment(self): return "paid"
    def deliver_pizza(self): return "delivered"

    @abstractmethod
    def take_order(self) -> str: ...
    @abstractmethod
    def make_pizza(self) -> str: ...
    @abstractmethod
    def cook_pizza(self) -> str: ...
