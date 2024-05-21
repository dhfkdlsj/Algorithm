S = ['ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']
word = input()
second = 0

for i in word:
    for j in range(len(S)):
        if i in S[j]:
            second += j+3
            break

print(second)