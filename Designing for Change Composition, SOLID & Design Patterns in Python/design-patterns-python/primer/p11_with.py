import threading

# Opens the file and always closes it, even on error
with open("report.html", "w") as f:
    f.write("<h1>15.50</h1>")

with open("report.html") as f:    # "r" by default
    print(f.read())               #> <h1>15.50</h1>

lock = threading.Lock()
with lock:                        # acquire/release
    print("one at a time")        #> one at a time
print(lock.locked())              #> False
