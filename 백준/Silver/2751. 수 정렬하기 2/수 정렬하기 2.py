import sys
input = sys.stdin.readline

N = int(input())
S = []

for i in range(N):
    S.append(int(input()))
S.sort()

print(*S,sep='\n')