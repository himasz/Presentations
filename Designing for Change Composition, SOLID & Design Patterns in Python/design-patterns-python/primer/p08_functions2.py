def add_then_multiply(*nums: int, factor: int):
    return sum(nums) * factor    # nums is a tuple

print(add_then_multiply(4, 3, factor=5))   #> 35
# add_then_multiply(4, 3, 5) -> TypeError:
#   factor is keyword-only (it comes after *nums)

pair = (4, 3)
print(add_then_multiply(*pair, factor=2))  #> 14

def fly() -> str:
    return "Up, Up, and Away!"

power = fly                # no (): the function
shout = lambda: "KaBaam!"  # one-expression function
print(power())             #> Up, Up, and Away!
print(shout())             #> KaBaam!
