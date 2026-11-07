from e2_observer_subject import GameResult, SportsAggregator
# --- slide ---
class NewsPaper:
    def __init__(self) -> None:
        self.results: list[GameResult] = []
    def update(self, result: GameResult) -> None:
        self.results.append(result)

class RadioStation:
    def update(self, result: GameResult) -> None:
        print(f"Breaking: {result.winner}")

hub = SportsAggregator()
paper, radio = NewsPaper(), RadioStation()
hub.register(paper); hub.register(radio)
hub.add_game_result(
    GameResult("Lions", "Eagles", "2-1"))
# radio prints 'Breaking: Lions'
# Repo's weak-reference variant, in Python:
#   self._observers = weakref.WeakSet()
