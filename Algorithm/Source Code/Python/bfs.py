#kt.goorm.io
#Breadth-First Search
#특징: 시작 노드에서 가까운 노드부터 차례대로 탐색, 모든 인접 노드를 탐색한 후 다음 깊이로 이동
#자료구조: Queue를 사용하여 구현
#시간복잡도: O(V + E) (V는 정점의 수, E는 간선의 수)
#장점: 최단 경로를 보장하며, 주로 가중치가 없는 그래프에서 최단 경로를 찾는 데 사용
#단점: 큐를 사용하기 때문에 메모리 사용량이 많아질 수 있음.

from collections import deque

def bfs(graph, start):
    # 방문 여부를 확인하기 위한 리스트
    visited = [False] * len(graph)
    
    # BFS를 위한 큐 생성
    queue = deque([start])
    
    # 시작 노드를 방문 처리
    visited[start] = True

    # BFS 결과를 저장할 리스트
    result = []
    
    while queue:
        # 큐에서 노드를 하나 꺼냄
        node = queue.popleft()
        result.append(node)
        
        # 인접한 노드들을 확인
        for neighbor in graph[node]:
            if not visited[neighbor]:
                queue.append(neighbor)
                visited[neighbor] = True
    
    return result

# 그래프 (인접 리스트)
# 예: 0번 노드에 연결된 노드는 [1, 2], 1번 노드에 연결된 노드는 [0, 3, 4], ...
graph = [
    [1, 2],     # 0번 노드와 연결된 노드들
    [0, 3, 4],  # 1번 노드와 연결된 노드들
    [0, 5, 6],  # 2번 노드와 연결된 노드들
    [1],        # 3번 노드와 연결된 노드들
    [1],        # 4번 노드와 연결된 노드들
    [2],        # 5번 노드와 연결된 노드들
    [2]         # 6번 노드와 연결된 노드들
]

# BFS 실행
start_node = 0
result = bfs(graph, start_node)
print("BFS 탐색 결과:", result)


#최단 경로 구하기, 거리 정보 추가로 기록
def bfs_shortest_path(graph, start, target):
    visited = [False] * len(graph)
    queue = deque([(start, 0)])  # 큐에 (노드, 거리) 저장
    visited[start] = True

    while queue:
        node, distance = queue.popleft()

        # 목표 노드에 도달하면 거리 반환
        if node == target:
            return distance

        # 인접 노드 확인
        for neighbor in graph[node]:
            if not visited[neighbor]:
                queue.append((neighbor, distance + 1))
                visited[neighbor] = True

    return -1  # 목표 노드에 도달할 수 없는 경우

# 그래프
graph = [
    [1, 2],
    [0, 3],
    [0, 3],
    [1, 2, 4],
    [3]
]

# 최단 거리 계산
start_node = 0
target_node = 4
shortest_distance = bfs_shortest_path(graph, start_node, target_node)
print("최단 거리:", shortest_distance)
