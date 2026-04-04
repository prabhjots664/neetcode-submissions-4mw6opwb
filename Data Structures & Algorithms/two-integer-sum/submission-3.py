class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        dictt = {}
        for i,n in enumerate(nums):
            complement = target - n
            if complement in dictt:
                return [dictt[complement], i]

            dictt[n] = i
        
        