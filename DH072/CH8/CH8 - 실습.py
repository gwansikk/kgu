import turtle as t
import random


swidth, sheight = 500, 500
myTurtle, tX, tY, tColor, tSize, tShape = [None] * 6
shapeList= [] 
playerTurtles = [] 


t.shape('turtle')
t.setup(width = swidth + 50, height = sheight + 50)
t.screensize(swidth, sheight)
shapeList = t.getshapes() 


for i in range(1, 100) :
    random.shuffle(shapeList)
    myTurtle = t.Turtle(shapeList[0])
    tX = random.randrange(-swidth / 2, swidth / 2)
    tY = random.randrange(-sheight / 2, sheight / 2)
    r = random.random(); g = random.random(); b = random.random()
    tSize = random.randrange(1, 3)
    playerTurtles.append([myTurtle, tX, tY, tSize, r, g, b]) 

for tList in playerTurtles :
    myTurtle = tList[0]
    myTurtle.color((tList[4],tList[5],tList[6]))
    myTurtle.pencolor((tList[4],tList[5],tList[6]))
    myTurtle.turtlesize(tList[3])
    myTurtle.goto(tList[1], tList[2])

t.done()
