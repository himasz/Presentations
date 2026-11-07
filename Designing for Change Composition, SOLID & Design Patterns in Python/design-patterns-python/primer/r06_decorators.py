import functools

def log_calls(func):               # takes a function
    @functools.wraps(func)         # keeps the name
    def wrapper(*args, **kwargs):  # accepts anything
        print("calling", func.__name__)
        return func(*args, **kwargs)
    return wrapper                 # returns one

@log_calls               # greet = log_calls(greet)
def greet(name: str) -> str:
    return f"Hi {name}"

print(greet("Ada"))
#> calling greet
#> Hi Ada
