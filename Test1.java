package noip;
/**
 * 2018��NOIP����鸴����һ���һ��
 * ��������
 * ���÷ֶ���֮��˼��
 * ��ʱ��2.25Сʱ
 * */
public class Test1 {
	static int day = 0 ;
	public static void main(String[] args) {
		int[] road = new int[100000];
		for(int i = 0;i<road.length;i++) {
			road[i] = (int) (-10000*Math.random());
		}
		day(road,0,road.length - 1);
		System.out.println(day);
	}
	 static void day(int[] road,int start,int end) {
		if(start == end) {
			day -= road[start];//���start��end��ȣ���ȥ·����ȣ���ֹͣ�ݹ�
		}else {
			int i = 0;
			for(i = start;i < end;i++) {
				if(road[i] == 0) {
					break;//�ҳ��Ƿ���һ��Ϊ0��Ȼ��ֶ���֮
				}
			}
			if(i == end) {//û��һ��Ϊ0
				if(road[end] == 0) {//�ж����һ���Ƿ�Ϊ0,��Ϊ0,���ÿ������һ��
					int j = start;
					for(int r = start;r<end;r++) {
						if(road[r] > road[j]) {//�ҳ�����������
							j = r;
						}
					}
					int k = road[j];
					for(i = start;i < end;i++) {
						road[i] -= k;
					}
					day -= k;//�������Լ��ٵݹ��������Ч��ֹջ���
					day(road,start,end);
				}else {
					int j = start;
					for(int r = start;r < end + 1;r++) {
						if(road[r] > road[j]) {
							j = r;
						}
					}
					int k = road[j];
					for(i = start;i < end + 1;i++) {
						road[i] -= k;
					}
					day -= k;
					day(road,start,end);
				}
			}else {//��һ��Ϊ0
				day(road,start,i);//��������ֱ�ݹ�
				day(road,i+1,end);
			}
		}
	}
}
