class Node:
    def __init__(self, item):
        self.val = item
        self.next = None

class LinkedList:
    def __init__(self, item):
        self.head = Node(item)
        self.num = 0

    def add(self, item):
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        cur.next = Node(item)
        self.num += 1

    def remove(self, item):
        if self.num == 0:
            print("List is empty")
            return False
        elif self.head.val == item:
            self.head = self.head.next
            self.num -= 1
        else:
            cur = self.head
            while cur.next is not None:
                if cur.next.val == item:
                    nextnode = cur.next.next
                    cur.next = nextnode
                    self.num -= 1
                    return
                cur = cur.next
            print("item does not exist in linked list")

    def reverse(self):
        prev = None
        cur = self.head
        while cur is not None:
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        self.head = prev

    def printlist(self):
        cur = self.head
        print("=========")
        while cur is not None:
            print(cur.val)
            cur = cur.next
            
    def search(self, item):
        cur = self.head
        for i in range(self.num):
            if cur.val == item:
                print(item, "is located at", i +1, "th place")
                return None
            cur = cur.next
        print(item, 'does not exist here')
        return None
    
    def num_of_list(self):
        print("The list has", self.num, "items")
        return self.num
