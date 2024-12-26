#Stack으로 구현

def dfs_stack(graph, start):
    # 방문 여부를 확인하기 위한 리스트
    visited = [False] * len(graph)
    # 스택을 생성하고 시작 노드를 추가
    stack = [start]

    while stack:
        # 스택의 마지막 노드를 꺼냄
        node = stack.pop()

        # 방문하지 않았다면 처리
        if not visited[node]:
            visited[node] = True
            print(node, end=' ')  # 방문한 노드를 출력 (필요에 따라 변경 가능)

            # 스택에 인접 노드를 추가 (거꾸로 추가해서 작은 노드부터 방문)
            for neighbor in reversed(graph[node]):
                if not visited[neighbor]:
                    stack.append(neighbor)

# 그래프 (인접 리스트)
graph = [
    [1, 2],    # 0번 노드와 연결된 노드들
    [0, 3, 4], # 1번 노드와 연결된 노드들
    [0, 5, 6], # 2번 노드와 연결된 노드들
    [1],       # 3번 노드와 연결된 노드들
    [1],       # 4번 노드와 연결된 노드들
    [2],       # 5번 노드와 연결된 노드들
    [2]        # 6번 노드와 연결된 노드들
]


# 재귀로 구현
dfs_stack(graph, 0)


def dfs_recursive(graph, node, visited):
    # 현재 노드를 방문 처리
    visited[node] = True
    print(node, end=' ')  # 방문한 노드를 출력 (필요에 따라 변경 가능)

    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for neighbor in graph[node]:
        if not visited[neighbor]:
            dfs_recursive(graph, neighbor, visited)

# 그래프 (인접 리스트)
graph = [
    [1, 2],    # 0번 노드와 연결된 노드들
    [0, 3, 4], # 1번 노드와 연결된 노드들
    [0, 5, 6], # 2번 노드와 연결된 노드들
    [1],       # 3번 노드와 연결된 노드들
    [1],       # 4번 노드와 연결된 노드들
    [2],       # 5번 노드와 연결된 노드들
    [2]        # 6번 노드와 연결된 노드들
]

# 방문 여부 리스트
visited = [False] * len(graph)

# DFS 시작
dfs_recursive(graph, 0, visited)


# 2D 배열에서 연결된 섬의 개수 구하기
grid = [
    [1, 1, 0, 0],
    [1, 0, 0, 1],
    [0, 0, 1, 1],
    [0, 1, 1, 0]
]

def dfs_islands(x, y):
    if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] == 0:
        return
    grid[x][y] = 0  # 방문 처리
    # 상하좌우 탐색
    dfs_islands(x-1, y)
    dfs_islands(x+1, y)
    dfs_islands(x, y-1)
    dfs_islands(x, y+1)

num_islands = 0
for i in range(len(grid)):
    for j in range(len(grid[0])):
        if grid[i][j] == 1:
            dfs_islands(i, j)
            num_islands += 1

print("섬의 개수:", num_islands)


