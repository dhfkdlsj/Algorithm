import sys
input = sys.stdin.readline

n = int(input())
S = list(map(str,input()))

sum = 0

for i in range(len(S)-1):
    sum += ((ord(S[i])-96) * 31**i) % 1234567891

print(sum)