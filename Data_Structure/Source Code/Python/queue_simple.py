#source https://www.youtube.com/watch?v=7C9RgOcvkvo&t=225s
#list로 구현 가능하나 시간 복잡도가 더 높아지므 deque 라이브러리 사용
#https://wellsw.tistory.com/122 
from collections import deque

queue = deque()

queue.append(5)
queue.append(2)
queue.append(3)
queue.append(7)
queue.popleft()
queue.append(1)
queue.append(4)
queue.popleft()

print(queue) #먼저 들어온 순서대로 출력
queue.reverse() #역순으로 바꾸기
print(queue) #나중에 들어온 원소부 출력

