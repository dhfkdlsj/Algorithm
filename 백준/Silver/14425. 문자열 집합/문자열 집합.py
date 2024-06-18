import sys
input = sys.stdin.readline

N, M = map(int,input().split())
S = [input() for _ in range(N)]
A = [input() for _ in range(M)]
S.sort()
count = 0

for i in A:
  start = 0
  end = N-1
  while(start<=end):
    mid = (start+end)//2
    if S[mid]<i:
      start = mid + 1
    elif S[mid]>i:
      end = mid -1
    else:
      count += 1
      break
      
print(count)