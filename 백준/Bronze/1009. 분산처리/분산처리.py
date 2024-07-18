import sys
input = sys.stdin.readline

testCase = int(input())
results = []

for _ in range(testCase):
    a,b = map(int,input().split())

    last_digit = pow(a, b, 10)
    if last_digit == 0:
        last_digit = 10
    results.append(str(last_digit))

print('\n'.join(results))
