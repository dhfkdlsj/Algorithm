S = []
for _ in range(5):
    S.append(int(input()))
S.sort()
print(int(sum(S)/5))
print(S[2])