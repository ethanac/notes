## Questions
1. 给定一个已经按绝对值升序排列的数组，找到两个数使他们加起来的和等于特定数。
函数应该返回这两个数的下标，index1必须小于index2。注意：数组的下标以0开始。
你不能对该数组进行排序。
挑战
O(n)的时间复杂度 和 O(1)的额外空间复杂度

Solution:
Two pointer
left 指向最小值，right 指向最大值。两指针分别移动，求和判断即可。