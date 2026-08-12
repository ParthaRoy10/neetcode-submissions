class MedianFinder {

    private int[] median;
    private boolean even;
    private List<Integer> list;

    public MedianFinder() {
        median = new int[2];

        median[0] = 0;
        median[1] = 0;

        even = true;

        list = new ArrayList<>();
    }

    public void addNum(int num) {

        list.add(num);
        Collections.sort(list);

        even = !even;

        if (even) {
            median[1]++;
        } else {
            median[0] = median[1];
        }
    }

    public double findMedian() {

        if (even) {
            return (list.get(median[0]) + list.get(median[1])) / 2.0;
        }

        return list.get(median[0]);
    }
}