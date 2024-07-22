import sys
input = sys.stdin.readline

S = list(map(int,input().split()))

S.sort()

print(*S)