package noip;
/**
 * 2018年NOIP提高组复赛第一天第一题
 * 独立做出
 * 运用分而治之的思想
 * 耗时：2.25小时
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
			day -= road[start];//如果start和end相等，减去路的深度，并停止递归
		}else {
			int i = 0;
			for(i = start;i < end;i++) {
				if(road[i] == 0) {
					break;//找出是否有一项为0，然后分而治之
				}
			}
			if(i == end) {//没有一项为0
				if(road[end] == 0) {//判断最后一项是否为0,若为0,则不用考虑最后一项
					int j = start;
					for(int r = start;r<end;r++) {
						if(road[r] > road[j]) {//找出最大的项的序号
							j = r;
						}
					}
					int k = road[j];
					for(i = start;i < end;i++) {
						road[i] -= k;
					}
					day -= k;//这样可以减少递归次数，有效防止栈溢出
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
			}else {//有一项为0
				day(road,start,i);//左右两侧分别递归
				day(road,i+1,end);
			}
		}
	}
}
