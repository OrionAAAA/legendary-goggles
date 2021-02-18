package old;

/**
 * Created by Orion on 2020/11/18 20:50
 */
public class training8 {
    /**冒泡排序
     * 算法步骤:
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */

    //测试用例
    static int[] TEST_CASE={10,9,8,7,6,5,4,3,2,1};
    static int[] TEST_CASE2={5,1,2,6,9};
    static int[] TEST_CASE3={1,2,3,4};


    public static void main(String[] args) {
        bubbleSort(TEST_CASE2);
    }

    //冒泡排序核心实现
    public static int[] bubbleSort(int[] sourceArray){
        int[] sortArray=sourceArray;
        for (int i=0;i<sortArray.length;i++){
            for (int j=0;j<sortArray.length-1;j++){
                if (sortArray[j]>sortArray[j+1]){
                    int temp=sortArray[j];
                    sortArray[j]=sortArray[j+1];
                    sortArray[j+1]=temp;
                }

            }
        }
        System.out.println(Array2String(sortArray));
        return sortArray;
    }

    //优化写法
    // 1.设置flag，如果输入的数组是正序，则直接输出
    // 2.将第二个循环的循环条件从-1改为-i，减少每次循环遍历的长度（不遍历的已经是有序区）
    public static int[] bubbleSortB(int[] sourceArray){
        int[] sortArray=sourceArray;
        boolean flag=true;
        for (int i=0;i<sortArray.length;i++){
            for (int j=0;j<sortArray.length-i;j++){
                if (sortArray[j]>sortArray[j+1]){
                    int temp=sortArray[j];
                    sortArray[j]=sortArray[j+1];
                    sortArray[j+1]=temp;

                    flag=false;
                }
                if (flag) {
                    break;
                }
            }
        }
        System.out.println(Array2String(sortArray));
        return sortArray;
    }

    //打印方法
    private static String Array2String(int[] array){
        StringBuilder str=new StringBuilder();
        str.append("{");
        for (int i=0;i<array.length;i++) {
            if (i != 0) {
                str.append(",");
            }
            str.append(array[i]);
        }
        str.append("}");
        return str.toString();
    }


}
