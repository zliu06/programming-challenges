class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj = {}
        in_degree = {}

        for word in words:
            for ch in word:
                if not ch in adj:
                    adj[ch] = []
                    in_degree[ch] = 0

        for i in range(len(words) - 1):
            left = words[i]
            right = words[i + 1]

            for k in range(min(len(left), len(right))):
                if left[k] != right[k]:
                    if right[k] not in adj[left[k]]:
                        adj[left[k]].append(right[k])
                        in_degree[right[k]] = in_degree.get(right[k], 0) + 1
                    break
            else:
                if len(left) > len(right):
                    return ""

        head = 0
        queue = []
        for ch, degree in in_degree.items():
            if degree == 0:
                queue.append(ch)

        result = []

        while head < len(queue):
            ch = queue[head]
            head += 1
            result.append(ch)
            neighbors = adj[ch]
            for nbr in neighbors:
                in_degree[nbr] = in_degree.get(nbr) - 1
                if in_degree[nbr] == 0:
                    queue.append(nbr)

        for ch, degree in in_degree.items():
            if degree > 0:
                return ""

        return "".join(result)
