# A module is a .py file: pizza.py -> `pizza`
import threading                # the whole module
from functools import cache     # one name from it
from pizza import (CheesePizza, # ( ) wraps lines
                   PizzaType)

lock = threading.Lock()         # module.name
print(PizzaType.CHEESE.value)   #> cheese

# Top-level code runs once, on the first import;
# later imports reuse the same module object.
# That's why a module works as a Singleton.

if __name__ == "__main__":      # run directly?
    print("run as a script")    #> run as a script
