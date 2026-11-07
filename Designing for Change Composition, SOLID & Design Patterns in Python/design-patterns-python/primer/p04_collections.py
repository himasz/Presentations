powers = ["fly", "fight"]    # list: mutable
powers.append("swim")
last = powers.pop()          # removes the last
print(powers, last)    #> ['fly', 'fight'] swim

point = (3, 4)               # tuple: can't change
x, y = point                 # unpack it

prices = {"cheese": 8.0}     # dict: key -> value
prices["vip"] = 9.5
print("vip" in prices)               #> True
print(prices.get("hawaiian"))        #> None

seen = {"fly", "fly", "web"}  # set: unique values
print(len(seen))                     #> 2
