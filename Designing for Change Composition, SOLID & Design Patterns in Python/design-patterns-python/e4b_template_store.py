from e4a_template_skeleton import PizzaStore
# --- slide ---
class NewYorkStylePizzaStore(PizzaStore):
    def take_order(self) -> str:
        return "1 large, thin crust"
    def make_pizza(self) -> str:
        return "hand-tossed dough"
    def cook_pizza(self) -> str:
        return "deck oven, 6 min"

store = NewYorkStylePizzaStore()
for step in store.create_pizza_for_delivery():
    print(step)
# -> 1 large, thin crust
#    paid
#    hand-tossed dough
#    deck oven, 6 min
#    delivered
