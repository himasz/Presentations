class SalesReport:                  # finance
    def __init__(self, orders):
        self.orders = orders
    def total(self) -> float:
        return sum(o.price for o in self.orders)

class HtmlFormatter:                # design team
    def format(self, r: SalesReport) -> str:
        return f"<h1>{r.total():.2f}</h1>"

class FileStore:                    # ops / storage
    def save(self, path: str, text: str):
        with open(path, "w") as f:
            f.write(text)
