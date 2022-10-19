num = int(input(" *** 숫자를 입력하세요: "))

def isPrime(x) :
    for i in range(2, x):
        if x % i == 0:
            return False 
    return True

if (isPrime(num)) :
    print("%d은 소수입니다." %num)
else :
    print("%d은 소수가 아닙니다." %num)