class LRUCache:
    class Node:
        def __init__(self, key=None, value=None):
            self.prev = None
            self.next = None
            self.key = key
            self.value = value

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.head = self.Node()
        self.tail = self.Node()
        self.head.next = self.tail
        self.tail.prev = self.head

    def _remove(self, node):
        before = node.prev
        after = node.next
        before.next = after
        after.prev = before

    def _append_mru(self, node):
        tail = self.tail
        last = tail.prev
        tail.prev = node
        last.next = node
        node.prev = last
        node.next = tail

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]

            # move node to the tail
            # 1. update old neighbor pointers
            self._remove(node)

            # 2. update new neighbor pointers
            self._append_mru(node)

            return node.value
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            node.value = value
            # remove node because we should move it to mru
            self._remove(node)
        else:
            node = self.Node(key, value)
            self.cache[key] = node

        self._append_mru(node)

        if len(self.cache) > self.capacity:
            head = self.head
            lru = head.next
            after = lru.next
            self._remove(lru)
            del self.cache[lru.key]

