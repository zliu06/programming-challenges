class Solution:
	def findDuplicate(self, nums: List[int]) -> int:
		slow = fast = 0
		
		while True:
			fast = nums[fast]
			fast = nums[fast]
			slow = nums[slow]
			if slow == fast:
				break
				
		meeting_pt = slow
		
		pt = 0
		while True:
			pt = nums[pt]
			meeting_pt = nums[meeting_pt]
			if pt == meeting_pt:
				return pt