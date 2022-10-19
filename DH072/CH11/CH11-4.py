print("암호만들기")

msg = input("암호화할 문자열을 입력해주세요")
key = input("암호화키 (숫자 1~26)를 입력하세요")

encode = ""

for a in msg:
    temp = ord(a) + int(key)
    a = chr(temp)
    encode = encode + a

print("평문", msg)
print("암호화: ", key)
print("암호문: ", encode)