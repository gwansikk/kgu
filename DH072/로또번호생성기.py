import random

def numberGenerator(n):
    for _ in range(n):
        lotto = random.sample(range(1, 46), 6)
        lotto.sort()
        print("자동번호--> ", lotto)


print("** 로또 번호 생성을 시작합니다. **")
inputLoopNum = int(input("몇 번을 뽑을까요?: "))

numberGenerator(inputLoopNum)
