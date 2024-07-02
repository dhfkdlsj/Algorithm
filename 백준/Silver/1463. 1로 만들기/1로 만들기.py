N = int(input())
cnt = 0
S =[0,0,1,1]

for i in range(4,N+1):
    if(i%3==0):
        if(i%2==0):
            S.append(min(S[i-1]+1,S[i//2]+1,S[i//3]+1))
        else:
            S.append(min(S[i-1]+1,S[i//3]+1))
    elif(i%2==0):
        S.append(min(S[i-1]+1,S[i//2]+1))
    else:
        S.append(S[i-1]+1)
    
print(S[N])