A = [list(map(int,input().split())) for _ in range(9)]
maxnum = 0
n = 0

for i in range(9):
    if max(A[i]) > maxnum:
        maxnum = max(A[i])
        n = i

print(maxnum)
print("{} {}".format(n+1,A[n].index(max(A[n]))+1))