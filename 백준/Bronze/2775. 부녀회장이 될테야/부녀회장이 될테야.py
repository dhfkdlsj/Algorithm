import sys
input = sys.stdin.readline

T = int(input())
answer =''
for _ in range(T):
    k = int(input())
    n = int(input())

    S = [[0 for _ in range(n)] for _ in range(k+1)]

    for i in range(n):
        S[0][i] = i+1
    
    for i in range(1,k+1):
        for j in range(n):
            S[i][j] = sum(S[i-1][0:j+1])
    answer += str(S[k][n-1]) + '\n'

print(answer)