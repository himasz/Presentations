class SalesReport:
    def __init__(self, orders):
        self.orders = orders

    def total(self) -> float:       # finance
        return sum(o.price for o in self.orders)

    def to_html(self) -> str:       # design team
        return f"<h1>{self.total():.2f}</h1>"

    def save(self, path: str):      # ops / storage
        with open(path, "w") as f:
            f.write(self.to_html())
