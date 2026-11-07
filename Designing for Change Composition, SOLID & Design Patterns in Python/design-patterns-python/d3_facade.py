from d3_facade_subsystem import Confusing, Overdone
# --- slide ---
class BetterApi:                    # the facade
    def __init__(self, confusing=None,
                 overdone=None):
        self._c = confusing or Confusing()
        self._o = overdone or Overdone("foo")

    def add_three_numbers(self, a, b, c):
        return self._c.execute(a, b, c)

    def add_then_multiply(self, *nums, factor):
        calls = {1: self._o.do_something,
                 2: self._o.do_something_else,
                 3: self._o.do_something_again}
        return calls[len(nums)](*nums, factor)

api = BetterApi()
api.add_then_multiply(4, 3, factor=5)   # 35
