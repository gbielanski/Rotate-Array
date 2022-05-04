class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (nums.size == 1 || nums.size == k) {
            return
        }

        val steps = if (k > nums.size) k % nums.size else k

        revertSubArray(0, nums.lastIndex, nums)
        revertSubArray(0, steps - 1, nums)
        revertSubArray(steps, nums.lastIndex, nums)

    }

    private fun revertSubArray(first: Int, last: Int, nums: IntArray) {
        var firstIndex = first
        var lastIndex = last
        var tmp: Int
        while (firstIndex < lastIndex) {
            tmp = nums[firstIndex]
            nums[firstIndex] = nums[lastIndex]
            nums[lastIndex] = tmp

            firstIndex++
            lastIndex--
        }
    }
}