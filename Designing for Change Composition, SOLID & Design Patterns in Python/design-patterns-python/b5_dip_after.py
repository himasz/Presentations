from typing import Protocol
from b5_dip_before import PostgresRepo
# --- slide ---
class OrderRepository(Protocol):    # abstraction
    def save(self, order: dict) -> None: ...

class OrderService:
    def __init__(self, repo: OrderRepository):
        self._repo = repo           # injected
    def place(self, order: dict) -> None:
        self._repo.save(order)

class InMemoryRepo:                 # test double
    def __init__(self) -> None:
        self.rows: list[dict] = []
    def save(self, order: dict) -> None:
        self.rows.append(order)

OrderService(InMemoryRepo())        # in tests
OrderService(PostgresRepo())        # in production
