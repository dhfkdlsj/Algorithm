N = int(input())
sum = 0
asum = 5000

if N % 5 == 0:
    asum = int(N/5)
else:
    x = int(N/5)
    for i in range(x,-1,-1):
        if (N-(5*i))%3 == 0:
            sum = i+((N-(5*i))/3)
            if sum < asum:
                asum = sum
if asum == 5000:
    asum = -1
print(int(asum))