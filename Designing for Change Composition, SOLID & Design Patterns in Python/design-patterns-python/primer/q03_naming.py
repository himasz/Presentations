class Account:
    MAX_BALANCE = 1_000_000      # CONSTANT_CASE

    def __init__(self, owner: str) -> None:
        self.owner = owner       # public
        self._balance = 0        # internal: a hint
        self.__pin = 1234        # name-mangled

    def deposit_money(self, amount: int) -> None:
        self._balance += amount  # snake_case

acct = Account("ada")
acct.deposit_money(50)
print(acct._balance)             #> 50
print(acct._Account__pin)        #> 1234
# acct.__pin  -> AttributeError
