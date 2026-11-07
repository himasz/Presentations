"""Shared pizza domain used by the factory examples."""
from dataclasses import dataclass, field
from enum import Enum


class PizzaType(Enum):
    CHEESE = "cheese"
    PEPPERONI = "pepperoni"
    SAUSAGE = "sausage"


@dataclass
class Pizza:
    kind: PizzaType
    dough: str = "regular"
    steps: list[str] = field(default_factory=list)

    def prepare(self) -> None: self.steps.append("prepare")
    def bake(self) -> None: self.steps.append("bake")
    def cut(self) -> None: self.steps.append("cut")
    def box(self) -> None: self.steps.append("box")


class CheesePizza(Pizza):
    def __init__(self) -> None: super().__init__(PizzaType.CHEESE)


class PepperoniPizza(Pizza):
    def __init__(self) -> None: super().__init__(PizzaType.PEPPERONI)


class SausagePizza(Pizza):
    def __init__(self) -> None: super().__init__(PizzaType.SAUSAGE)
