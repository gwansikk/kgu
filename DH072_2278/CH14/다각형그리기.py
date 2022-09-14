import turtle
from tkinter.simpledialog import * 

turtle.title('다각형그리기')
turtle.shape('turtle')
turtle.screensize(800, 800)

inLoopNumber = int(askstring('다각형그리기', '다각형그리기, n을 입력해주세요!'))

for i in range(inLoopNumber):
	turtle.forward(50)
	turtle.right(360 / inLoopNumber)
	
turtle.done()
