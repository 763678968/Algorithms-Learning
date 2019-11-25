public class Solution {
    private ArrayDeque<InternalData> data = new ArrayDeque<InternalData>();
    private ArrayDeque<InternalData> max = new ArrayDeque<InternalData>();

    private class InternalData {
        int number;
        int index;
        public InternalData(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    private int curIndex;

    public void push_back(int number) {
        InternalData curData = new InternalData(number, curIndex);
        data.addLast(curData);

        while(!max.isEmpty() && max.getLast().number < number)
            max.removeLast();
        max.addLast(curData);

        curIndex++;
    }

    public void pop_front() {
        if (data.isEmpty()) {
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData = data.removeFirst();
        if (curData.index == max.getFirst().index)
            max.removeFirst();
    }

    public int max() {
        if (max == null) {
            System.out.println("队列为空！");
            return 0;
        }
        return max.getFirst().number;
    }
}
