class fraction(object):
    def __init__(self,numerator,denominator):
        self.numerator=int(numerator)
        self.denominator=int(denominator)
        self.to_lowest_terms()
    #default no denominator is set one
    def __int__(self,numerator):
        self.numerator=numerator
        self.denominator=1
        self.to_lowest_terms()
    #check in fraction is in lowest terms
    def in_lowest_terms(self):
        t=self.gcd()
        if t!=1:
            return False
        else:
            return True
    #put fraction in lowest term
    def to_lowest_terms(self):
        if self.in_lowest_terms():
            return
        else:
            t=self.gcd()
            self.numerator/=t
            self.denominator/=t
            self.denominator=int(self.denominator)
            self.numerator=int(self.numerator)
    #to string to print fractions
    def __str__(self):
        if self.denominator!=1:
            return str(self.numerator) +"/"+ str(self.denominator)
        else:
             return str(self.numerator)
    #fraction add function
    def __add__(self, other):
        if self.denominator!=other.denominator:
            n= self.numerator*other.denominator
            d= self.denominator*other.denominator
            n+=other.numerator*self.denominator
        result=fraction(n,d)
        result.to_lowest_terms()
        return result
    def __sub__(self, other):
        if self.denominator!=other.denominator:
            n= self.numerator*other.denominator
            d= self.denominator*other.denominator
            n-=other.numerator*self.denominator
        result=fraction(n,d)
        result.to_lowest_terms()
        return result
    def __mul__(self, other):
        n=self.numerator*other.numerator
        d=self.denominator*other.denominator
        result=fraction(n,d)
        result.to_lowest_terms()
        return result
    def __truediv__(self, other):
         n=self.numerator*other.denominator
         d=self.denominator*other.numerator
         result=fraction(n,d)
         result.to_lowest_terms()
         return result
    def __floordiv__(self, other):
        self.__truediv__(other)
    # can use ==
    def __eq__(self, other):
        if self.numerator==other.numerator and self.denominator==other.denominator:
            return True
        return False
    def __pow__(self, power, modulo=None):
       n= self.numerator**power
       d=self.denominator**power
       result=fraction(n,d)
       return result


    def gcd(self):
        r=self.numerator%self.denominator
        a=self.numerator
        b=self.denominator
        while r!=0:
            a=self.denominator
            b=r
            r=a%b
        return b
    def to_decimal(self):
        return self.numerator/self.denominator
    def to_percent(self):
        return str(int(100*self.to_decimal()))+"%"
f = fraction(6,5)
g=fraction(7,8)
print("f: " + str(f))
print("g: " + str(g))
print(f/g)

