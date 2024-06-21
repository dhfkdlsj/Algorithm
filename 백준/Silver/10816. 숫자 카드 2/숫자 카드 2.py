N = int(input())
S = list(map(int,input().split()))
M = int(input())
T = list(map(int,input().split()))
temp = dict()

for i in S:
    if i in temp:
        temp[i] += 1
    else:
        temp[i] = 1

for i in T:
    if i in temp:
        print(temp[i],end=' ')
    else:
        print(0,end=' ')