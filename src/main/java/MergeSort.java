public void MergeSort(int[] arr, int left, int right){
    if(left < right){
        int mid = (left + right) / 2;
        MergeSort(arr, left, mid);
        MergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

public void merge(int[] arr, int left, int mid, int right){
    int i = mid - left + 1;
    int j = right - mid;
    int[] leftArr = new int[i];
    int[] rightArr = new int[j];
}