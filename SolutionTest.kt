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