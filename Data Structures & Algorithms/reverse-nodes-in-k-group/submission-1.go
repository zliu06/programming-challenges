/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reverseKGroup(head *ListNode, k int) *ListNode {
    var groupPrev *ListNode
	var groupNext *ListNode
	var dummy = &ListNode{Next: head}

	groupPrev = dummy

	var advance = func(base *ListNode, k int) *ListNode {
		node := base
		for i:= 0; i < k; i++ {
			if node == nil {
				return nil
			}
			node = node.Next
		}
		return node
	}

	for {
		kth := advance(groupPrev, k)

		if kth == nil {
			break
		}
		groupNext = kth.Next

		var prev *ListNode = groupNext
		var curr *ListNode = groupPrev.Next
		for curr != groupNext {
			next := curr.Next
			curr.Next = prev
			prev = curr
			curr = next
		}
		oldHead := groupPrev.Next
		groupPrev.Next = kth
		groupPrev = oldHead
	}

	return dummy.Next
}
