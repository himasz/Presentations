def add(a: int, b: int) -> int:
    return a + b

print(add(2, 3))                  #> 5
print(add("2", "3"))              #> 23
# Python ran it anyway. A type checker would not:
# $ mypy r01_hints.py
#! Argument 1 to "add" has incompatible type "str"

name: str = "Ada"
maybe: str | None = None          # str or None
names: list[str] = ["Ada"]
ages: dict[str, int] = {"Ada": 36}
pair: tuple[int, int] = (1, 2)
