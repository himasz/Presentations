def checkout(total: float, kind: str) -> float:
    if kind == "student":
        return total * 0.9
    raise ValueError(f"unknown kind: {kind}")

try:
    checkout(100, "alien")
except ValueError as e:              # catch
    print("Error:", e)
finally:
    print("always runs")
#> Error: unknown kind: alien
#> always runs
try:
    {"cheese": 8.0}["hawaiian"]
except KeyError:
    print("no such key")             #> no such key
assert checkout(100, "student") == 90.0
