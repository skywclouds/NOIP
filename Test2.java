package noip;
import java.util.Arrays;
/**
 * 2018年NOIP提高组复赛第一天第二题
 * 独立做出
 * 运用动态规划
 * 耗时：1.91小时
 * */
public class Test2 {
	public static void main(String[] args) {
		int[] moneys = new int[100];
		for(int i = 0;i < moneys.length;i++) {
			moneys[i] = (int) (25000*Math.random() + 1);
		}
		int length = shortest(moneys);
		System.out.println(length);
	}
	/**
	 * 主算法
	 * */
	static int shortest(int[] moneys) {
		for(int i = moneys.length - 1;i >= 0;i--) {
			if(isComable(moneys, moneys[i])) {//如果某种面值能被其他的货币凑出来，则移去
				moneys = remove(moneys,i);
			}
		}
		return moneys.length;
	}
	/**
	 * 移去某种货币面值的方法
	 * */
	static int[] remove(int[] arr,int index) {
		int temp = arr[index];
		for(int i = index;i < arr.length - 1;i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length - 1] = temp;
		arr = Arrays.copyOf(arr, arr.length - 1);
		return arr;
	}
	/**
	 * 关键算法
	 * 判断某种货币面值是否能被凑出
	 * */
	static boolean isComable(int[] arr,int money) {
		boolean b = false;
		int index = -1;
		for(int i = arr.length - 1;i >= 0;i--) {//寻找比要确定的面值小的面值的序号
			if(arr[i] < money) {
				index = i;
				break;
			}
		}
		if(index == -1) {//如果都比确定的面值大，则肯定凑不出来
			b = false;
		}else{
			for(int i = index;i >= 0;i--) {
				if(money % arr[i] == 0) {//若能被前一个整除，则能凑出来
					b = true;
					break;
				}else {
					b = b ||  isComable(arr, money - arr[i]);//若不能，则用动态规划，使要确定的面值减去前一个面值再递归
				}
			}
		}
		return b;
	}
}
