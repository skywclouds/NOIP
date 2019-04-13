package noip;
import java.util.Arrays;
/**
 * 2018��NOIP����鸴����һ��ڶ���
 * ��������
 * ���ö�̬�滮
 * ��ʱ��1.91Сʱ
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
	 * ���㷨
	 * */
	static int shortest(int[] moneys) {
		for(int i = moneys.length - 1;i >= 0;i--) {
			if(isComable(moneys, moneys[i])) {//���ĳ����ֵ�ܱ������Ļ��Ҵճ���������ȥ
				moneys = remove(moneys,i);
			}
		}
		return moneys.length;
	}
	/**
	 * ��ȥĳ�ֻ�����ֵ�ķ���
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
	 * �ؼ��㷨
	 * �ж�ĳ�ֻ�����ֵ�Ƿ��ܱ��ճ�
	 * */
	static boolean isComable(int[] arr,int money) {
		boolean b = false;
		int index = -1;
		for(int i = arr.length - 1;i >= 0;i--) {//Ѱ�ұ�Ҫȷ������ֵС����ֵ�����
			if(arr[i] < money) {
				index = i;
				break;
			}
		}
		if(index == -1) {//�������ȷ������ֵ����϶��ղ�����
			b = false;
		}else{
			for(int i = index;i >= 0;i--) {
				if(money % arr[i] == 0) {//���ܱ�ǰһ�����������ܴճ���
					b = true;
					break;
				}else {
					b = b ||  isComable(arr, money - arr[i]);//�����ܣ����ö�̬�滮��ʹҪȷ������ֵ��ȥǰһ����ֵ�ٵݹ�
				}
			}
		}
		return b;
	}
}
