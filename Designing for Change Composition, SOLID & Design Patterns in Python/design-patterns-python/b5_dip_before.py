class PostgresRepo:
    def save(self, order: dict) -> None:
        ...                  # INSERT INTO orders

class OrderService:          # high-level policy
    def __init__(self) -> None:
        self._repo = PostgresRepo()  # hard-wired
    def place(self, order: dict) -> None:
        self._repo.save(order)

# Testing place() now needs a real database,
# and switching storage means editing the
# business logic.
