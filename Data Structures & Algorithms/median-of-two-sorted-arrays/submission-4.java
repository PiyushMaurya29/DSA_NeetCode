class Solution {
    public List<Integer> getMergedList(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] <= nums2[j]){
                list.add(nums1[i++]);
            }
            else{
                list.add(nums2[j++]);
            }
        }
        while(i < nums1.length){
            list.add(nums1[i++]);
        }
        while(j < nums2.length){
            list.add(nums2[j++]);
        }
        return list;
    }
    public List<Integer> getMergedListHalf(int[] nums1, int[] nums2){
        int n = nums1.length + nums2.length;
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] <= nums2[j]){
                list.add(nums1[i++]);
            }
            else{
                list.add(nums2[j++]);
            }
            if(list.size() > n/2) break;
        }
        while(i < nums1.length){
            if(list.size() > n/2) break;
            list.add(nums1[i++]);
        }
        while(j < nums2.length){
            if(list.size() > n/2) break;
            list.add(nums2[j++]);
        }
        return list;
    }

    public double solveSpaceOptimized(int[] nums1, int[] nums2){
        int n = nums1.length + nums2.length;

        int i=0, j=0;
        
        int prev = -1;
        int curr = -1;

        int index = -1;
        while(i<nums1.length && j <nums2.length){
            if(nums1[i] <= nums2[j]){
                prev = curr;
                curr = nums1[i++];
            }
            else{
                prev = curr;
                curr = nums2[j++];
            }
            index++;
            if(index >= n/2){
                return n%2 == 0 ? (prev+curr)/2.0 : curr;
            }
        }
        return -1;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return solveSpaceOptimized(nums1, nums2);

        
        // List<Integer> list = getMergedListHalf(nums1, nums2);
        // int n = nums1.length + nums2.length;
        // int size = list.size();
        // return n%2 == 0 ? (list.get(size-1)+list.get(size-2))/2.0 : list.get(size-1);


        // List<Integer> list = getMergedList(nums1, nums2);
        // int n = list.size();
        // return n%2 == 0 ? (list.get(n/2)+list.get(n/2-1))/2.0 : list.get(n/2);



        // List<Integer> list = new ArrayList<>();
        // for(int num : nums1){
        //     list.add(num);
        // }
        // for(int num : nums2){
        //     list.add(num);
        // }
        // Collections.sort(list);
        // int n = list.size();
        // return n%2 == 0 ? (list.get(n/2)+list.get(n/2-1))/2.0 : list.get(n/2);
    }
}
