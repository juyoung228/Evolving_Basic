#source https://www.youtube.com/watch?v=7C9RgOcvkvo&t=225s

def gcd(a, b):
  if a % b == 0:
    return b
  else:
    return gcd(b, a%b)

print(gcd(192, 162))

#6
