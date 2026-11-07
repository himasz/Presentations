# Before the talk
python3 --version           # 3.10 or newer
pytest -q                   # 27 passed

# Demo 1: the inheritance trap
python3 a1_inheritance_trap.py
# Up, Up, and Away!

# Demo 2: Strategy, live in the REPL
python3 -i e1b_strategy_hero.py
>>> spidey.do_hero_stuff()        # 'Up, Up, and Away!'
>>> spidey.change_super_power(WeaveWeb())
>>> spidey.do_hero_stuff()
'Catches Thieves Like Flies!'

# Demo 3: stacked decorators
python3 -i d2b_decorator_stack.py
>>> car.drive, car.attack, car.defend   # (100, 90, 170)

# Demo 4: mypy catches the LSP bug
#   uncomment the retreat(...) line, then:
mypy b3_lsp_after.py                   # 1 error
