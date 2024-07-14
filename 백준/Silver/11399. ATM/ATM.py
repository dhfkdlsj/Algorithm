import sys
input = sys.stdin.readline

n = int(input())
S = list(map(int,input().split()))

S.sort()

for i in range(1,n):
    S[i] = S[i-1]+S[i]

print(sum(S))