from typing import Protocol
# --- slide ---
class Discount(Protocol):
    def apply(self, total: float) -> float: ...

class Regular:
    def apply(self, total): return total
class Student:
    def apply(self, total): return total * 0.9
class Vip:
    def apply(self, total): return total * 0.8 - 5

def checkout(total: float, d: Discount) -> float:
    return d.apply(total)       # never edited again

# New customer type?  -> add a class
checkout(100, Student())        # 90.0
