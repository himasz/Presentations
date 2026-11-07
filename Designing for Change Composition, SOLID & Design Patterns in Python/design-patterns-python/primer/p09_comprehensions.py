prices = [8.0, 9.5, 10.0]

doubled = [p * 2 for p in prices]       # list comp
cheap = [p for p in prices if p < 10]   # + filter
sizes = {w: len(w) for w in ["fly", "web"]}
print(doubled)     #> [16.0, 19.0, 20.0]
print(cheap)       #> [8.0, 9.5]
print(sizes)       #> {'fly': 3, 'web': 3}

# A generator expression: no brackets, lazy.
# The lecture's SRP slide does exactly this:
total = sum(p for p in prices)
print(total)       #> 27.5
print(" / ".join(w.upper() for w in ["up", "away"]))
#> UP / AWAY
