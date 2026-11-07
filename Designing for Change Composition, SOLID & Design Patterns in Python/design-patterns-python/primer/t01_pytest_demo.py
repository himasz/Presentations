# test_demo.py: pytest finds test_*.py files
import pytest
from d1_adapter import Moose, MooseAdapter

def test_adapter():                # test_* functions
    a = MooseAdapter(Moose())
    assert a.chase() == 5          # plain assert

def test_missing_key_raises():
    with pytest.raises(KeyError):  # expect an error
        {}["missing"]

@pytest.mark.parametrize("n, sq", [(2, 4), (3, 9)])
def test_square(n, sq):            # runs twice
    assert n * n == sq
# $ pytest -q test_demo.py
#! 4 passed
