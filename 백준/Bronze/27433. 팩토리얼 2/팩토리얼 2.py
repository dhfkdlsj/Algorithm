import sys
input = sys.stdin.readline

n = int(input())

def dfs(n):
    if n == 1 or n == 0:
        return 1
    else:
        return n * dfs(n-1)

print(dfs(n))