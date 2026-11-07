class Stack:                # Stack HAS-A list
    def __init__(self) -> None:
        self._items: list = []
    def push(self, item) -> None:
        self._items.append(item)
    def pop(self):
        return self._items.pop()
    def __len__(self) -> int:
        return len(self._items)

s = Stack()
s.push(1)
# s.insert(0, 99)  -> AttributeError. Good!
