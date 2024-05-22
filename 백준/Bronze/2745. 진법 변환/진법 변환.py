N, B = map(str,input().split())
num = 0
B = int(B)

for i in range(len(N)):
    if ord(N[i]) > 57:
        num += (ord(N[i])-55)*(B**(len(N)-i-1))
    else:
        num += (int(N[i]))*(B**(len(N)-i-1))

print(num)