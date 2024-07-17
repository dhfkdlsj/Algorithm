import sys
input = sys.stdin.readline

n,m = map(int,input().split())
S = list(map(int,input().split()))

left, right = 0, max(S)
result = 0
while left<= right:
    mid = (left+right) // 2
    total = 0
    for i in S:
        if i > mid:
            total += i - mid
    if total >= m:
        result = mid
        left = mid + 1
    else:
        right = mid - 1

print(result)