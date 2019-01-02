package cn.kgc;

import java.util.Scanner;

/*吃货联盟系统*/
public class Eatter {

	public static void main(String[] args) {
		String[]  names=new String[4];//点餐人姓名
		String[]  dishnames=new String[4];//订购的餐品
		int time[]=new int[4];//起送时间
		String[] adress=new String[4];// 送餐地址
		double[] sumprice=new double[4];//订单金额
		int[] states=new int[4];//订单状态0为预定，1为送达
		
		String[] dishname={"鱼香肉丝","麻辣小龙虾","冒血旺","小炒肉"};//菜品名字
		int[] prices={10,30,20,15};//菜品价格
		int[] good={0,0,0,0,};//点赞数
		int[] praisenums=new int[4];//点购的份数
		//首先输入两个订单
		names[0]="张俊";
		names[1]="陈威";
		dishnames[0]=dishname[0];
		dishnames[1]=dishname[1];
		time[0]=9;
		time[1]=11;
		adress[0]="三江学院4号门";
		adress[1]="三江学院4号门";
		sumprice[0]=60;
		sumprice[1]=160;
		states[0]=0;
		states[1]=1;
		praisenums[0]=2;
		praisenums[1]=4;
		
		System.out.println("欢迎使用吃货联盟系统");
		int num=-1;
		do{
			System.out.println("*************************************");
			System.out.println("1.我要订餐");
			System.out.println("2.我的餐单");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("*************************************");
			Scanner input=new Scanner(System.in);
			System.out.println("请输入一个选择");
			int choose=input.nextInt();
			boolean isadd=false;//判断是否可以订餐
			switch (choose) {
			case 1:
				for(int j=0;j<names.length;j++){
					if(names[j]==null){
						isadd=true;
						System.out.println("请输入你要选择的菜品");
						for(int i=0;i<4;i++){
							System.out.println((i+1)+".\t"+dishname[i]+"\t"+prices[i]+"\t点赞数"+good[i]);
							
						}
						int nam=input.nextInt();//接受时第几分菜品,这里的nam时一个数字，可以和后面的价格想乘
						dishnames[j]=dishname[nam-1];
						
						System.out.println("请输入份数：");
						int nums=input.nextInt();
						praisenums[j]=nums;//份数的语句
						 sumprice[j]=prices[nam-1]*praisenums[j];//总金额的价格：价格乘份数
						 if(sumprice[j]>50){
							 sumprice[j]=sumprice[j]+0;//免除运费
						 }else{
							 sumprice[j]=sumprice[j]+6;//需要运费6元
						 }
						System.out.println("请输入选择送餐时间，时间请为8~20之间的整数");
						int times=input.nextInt();
						while(times<8||times>20){
							System.out.println("您输入的时间不对，请重新输入");
							 times=input.nextInt();
						}
						time[j]=times;
						//时间语句
						System.out.println("请输入你的姓名：");
						String name=input.next();
						names[j]=name;//输入姓名
						System.out.println("请输入你的送餐地址：");
						String adr=input.next();
						adress[j]=adr;
	
						System.out.println("您的订单为：");
						System.out.println("点餐人："+names[j]+"\t您点的餐是："+dishnames[j]+"\t份数为："+praisenums[j] );
						System.out.println("送达地址：\t"+adress[j]+"\t送餐时间为"+time[j]);
						if(sumprice[j]>50){
							System.out.println("您点的餐超过50，免除运费，您需要付款：\t￥"+sumprice[j]);
						}else{
							System.out.println("您点的餐低于50，需要运费6元，您需要付款：\t￥"+sumprice[j]);
						}
						
						break;//这里接入的是在if中循环，为空时才会执行
					   }	
				}//执行for循环，显示是否为空
				if(!isadd){
					System.out.println("你的餐袋已满，不能订餐");		
				}
				break;
			case 2 ://签收订单
				
				System.out.println("*********您的订单**************");
			
				for(int j=0;j<names.length;j++){
					if(names[j]!=null){
						String za=states[j]==0?"送达中":"签收";
					System.out.println("序号"+(j+1)+"\t点餐人："+names[j]+"\t您点的餐是："+dishnames[j]+"\t份数为："+praisenums[j]+"送达地址：\t"+adress[j]+"\t送餐时间为："+time[j]+"\t餐费￥："+sumprice[j]+"\t订单状态："+za );
					}
				}
				
			    break;
            case 3:
            	System.out.println("*******************签收订单**************");
            	System.out.println("请选择你要签收的订单：");
            	int isget=input.nextInt();
            	boolean stFind=false;
            	for(int j=0;j<names.length;j++){
            		if(names[j]!=null&&states[j]==1&&isget==j+1){//内容不为空，状态为签收，则不能签收
            			System.out.println("订单已经签收,不能重复签收");//显示订单存在
            			
            			stFind=true;
            		}else if (names[j]!=null&&states[j]==0&&isget==j+1){//显示为零的
            			states[isget-1]=1;
            			System.out.println("操作成功，订单已经签收");
            			stFind=true;
            		}
            	}
            	if(!stFind){
            		System.out.println("对不起，你输入的订单不存在");
            	}
				break;
			case 4:
				
				boolean isFind=false;
            	System.out.println("请选择你要删除的订单：");
            	int delid=input.nextInt();
            	for(int j=0;j<names.length;j++){
            		if(names[j]!=null&&states[j]==1&&delid==j+1){//内容不为空，状态为签收，序号输入对
            			isFind=true;//显示订单存在
            		for(int i=delid-1;i<names.length-1;i++){//删除对应的数组下标，则后面的向前位移一个
            			names[i]=names[i+1];//点餐人
            			dishnames[i]=dishnames[i+1];//餐品
            			praisenums[i]=praisenums[i+1];//份数
            			adress[i]=adress[i+1];//送达地址
            			sumprice[i]=sumprice[i+1];//总计金额
            			states[i]=states[i+1];//是否签订
            			time[i]=time[i+1];//送餐时间
            		}
            		names[names.length-1]=null;//点餐人
        			dishnames[names.length-1]=null;//餐品
        			praisenums[names.length-1]=0;//份数
        			adress[names.length-1]=null;//送达地址
        			sumprice[names.length-1]=0;//总计金额
        			states[names.length-1]=0;//是否签订
        			time[names.length-1]=0;//送餐时间
        			System.out.println("订单删除成功");
        			break;
            		}else if (names[j]!=null&&states[j]==0&&delid==j+1){
            			System.out.println("订单未签收，不能删除");
            			isFind=true;
            			break;
            		}
            	}
            		if(!isFind){
            			System.out.println("对不起，你输入的订单不存在");
            		}
			    break;
			case 5:
				System.out.println("我要点赞：");
				System.out.println("请输入你要点赞的菜品");
				for(int i=0;i<4;i++){
					System.out.println((i+1)+".\t"+dishname[i]+"\t"+prices[i]+"\t点赞数"+good[i]);
				}
				int goodnum=input.nextInt();
				if(goodnum>=1&&goodnum<=4){
				good[goodnum-1]++;
				System.out.println("点赞成功，感谢您的认可");
				}else{
					System.out.println("输入的订单不存在，退出");
				}
				
				
		       break;
			case 6 :
				System.out.println("欢迎下次使用");
		        break;

			default:
				System.out.println("输入不对，感谢你的使用，欢迎下次光临");
				break;
			}
			if(choose<1||choose>5){
				break;
			}else{
			System.out.println("输入0返回，按其他任意值退出");
			num=input.nextInt();
			}
		}while(num==0);
		System.out.println("感谢你的使用，欢迎下次光临");
	}

}
