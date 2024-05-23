N = int(input())
X = 1
count = 1
i = 1

while N > X:
        X += (i*6)
        count += 1
        i += 1

print(count)