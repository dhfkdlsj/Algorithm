import sys
input = sys.stdin.readline

n = int(input())
S = input().strip()

sum = 0
mod = 1234567891
r = 31

for i in range(n):
    sum = (sum + (ord(S[i]) - 96) * (r ** i) % mod) % mod

print(sum)
