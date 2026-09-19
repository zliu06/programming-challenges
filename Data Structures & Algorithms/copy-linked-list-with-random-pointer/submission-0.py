"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        node_ref_to_index = {}
        new_node_list = []
        curr = head
        index = 0
        while curr != None:
            node_ref_to_index[curr] = index
            new_node_list.append(Node(curr.val))
            curr = curr.next
            index += 1
            
        curr = head

        index = 0
        while curr != None:
            new_node = new_node_list[index]
            new_node.next = new_node_list[index + 1] if index + 1 < len(new_node_list) else None

            if curr.random:
                random_node_index = node_ref_to_index[curr.random]
                new_node.random = new_node_list[random_node_index]
            else:
                new_node.random = None
            curr = curr.next
            index += 1

        return new_node_list[0] if new_node_list else None