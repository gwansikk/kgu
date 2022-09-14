import turtle
import random

class shape:
    myTurtle = None
    cx, cy = 0, 0

    def __init__(self):
        self.myTurtle = turtle.Turtle('Turtle')

    def setPen(self):
        r = random.random()
        g = random.random()
        b = random.random()

        self.myTurtle.pencolor((r, g, b))
        pSize = random.randrange(1, 10)
        self.myTurtle.pensize(pSize)
