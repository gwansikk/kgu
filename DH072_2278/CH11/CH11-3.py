
a = input("승리팀: ")
b = input("패배팀: ")
c = input("스코어: ")
d = int(input("경기유형(1, 2, 3): "))

if d == 1:
    d = "불꽃 튀는"
elif d == 2:
    d = "단조로운"
elif d == 3:
    d = "일방적인"

e = input("MVP 선수 이름: ")

print(f"오늘 {a}와 {b}팀의 {d} 경기가 있었습니다. 승리팀은 {a}이며 {c} 스코어로 {b}꺽고 승리를 가져가게 되었습니다. MVP는 {e}선수가 되겠습니다.")