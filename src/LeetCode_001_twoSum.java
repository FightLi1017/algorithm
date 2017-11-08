import java.util.Arrays;
import java.util.Collections;

/**
 * Created by lichenxi on 2017/11/9.
 */
public class LeetCode_001_twoSum {
//    Given an array of integers, find two numbers such that they add up to a specific target number.
//　　The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//　　You may assume that each input would have exactly one solution.
//　　Input: numbers={2, 7, 11, 15}, target=9
//    Output: index1=1, index2=2
/*
   解题思路
   构造一个Node值 存value 和下标  然后根据value对node数组进行排序  然后我开始 从第一个加最后一个
   相加如果大于target对话 要求index1<index2 所以 我们将最后一个位置的下标左移动
   小于的话 那就第一个位置下标右移动。其实就是一个加一 一个减一的过程 所以我们要记住左边的下标和右边的下标
   这样方便我们做加减操作
   典型的以空间换时间的做法  因为之前对node对value进行排序 所以并不保证index是排序的 所以就比较大小

 */

 class  Node implements Comparable<Node>{
     private int value;
     private int index;
    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
    @Override
    public int compareTo(Node node) {
        return compare(this.value,node.value);
    }
     public  int compare(int x, int y) {
         return (x < y) ? -1 : ((x == y) ? 0 : 1);
     }
}
     public int[] twosum(int[] sum, int target){
      int[] result=new int[2];

      Node[] temp=new Node[sum.length];
      for (int i=0;i<sum.length-1;i++){
          temp[i]=new Node(sum[i],i);
      }

         Arrays.sort(temp);

     int head=0;
     int last=temp.length-1;
      while (head<last){
          int tempvalue=temp[head].value+temp[last].value;
          if (tempvalue==target){
              if (temp[head].index>temp[last].index){
                  result[0]=temp[last].index+1;
                  result[1]=temp[head].index+1;
              }else{
                  result[0]=temp[head].index+1;
                  result[1]=temp[last].index+1;
              }
          } else if (tempvalue>target){
               last--;
          } else {
               head++;
          }
      }

     return result;
     }
}
