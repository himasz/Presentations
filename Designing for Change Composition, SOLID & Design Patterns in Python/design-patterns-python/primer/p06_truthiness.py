# Falsy: None, False, 0, 0.0, "", [], {}, set()
# Everything else is truthy.
if not []:
    print("empty")                 #> empty

class RegularJoe: ...
power = None
power = power or RegularJoe()      # default if falsy
print(type(power).__name__)        #> RegularJoe

count = 0
print(count or 10)                 #> 10
print(10 if count is None else count)   #> 0

a, b = [1], [1]
print(a == b, a is b)              #> True False
