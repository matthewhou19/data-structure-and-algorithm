
def findNumbers(nums):
    res = 0
    for num in nums:
        curr = 0
        while num != 0:
            num = num / 10
            curr += 1
        if curr % 2 == 0:
            res += 1
    return res


input = [555, 901, 482, 1771]

print(findNumbers(input))
