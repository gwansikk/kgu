a = 5

while a:
    order = input("명령: ")

    if "날씨" in order:
        print("오늘 날씨는 맑습니다.")
    elif "기온" in order:
        print("오늘의 기온은 20도 입니다.")
    elif "학식 메뉴" in order:
        print("오늘 학식 메뉴는 불고기입니다.")
    elif "심심해" in order:
        print("저도 심심합니다.")
    elif "시리야" in order:
        print("저는 시리가 아닙니다.")
    else:
        print("명령이 없습니다.")
    a -= 1