import sys
input = sys.stdin.readline

n = int(input())
S = [int(input()) for _ in range(n)]

if n == 1:
    print(S[0])
else:
    dp = [0] * n
    dp[0] = S[0]
    dp[1] = S[0] + S[1]

    if n > 2:
        dp[2] = max(S[1] + S[2], S[0] + S[2])

    for i in range(3, n):
        dp[i] = max(dp[i-2] + S[i], dp[i-3] + S[i-1] + S[i])

    print(dp[-1])