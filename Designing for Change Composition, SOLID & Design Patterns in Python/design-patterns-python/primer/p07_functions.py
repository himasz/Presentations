def area(width: float, height=1.0) -> float:
    """Return width times height."""    # docstring
    return width * height

print(area(3, 2))                #> 6
print(area(3))                   #> 3.0
print(area(height=2, width=5))   #> 10

def greet(name):                 # hints optional
    print("Hi", name)            # no return: None

print(greet("Ada"))
#> Hi Ada
#> None

def min_max(xs: list[int]) -> tuple[int, int]:
    return min(xs), max(xs)      # a tuple
lo, hi = min_max([3, 1, 4])      # lo=1, hi=4
