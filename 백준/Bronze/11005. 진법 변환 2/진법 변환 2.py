N, B = map(int,input().split())
s = []
x = N
i = 0
answer =''

while x >= B:
    x,i = divmod(x,B)
    s.append(i)
s.append(x)

for j in s[::-1]:
    if j > 9:
        answer += chr(j+55)
    else:
        answer += str(j)

print(answer)