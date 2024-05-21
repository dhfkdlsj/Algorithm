S = input().upper()
A = [0] * 26
count = 0

for i in S:
    A[ord(i)-65] += 1

for i in A:
    if i == max(A):
        count += 1
if count > 1:
    print("?")
else:
    print(chr(A.index(max(A))+65))