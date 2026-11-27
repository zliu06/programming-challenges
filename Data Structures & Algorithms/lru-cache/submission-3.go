type Node struct {
	prev *Node
	next *Node
	key int
	value int
}

type LRUCache struct {
	capacity int
	cache map[int]*Node
	head *Node
	tail *Node
}

func Constructor(capacity int) LRUCache {
	head := &Node{}
	tail := &Node{}
	head.next = tail
	tail.prev = head
	return LRUCache {
		capacity: capacity,
		cache: make(map[int]*Node),
		head: head,
		tail: tail,
	}
}

func (this *LRUCache) Remove(n *Node) {
	prev := n.prev
	next := n.next
	prev.next = next
	next.prev = prev
}

func (this *LRUCache) AddToMru(n *Node) {
	tail := this.tail
	prev := tail.prev
	prev.next = n
	tail.prev = n
	n.prev = prev
	n.next = tail
}

func (this *LRUCache) Get(key int) int {
	if node, ok := this.cache[key]; ok {
		value := node.value
		this.Remove(node)
		this.AddToMru(node)
		return value
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
    if node, ok := this.cache[key]; ok {
		node.value = value
		this.Remove(node)
		this.AddToMru(node)
	} else {
		node = &Node{key: key, value: value}
		this.cache[key] = node
		this.AddToMru(node)

		size := len(this.cache)
		if size > this.capacity {
			lru := this.head.next
			delete(this.cache, lru.key)
			this.Remove(lru)
		}
	}
}
