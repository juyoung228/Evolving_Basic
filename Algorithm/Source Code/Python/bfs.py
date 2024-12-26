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
