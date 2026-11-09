type Node struct {
	key int
	value int
	next *Node
	prev *Node
}

type LRUCache struct {
	cache map[int]*Node
	head *Node // LRU end
	tail *Node // MRU end
	capacity int
}

func Constructor(capacity int) LRUCache {
	head := &Node{}
	tail := &Node{}
	head.next = tail
	tail.prev = head
	return LRUCache{
		cache: make(map[int]*Node),
		head: head,
		tail: tail,
		capacity: capacity,
	}
}

func (this *LRUCache) Remove(node *Node) {
	node.prev.next = node.next
	node.next.prev = node.prev
}

func (this *LRUCache) AddToMRU(node *Node) {
	prev := this.tail.prev
	tail := this.tail
	prev.next = node
	tail.prev = node
	node.prev = prev
	node.next = tail
}

func (this *LRUCache) Get(key int) int {
	if node, ok := this.cache[key]; ok {
		value := node.value
		this.Remove(node)
		this.AddToMRU(node)
		return value
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if node, ok := this.cache[key]; ok {
		// update
		node.value = value
		this.Remove(node)
		this.AddToMRU(node)
	} else {
		node = &Node{key: key, value: value}
		this.cache[key] = node
		this.AddToMRU(node)
	}

	if len(this.cache) > this.capacity {
		lru := this.head.next
		this.Remove(lru)
		delete(this.cache, lru.key)
	}
}
