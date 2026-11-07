def describe(n: int) -> str:
    if n < 0:
        return "negative"
    elif n == 0:                   # not `else if`
        return "zero"
    else:
        return "positive"

print(describe(-5), describe(0))   #> negative zero

for i, word in enumerate(["a", "b"]):
    print(i, word)                 #> 0 a
                                   #> 1 b
print(list(range(3)))              #> [0, 1, 2]

ok = 0 < 5 < 10 and not False      # chained compare
print(ok)                          #> True
