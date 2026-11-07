from typing import Protocol
# --- slide ---
class Command(Protocol):
    def execute(self) -> None: ...
    def undo(self) -> None: ...

class Document:                     # the receiver
    def __init__(self, text: str = "") -> None:
        self.text = text

class AddText:               # request as an object
    def __init__(self, doc: Document, text: str):
        self.doc, self.text = doc, text
    def execute(self) -> None:
        self.doc.text += self.text
    def undo(self) -> None:
        d = self.doc
        d.text = d.text.removesuffix(self.text)
