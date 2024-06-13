n,k = map(int,input().split())
S = list(map(int,input().split()))

for i in range(k):
    x = max(S)
    S.remove(max(S))

print(x)