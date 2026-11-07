class BaseCar:
    drive = attack = defend = 100  # class attributes
class Counter:
    created = 0                    # shared by all
    def __init__(self) -> None:
        Counter.created += 1
        self.clicks = 0            # per instance

a, b = Counter(), Counter()
a.clicks += 1
print(Counter.created, a.clicks, b.clicks)  #> 2 1 0
print(BaseCar().drive)             #> 100

class Bad:
    items: list[str] = []          # ONE shared list
x, y = Bad(), Bad()
x.items.append("oops")
print(y.items)                     #> ['oops']
