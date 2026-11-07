from functools import cache

class Settings:
    def __init__(self) -> None:
        self.some_value = 0

@cache                        # built on first call
def get_settings() -> Settings:
    return Settings()

assert get_settings() is get_settings()

# Simplest of all: a module is imported once.
#   settings.py:   some_value = 0
#   elsewhere:     import settings
