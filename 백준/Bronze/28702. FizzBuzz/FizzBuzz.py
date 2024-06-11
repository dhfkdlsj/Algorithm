A = input()
B = input()
C = input()
S = ['1','2','3','4','5','6','7','8','9','0']

if A[0] in S:
    x = int(A)+3
elif B[0] in S:
    x = int(B)+2
elif C[0] in S:
    x = int(C)+1


if x % 3 == 0 and x % 5 == 0:
    print("FizzBuzz")
elif x % 3 == 0:
    print("Fizz")
elif x % 5 == 0:
    print("Buzz")
else:
    print(x)