S = [[0 for _ in range(100)]for _ in range(100)]
sum = 0
T = int(input())

for i in range(T):
    n,m = map(int,input().split())
    for j in range(n,n+10):
        for k in range(m,m+10):
            S[j][k] = 1

for i in range(100):
    sum += S[i].count(1)

print(sum)