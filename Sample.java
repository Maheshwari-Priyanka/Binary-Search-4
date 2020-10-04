// Problem 2 - Intersection of Two Arrays II
// Time Complexity: O(n + m) where, n = length of nums1 and m = length of nums2
// Space Complexity: O(n + m)

// Algorithm
// 1 - loop over nums1
// 2 - add the number as key and its count of apperance to map
// 3 - loop over nums2
// 4 - if condition: num present in map and count greater than 1
// 5 - then decrement the count and add the num to list
// 6 - convert list to array
class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    // 1
    for (int i=0; i<nums1.length; i++) {
      // 2
      if (map.containsKey(nums1[i])) {
        map.put(nums1[i], map.get(nums1[i]) + 1);
      } else {
        map.put(nums1[i], 1);
      }
    }
    // 3
    for (int i=0; i<nums2.length; i++) {
      // 4
      if (map.containsKey(nums2[i])  && map.get(nums2[i]) > 0) {
        // 5
        map.put(nums2[i], map.get(nums2[i]) - 1);
        list.add(nums2[i]);
      }
    }

    int[] result = new int[list.size()];
    // 6
    for (int i=0; i<list.size(); i++) {
      result[i] = list.get(i);
    }

    return result;
  }
}
