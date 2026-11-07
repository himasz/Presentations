count = 3                # no type, no `var`
count = "three"          # legal; mypy objects
price: float = 9.5       # optional type hint
DISCOUNT = 0.9           # constant by convention

a, b = 1, 2              # tuple unpacking
a, b = b, a              # swap in one line
drive = attack = defend = 100

nothing = None           # Java's null
done = True              # True / False

print(a, b, drive)            #> 2 1 100
print(type(count))            #> <class 'str'>
print(7 / 2, 7 // 2, 7 % 2)   #> 3.5 3 1
