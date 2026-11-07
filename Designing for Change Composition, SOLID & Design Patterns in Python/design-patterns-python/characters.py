"""Shared game characters (from the repo's Adapter example)."""


class BadGuy:
    def drive(self) -> int: return 30
    def shoot(self) -> int: return 50


class Moose:
    def run(self) -> int: return 5
    def charge(self) -> int: return 10
