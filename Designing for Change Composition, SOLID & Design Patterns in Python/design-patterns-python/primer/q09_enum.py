from enum import Enum

class PizzaType(Enum):
    CHEESE = "cheese"
    PEPPERONI = "pepperoni"
    SAUSAGE = "sausage"

kind = PizzaType.CHEESE
print(kind)                     #> PizzaType.CHEESE
print(kind.value, kind.name)    #> cheese CHEESE
print(PizzaType("sausage"))     #> PizzaType.SAUSAGE
print([t.value for t in PizzaType])
#> ['cheese', 'pepperoni', 'sausage']
print(kind is PizzaType.CHEESE) #> True
