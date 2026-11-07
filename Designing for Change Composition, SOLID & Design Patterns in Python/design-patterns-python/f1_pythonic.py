"""Pythonic shortcuts: when a language feature replaces the pattern."""
import weakref
from functools import partial
from typing import Callable


# Strategy -> just pass a function
def fly() -> str:
    return "Up, Up, and Away!"


class Hero:
    def __init__(self, power: Callable[[], str] = lambda: "Run away"):
        self.power = power

    def do_hero_stuff(self) -> str:
        return self.power()


# Command (no undo needed) -> any callable
log: list[str] = []
jobs = [partial(log.append, "a"), partial(log.append, "b")]
for job in jobs:
    job()


# Observer -> callbacks; WeakSet forgets observers that were garbage-collected
class Subject:
    def __init__(self) -> None:
        self.observers: weakref.WeakSet[object] = weakref.WeakSet()
