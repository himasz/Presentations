def checkout(total: float, kind: str) -> float:
    if kind == "regular":
        return total
    elif kind == "student":
        return total * 0.9
    elif kind == "vip":
        return total * 0.8 - 5
    raise ValueError(kind)

# New customer type?
#   -> edit, re-test, re-deploy checkout()
