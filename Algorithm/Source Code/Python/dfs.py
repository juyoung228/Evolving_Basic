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

# 단일경로 찾기 문제
def find_path(graph, start, end, path=[]):
    # 현재 노드를 경로에 추가
    path = path + [start]
    
    # 시작 노드가 끝 노드에 도달하면 경로 반환
    if start == end:
        return path
    
    # 경로를 찾을 수 없으면 None 반환
    if start not in graph:
        return None
    
    # 모든 인접 노드를 순회
    for neighbor in graph[start]:
        if neighbor not in path:  # 이미 방문한 노드는 제외
            new_path = find_path(graph, neighbor, end, path)
            if new_path:  # 유효한 경로를 찾으면 반환
                return new_path
    
    return None  # 경로를 찾지 못하면 None 반환

# 그래프 (인접 리스트)
graph = {
    0: [1, 2],
    1: [0, 3, 4],
    2: [0, 5, 6],
    3: [1],
    4: [1],
    5: [2],
    6: [2]
}

# 시작점과 끝점을 설정
start_node = 0
end_node = 6

# 경로 탐색
path = find_path(graph, start_node, end_node)
print("단일 경로:", path)


#모든 경로 찾기 문제
def find_all_paths(graph, start, end, path=[]):
    # 현재 노드를 경로에 추가
    path = path + [start]
    
    # 시작 노드가 끝 노드에 도달하면 현재 경로 반환
    if start == end:
        return [path]
    
    # 시작 노드가 그래프에 없으면 빈 리스트 반환
    if start not in graph:
        return []
    
    paths = []  # 모든 경로를 저장할 리스트
    for neighbor in graph[start]:
        if neighbor not in path:  # 이미 방문한 노드는 제외
            new_paths = find_all_paths(graph, neighbor, end, path)
            for new_path in new_paths:
                paths.append(new_path)
    
    return paths

# 그래프 (인접 리스트)
graph = {
    0: [1, 2],
    1: [0, 3, 4],
    2: [0, 5, 6],
    3: [1],
    4: [1],
    5: [2],
    6: [2]
}

# 시작점과 끝점을 설정
start_node = 0
end_node = 6

# 모든 경로 탐색
all_paths = find_all_paths(graph, start_node, end_node)
print("모든 경로:")
for path in all_paths:
    print(path)
