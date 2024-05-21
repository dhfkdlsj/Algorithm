S = input()
A = ['c=','c-','dz=','d-','lj','nj','s=','z=']
leng = len(S)

for i in range(len(S)-1):
    if (S[i]+S[i+1]) in A:
        if S[i] == 'z' and S[i+1] == '=':
            if S[i-1] == 'd':
                continue
            else:
                leng -= 1
        else:
            leng -= 1
for i in range(len(S)-2):
    if (S[i]+S[i+1]+S[i+2]) in A:
        leng -= 2

print(leng)