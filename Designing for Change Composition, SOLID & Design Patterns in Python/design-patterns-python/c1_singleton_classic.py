import threading

class Settings:
    _instance: "Settings | None" = None
    _lock = threading.Lock()
    some_value: int

    def __new__(cls) -> "Settings":
        if cls._instance is None:      # fast path
            with cls._lock:            # serialize
                if cls._instance is None:  # again
                    obj = super().__new__(cls)
                    obj.some_value = 0
                    cls._instance = obj
        return cls._instance

assert Settings() is Settings()
