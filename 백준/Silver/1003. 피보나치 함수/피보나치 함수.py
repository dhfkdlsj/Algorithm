import sys
input = sys.stdin.readline

def fibonacci(n,i):
    if(n == 0):
        zeroArr[i] += 1
    elif(n == 1):
        oneArr[i] += 1
    else:
        zeroArr[i] += zeroArr[n-1]+zeroArr[n-2]
        oneArr[i] += oneArr[n-1]+oneArr[n-2]

T = int(input())
answer = ''
zeroArr = [0] * 41
oneArr = [0] * 41

for i in range(41):
    fibonacci(i,i)

for _ in range(T):
    n = int(input())
    answer += str(zeroArr[n]) + ' ' + str(oneArr[n]) + '\n'

print(answer)