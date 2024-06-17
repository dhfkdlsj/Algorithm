import sys
input = sys.stdin.readline

N = int(input())
S = list(map(int,input().split()))
M = int(input())
A = list(map(int,input().split()))
S.sort()

for i in range(M):
  start = 0
  end = N - 1
  count = 0
  while(start < end):
    mid = (start + end) // 2
    if A[i] > S[mid]:
      start = mid + 1
    elif A[i] < S[mid]:
      end = mid - 1
    else:
      print(1, end=" ")
      count = 1
      break
  if count == 1:
    continue
  elif S[end] != A[i]:
    print(0, end=" ")
  else:
    print(1, end=" ")