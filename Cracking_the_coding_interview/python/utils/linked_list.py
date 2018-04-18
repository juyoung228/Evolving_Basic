from random import randint


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

'''
The following classes are added.
There is tail in these classes.
ref: https://github.com/careercup/CtCI-6th-Edition-Python/blob/e6bc732588601d0a98e5b1bc44d83644b910978d/Chapter2/LinkedList.py
'''
class LinkedListNode:

    def __init__(self, value=None, nextNode=None, prevNode=None):
        self.value = value
        self.next = nextNode
        self.prev = prevNode

    def __str__(self):
        return str(self.value)


class LinkedList2:

    def __init__(self, values=None):
        self.head = None
        self.tail = None
        if values is not None:
            self.add_multiple(values)

    def __iter__(self):
        current = self.head
        while current:
            yield current
            current = current.next

    def __str__(self):
        values = [str(x) for x in self]
        return ' -> '.join(values)

    def __len__(self):
        result = 0
        node = self.head
        while node:
            result += 1
            node = node.next
        return result

    def add(self, value):
        if self.head is None:
            self.tail = self.head = LinkedListNode(value)
        else:
            self.tail.next = LinkedListNode(value)
            self.tail = self.tail.next
        return self.tail

    def add_to_beginning(self, value):
        if self.head is None:
            self.tail = self.head = LinkedListNode(value)
        else:
            self.head = LinkedListNode(value, self.head)
        return self.head

    def add_multiple(self, values):
        for v in values:
            self.add(v)

    def generate(self, n, min_value, max_value):
        self.head = self.tail = None
        for i in range(n):
            self.add(randint(min_value, max_value))
        return self


class DoublyLinkedList(LinkedList):

    def add(self, value):
        if self.head is None:
            self.tail = self.head = LinkedListNode(value, None, self.tail)
        else:
            self.tail.next = LinkedListNode(value)
            self.tail = self.tail.next
        return self