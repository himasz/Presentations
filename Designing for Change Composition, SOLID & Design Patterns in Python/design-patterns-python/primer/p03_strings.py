name = 'Ada'               # ' and " are the same
greeting = f"Hi {name}!"   # f-string: {expr}
total = 15.5
print(greeting)                  #> Hi Ada!
print(f"<h1>{total:.2f}</h1>")   #> <h1>15.50</h1>

parts = ["Up", "Up", "Away"]
print(" / ".join(parts))         #> Up / Up / Away
print("a,b".split(","))          #> ['a', 'b']

text = "Patterns are fun"
print(text.removesuffix(" are fun"))  #> Patterns
print(text[:8], text[-3:])       #> Patterns fun
print(len(text), text.upper())
#> 16 PATTERNS ARE FUN
doc = """Triple quotes: a string
that spans several lines."""
