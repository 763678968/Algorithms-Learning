public int getMissingNumber(int[] array) {
    int length = array.length;
    if (array==null || length<=0)
        return -1;

    int left = 0;
    int right = length - 1;
    while (left < right) {
        int middle = (right + left) >> 1;
        if (array[middle] != middle) {
            if (middle==0 || array[middle-1]==middle-1)
                return middle;
            right = middle - 1;
        } else {
            left = middle + 1;
        }
    }

    if (left == length)
        return length;

    // 无效的输入，比如数组不是按要求排序的，
    // 或者有数字不在0~n-1范围之内
    return -1;
}
