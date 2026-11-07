from e3_command_parts import AddText, Command, Document
# --- slide ---
class Editor:                       # the invoker
    def __init__(self) -> None:
        self.history: list[Command] = []
    def run(self, cmd: Command) -> None:
        cmd.execute()
        self.history.append(cmd)
    def undo(self) -> None:
        self.history.pop().undo()

doc, editor = Document("Patterns"), Editor()
editor.run(AddText(doc, " are fun"))
doc.text        # 'Patterns are fun'
editor.undo()
doc.text        # 'Patterns'
