A = [list(map(str,input())) for _ in range(5)]
maxlen = 0

for i in range(5):
    if len(A[i]) > maxlen:
        maxlen = len(A[i])

for i in range(5):
    if len(A[i]) < maxlen:
        for j in range(maxlen-len(A[i])):
            A[i].append(None)

for i in range(maxlen):
    for j in range(5):
        if A[j][i] != None:
            print(A[j][i],end='')