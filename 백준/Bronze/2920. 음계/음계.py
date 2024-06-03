S = list(map(int,input().split()))
A = S[::-1]

count = 0
dcount = 0
for i in range(8):
    if i+1 == S[i]:
        count += 1
    elif i+1 == A[i]:
        dcount += 1

if count == 8:
    print("ascending")
elif dcount == 8:
    print("descending")
else:
    print("mixed")