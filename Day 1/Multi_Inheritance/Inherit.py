class Cycle(object):
  def __init__(self,a):
    self.a = a
    print("Im from Grandfather's, Im ",a)


# Bicycle inherits Cycle(contains: class Cycle[Inherited],
#                                         variable a[from Cycle],   using a constructor call Cycle.__init__(self, a)
#                                         variable b[from own])     self property/variable

class Bicycle(Cycle):
  def __init__(self,a,b):
    Cycle.__init__(self,a)
    self.b = b
    print("Im from father's, Im ",b)

# GearBicycle inherits Bicycle(contains: class Cycle    [Inherited],
#                                         variable a, b [from Bicycle],   using a constructor call Biycle.__init__(self, a, b)
#                                         variable c    [from own])          self property
class GearBicycle(Bicycle):  
  def __init__(self,a,b,c):
    Bicycle.__init__(self,a,b)
    self.c = c
    print("Im from son's / present, Im ",c)
  def display(self):         #Now, this GearBicylce is aware of all a,b,c
    print(self.a)
    print(self.b)
    print(self.c)



# Above all are created, but not initiated till this line 30
g = GearBicycle(1,2,3)
g.display()
