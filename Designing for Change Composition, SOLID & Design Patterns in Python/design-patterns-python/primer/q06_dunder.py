class Stack:
    def __init__(self) -> None:       # constructor
        self._items: list = []
    def push(self, item) -> None:
        self._items.append(item)
    def __len__(self) -> int:         # len(stack)
        return len(self._items)
    def __repr__(self) -> str:        # print()
        return f"Stack({self._items})"
    def __eq__(self, other) -> bool:  # ==
        return (isinstance(other, Stack)
                and self._items == other._items)

s = Stack()
s.push(1)
print(len(s), s)                      #> 1 Stack([1])
print(s == Stack())                   #> False
