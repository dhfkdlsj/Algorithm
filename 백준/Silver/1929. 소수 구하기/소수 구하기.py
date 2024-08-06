import sys
input = sys.stdin.readline

n, m = map(int, input().split())

def is_prime(num):
    if num <= 1:
        return False
    if num == 2:
        return True
    if num % 2 == 0:
        return False
    for i in range(3, int(num ** 0.5) + 1, 2):
        if num % i == 0:
            return False
    return True

for i in range(n, m + 1):
    if is_prime(i):
        print(i)
