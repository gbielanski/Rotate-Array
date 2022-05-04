# Leetcode problem 189. Rotate Array

This repository contains solution and tests of [Leetcode problem 189. Rotate Array](https://leetcode.com/problems/rotate-array/) written in Kotlin language

## Solution

```Kotlin
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
```



## Tests

```Kotlin
import org.junit.Assert.*
import org.junit.Test

class SolutionTest {
    @Test
    fun `when numbers are 1,2,3,4,5,6,7 and steps are 3 should return 5,6,7,1,2,3,4`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val steps = 3
        val solution = Solution()

        solution.rotate(nums, steps)

        assertArrayEquals(nums, intArrayOf(5, 6, 7, 1, 2, 3, 4))
    }

    @Test
    fun `when numbers are -1,-100,3,99 and steps are 2 should return 3,99,-1,-100`() {
        val nums = intArrayOf(-1, -100, 3, 99)
        val steps = 2
        val solution = Solution()

        solution.rotate(nums, steps)

        assertArrayEquals(nums, intArrayOf(3, 99, -1, -100))
    }

    @Test
    fun `when numbers are -1 and steps are 2 should return -1`() {
        val nums = intArrayOf(-1)
        val steps = 2
        val solution = Solution()

        solution.rotate(nums, steps)

        assertArrayEquals(nums, intArrayOf(-1))
    }
}
```