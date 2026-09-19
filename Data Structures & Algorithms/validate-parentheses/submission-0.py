class Solution:
	def isValid(self, s: str) -> bool:
		lifo = list()
		pairs = dict()
		pairs[']'] = '['
		pairs[')'] = '('
		pairs['}'] = '{'
		for c in s:
			if c in pairs.values():
				lifo.append(c)
			if c in pairs.keys():
				if len(lifo) > 0 and lifo[-1] == pairs[c]:
					lifo.pop()
					continue
				else:
					return False
		return not lifo