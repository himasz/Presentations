# 1. Check the version: needs 3.10 or newer
python3 --version

# 2. A virtual environment = project-local packages
python3 -m venv .venv
source .venv/bin/activate
# (Windows: .venv\Scripts\activate)

# 3. Install the two tools the lecture uses
pip install pytest mypy

# 4. Run things
python3 a1_inheritance_trap.py    # run a file
python3 -i e1b_strategy_hero.py   # then a REPL
pytest -q                         # all tests
mypy *.py                         # type-check all
