import sys
input = sys.stdin.readline

n = int(input())
A = dict()

for i in range(n):
  a,b = map(str,input().split())
  if b == 'enter':
    A[a] = b
  else:
    del A[a]

A = sorted(A.keys(),reverse=True)

print(*A,sep ="\n")