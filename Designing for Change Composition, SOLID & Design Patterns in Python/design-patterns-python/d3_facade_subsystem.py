class Confusing:              # awkward, as found
    def execute(self, a, b, c): return a + b + c
    def method1(self): return 0
    def method2(self, x, y=0): return x + y

class Overdone:
    def __init__(self, some_string): ...
    def do_something(self, x, y):
        return x * y
    def do_something_else(self, x, y, z):
        return (x + y) * z
    def do_something_again(self, x, y, z, a):
        return (x + y + z) * a
