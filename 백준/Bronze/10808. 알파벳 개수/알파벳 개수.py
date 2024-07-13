import sys
input = sys.stdin.readline

S = [0] * 26

X = input().strip()

for i in X:
    S[ord(i) - ord('a')] += 1

print(' '.join(map(str, S)))