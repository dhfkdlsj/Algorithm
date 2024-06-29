import sys
import math

input = sys.stdin.readline

N = int(input())
answer = ''

for _ in range(N):
    A, B = map(int, input().split())
    gcd = math.gcd(A, B)
    lcm = (A * B) // gcd
    answer += str(lcm) + '\n'

print(answer)
