/**
 * Created by lichenxi on 2017/11/12.
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:
 Input: 123
 Output:  321

 Example 2:
 Input: -123
 Output: -321

 Example 3:
 Input: 120
 Output: 21

 Note:
 Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 For the purpose of this problem,
 assume that your function returns 0 when the reversed integer overflows.

 输入123 输出321 反转一下   -123输入 输入-321 如果是120 反转后就是21 0要忽略
 123求余 得到3 3*10+2=32 32*10+1=321  ok得到
 120
 题目提到了溢出问题 只能把数保持在一个integer的整数范围内 也就是我们要保证反转之后 数字要保持在integer范围内
 我为什么要把int转成long类型 这个问题 不要问我
 */
public class ReverseInteger {

    public int reverse(int x) {
          long temp=x;
          long result=0;
          while (temp!=0){
              result=result*10+temp%10;
              temp=temp/10;
          }
          if (result>Integer.MAX_VALUE|| result<Integer.MIN_VALUE){
              result=0;
          }

        return  (int)result;
    }
}
