 package cn.kgc;

import java.util.Scanner;

public class Schoollibary {

	public static void main(String[] args) {
	/*	//实现图书管理功能
		新增图书
		查看图书
		删除图书
		借出图书
		归还图书
		退出图书系统*/
		String[] bookname=new String[6];//书籍名称
		int[] states=new int[6];//图书状态0为未借出，1为借出
		int[] days=new int[6];//借出天数
		int[] times=new int[6];//借出次数
		bookname[0]="金庸全集";
		bookname[1]="Java从入门到精通";
		bookname[2]="从你的全世界路过";
		bookname[3]="厚黑学";
		bookname[4]="AD开发";
		states[0]=1;
		states[1]=0;
		states[2]=1;
		states[3]=1;
		states[4]=0;
		days[0]=15;
		days[1]=0;
		days[2]=20;
		days[3]=11;
		days[4]=0;
		times[0]=16;
		times[1]=5;
		times[2]=10;
		times[3]=9;
		times[4]=3;

		
		System.out.println("欢迎使用图书管理系统");
		System.out.println("******************************************");
		Scanner sc=new Scanner(System.in);
		String answer;
		do {
			System.out.println("请选择你要使用的选项");
			System.out.println("******************************************");
			System.out.println("1.新增图书");
			System.out.println("2.查看图书");
			System.out.println("3.删除图书");
			System.out.println("4.借出图书");
			System.out.println("5.归还图书");
			System.out.println("6.退出图书系统");
			System.out.println("******************************************");	
			System.out.println("请输入选择：");
			int choose=sc.nextInt();
			boolean isname=false;
			switch (choose) {
			case 1://新增图书
				for(int i=0;i<bookname.length;i++){
					if(bookname[i]==null){
						System.out.println("你可以添加图书，请输入你添加的图书名称");
						 bookname[i]=sc.next();
						 System.out.println("添加成功");
						 isname=true;
					}
				}
				if (!isname) {
					System.out.println("图书存储已满，你不能添加书籍");		
				}
				break;
			case 2://查看图书
				for(int i=0;i<bookname.length;i++){
					if(bookname[i]==null){
						
					}else{
						String tt=(states[i]>0)?"借出":"未借出";
						System.out.println((i+1)+":\t"+bookname[i]+"\t\t"+tt);
					}
				}

				break;
			case 3://3.删除图书
				System.out.println("请输入你要选择的编号：");
				int num=sc.nextInt();
				boolean delname=false;
				for(int i=0;i<bookname.length;i++){
					if(bookname[i]!=null&&states[i]==0&&i==num-1){//图书存在，下标相同，状态未借出
						bookname[i]=bookname[i+1];
						states[i]=states[i+1];
						days[i]=days[i+1];
						times[i]=days[i+1];
						delname=true;
						bookname[bookname.length-1]=null;
						states[bookname.length-1]=0;
						days[bookname.length-1]=0;
						times[bookname.length-1]=0;
						System.out.println("图书已删除");
						break;
					}else if(bookname[i]!=null&&states[i]==1&&i==num-1){
						System.out.println("图书借出，不能删除");
						delname=true;
						break;
					}
					
				}
				if (!delname) {
					System.out.println("你输入的图书序号不存在");
				}

				break;
			case 4://借出图书
				boolean passname=false;
				System.out.println("请输入你要选择的编号：");
				int num1=sc.nextInt();
				for(int i=0;i<bookname.length;i++){
					if (bookname[i] != null && states[i]==0&&i==num1 - 1) {// 图书存在，下标相同，状态未借出
						states[i] = 1;
						System.out.println("请输入借出天数");
						days[i] = sc.nextInt();// 借出天数
						boolean last = false;// 判断输入日期是否合理
						do {
							if (days[i] >= 1 && days[i] <= 31) {
								System.out.println("借出成功");
								last = true;
								times[i]++;
							} else {
								System.out.println("输入时间不对，请重新输入");
								days[i] = sc.nextInt();
							}
						} while (!last);
						passname = true;
						break;
					}else if(bookname[i] != null && states[i] == 1&&i == num1 - 1){
						System.out.println("图书借出，不能再借");
						passname = true;
						break;
					}
				}
				   if (!passname) {
					System.out.println("输入图书不存在");
				  }

				break;
			case 5://归还图书
				boolean getname=false;
				System.out.println("请输入你要归还书籍的编号：");
				int num2=sc.nextInt();
				for(int i=0;i<bookname.length;i++){
					if (bookname[i] != null && states[i] == 1& i == num2 - 1) {// 图书存在，下标相同，状态借出
						states[i] = 0;
						System.out.println("请输入归还时间");
					int	num3= sc.nextInt();// 借出天数
						boolean get = false;// 判断输入日期是否合理
						do {
							if (num3>=days[i]&&num3<=31) {
								System.out.println("归还成功");
								get = true;
								days[i]=0;
							} else {
								System.out.println("输入时间不对，请重新输入");
								num3 = sc.nextInt();
							}
						} while (!get);
						getname = true;
						
					}else if(bookname[i] != null && states[i] == 1 & i == num2 - 1){
						System.out.println("图书已归还，不需在归还");
					}
				}
				   if (!getname) {
					System.out.println("输入图书不存在");
				  }

				break;
			case 6://退出图书系统
					System.out.println("退出图书系统成功");
				break;
				
			default:
				break;
				
			}
			System.out.println("是否退出(y/n)");
			 answer=sc.next();
		} while (answer.equals("n"));//输入y退出
		

	}

}
