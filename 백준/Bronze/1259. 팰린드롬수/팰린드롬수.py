import sys
input = sys.stdin.readline

answer =''

while True:
    v = True
    S = list(map(str,input()))
    S.pop()
    if(S[0] == '0' and len(S) == 1):
        print(answer)
        break
    X = S[::-1]
    for i in range(len(S)):
        if S[i] != X[i]:
            v = False

    if v:
        answer+= 'yes' + '\n'
    else:
        answer += 'no' + '\n'