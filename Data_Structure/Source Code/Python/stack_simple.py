#https://www.youtube.com/watch?v=7C9RgOcvkvo&t=225s
#함수를 연속적으로 호출하면 컴퓨터 메모리 내부의 스택 프레임에 쌓입니다. 
#그래서 스택을 사용해야 할 때 구현상 스택 라이브러리 대신에 재귀 함수를 이용하는 경우가 많습니다.
stack = []

stack.append[5]
stack.append[2]
stack.append[3]
stack.append[7]
stack.pop() #끝에서부터 삭제.
stack.append(1)
stack.append(4)
stack.pop()

print(stack)
#[5,2,3,1]
