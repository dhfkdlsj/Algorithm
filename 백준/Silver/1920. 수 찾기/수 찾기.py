import sys
input = sys.stdin.readline

N = int(input())
S = list(map(int,input().split()))
M = int(input())
A = list(map(int,input().split()))
S.sort()

for i in A:
  start = 0
  end = N - 1
  x = False
  while(start<=end):
    mid = (start + end) // 2
    if S[mid] > i:
      end = mid - 1
    elif S[mid] < i:
      start = mid +1
    else:
      x = True
      break
  if(not x):
    print(0)
  else:
    print(1)