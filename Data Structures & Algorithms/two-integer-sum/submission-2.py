class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        s = set()
        for i, n in enumerate(nums):
            if target-n in s:
                ll = [nums.index(target-n), i]
                ll.sort()
                return ll
            s.add(n)
        
        