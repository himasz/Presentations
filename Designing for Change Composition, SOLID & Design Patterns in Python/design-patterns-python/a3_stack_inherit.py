class Stack(list):          # Stack IS-A list
    def push(self, item) -> None:
        self.append(item)

s = Stack()
s.push(1)
s.push(2)
s.insert(0, 99)   # allowed: LIFO rule broken
s.sort()          # also allowed
s.clear()         # ...every list method works
