from typing import Callable

class Pizza: ...
class CheesePizza(Pizza): ...

# A function that takes no args and returns a Pizza.
# Classes are callable, so CheesePizza itself fits.
make: Callable[[], Pizza] = CheesePizza
print(type(make()).__name__)        #> CheesePizza

def build(cls: type[Pizza]) -> Pizza:   # the class
    return cls()
print(type(build(CheesePizza)).__name__)
#> CheesePizza

class Settings:
    _instance: "Settings | None" = None # forward ref
