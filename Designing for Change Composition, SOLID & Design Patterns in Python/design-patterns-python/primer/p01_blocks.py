class Greeter:
    def greet(self, name: str) -> str:
        if not name:              # empty string?
            return "Hello, stranger"
        return "Hello, " + name

g = Greeter()                     # no `new`
print(g.greet("Ada"))             #> Hello, Ada
print(g.greet(""))                #> Hello, stranger
