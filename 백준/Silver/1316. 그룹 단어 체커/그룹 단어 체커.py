T = int(input())
count = 0

for test_case in range(T):
    A = [0] * 26
    x = 0
    word = input()
    for i in range(len(word)-1):
        if word[i]!=word[i+1]:
            if A[ord(word[i])-97] == 0:
                A[ord(word[i])-97] = 1
            else:
                count -= 1
                x = 1
                break
    if A[ord(word[-1])-97] == 0:
        A[ord(word[-1]) - 97] = 1
    else:
        if x == 0:
            count -= 1
    count += 1
print(count)
