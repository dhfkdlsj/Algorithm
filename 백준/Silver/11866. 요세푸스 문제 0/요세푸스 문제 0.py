import sys
input = sys.stdin.readline
answer = '<'

N,M = map(int,input().split())
S = []
for i in range(1,N+1):
    S.append(i)

X = M-1
answer += str(S[X])
del S[X]
for i in range(N-1):
    X += (M-1)
    if(X >= len(S)):
        X %= len(S)
        answer += ', ' + str(S[X])
        del S[X]
    else:
        answer += ', ' + str(S[X])
        del S[X]

answer += '>'
print(answer)