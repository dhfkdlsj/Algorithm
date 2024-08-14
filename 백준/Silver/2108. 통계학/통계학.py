import sys
from collections import Counter

input = sys.stdin.readline

n = int(input())
S = []

for _ in range(n):
    S.append(int(input()))

# 산술평균: 소수점 첫째 자리에서 반올림
mean = round(sum(S) / n)

# 중앙값: 정렬 후 가운데 값
S.sort()
median = S[n // 2]

# 최빈값: 여러 개 있을 경우 두 번째로 작은 값
counter = Counter(S)
modes = counter.most_common()
max_frequency = modes[0][1]

mode_candidates = []
for number, freq in modes:
    if freq == max_frequency:
        mode_candidates.append(number)

# 최빈값이 여러 개라면 두 번째로 작은 값 선택
mode_candidates.sort()
mode = mode_candidates[1] if len(mode_candidates) > 1 else mode_candidates[0]

# 범위: 최댓값 - 최솟값
range_value = max(S) - min(S)

print(mean)
print(median)
print(mode)
print(range_value)
