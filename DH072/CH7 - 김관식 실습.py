import turtle as t
import random


t.shape('turtle')
t.setup(480, 480)
t.pensize(4)

speed = 5


for i in range(80) :
    t.pencolor(( random.random(),  random.random(),  random.random()))

    t.forward(speed)
    speed += 1 
    t.left(30) 

t.mainloop()
