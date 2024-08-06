import sys
input = sys.stdin.readline

n = int(input())

def fac(n):
    if(n == 0):
        return 1
    return n * fac(n-1)

x = str(fac(n))

count = 0

for i in range(len(x)-1,-1,-1):
    if(x[i]!= '0'):
        break
    count += 1

print(count)