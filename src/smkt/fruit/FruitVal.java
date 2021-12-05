package smkt.fruit;

import java.util.Scanner;

public class FruitVal {
    public static void main(String[] args) {
        System.out.println("***欢迎来到水果平价超市***");
        // 顾客A、B、C、D
        double totalMoney=0.0;//总消费金额
        int weight=0;//购买水果的斤数
        int select=0;//选择水果类型
        do {
            System.out.println("请选择需要购买水果类型：（1代表苹果，2代表草莓，3代表芒果,0代表结账）");
            select=inputInt();
            switch (select){
                case 0:
                    totalMoney=totalMoney>=100?totalMoney-Math.floor(totalMoney/100)*10:totalMoney;
                    System.out.println("你本次消费金额为："+totalMoney);
                    break;
                case 1:
                    weight=0;
                    System.out.println("请输入需要购买苹果的斤数。");
                    weight=inputInt();
                    totalMoney+=fruit("苹果",weight,1);
                    break;
                case 2:
                    weight=0;
                    System.out.println("请输入需要购买草莓的斤数。");
                    weight=inputInt();
                    totalMoney+=fruit("草莓",weight,1);
                    break;
                case 3:
                    weight=0;
                    System.out.println("请输入需要购买芒果的斤数。");
                    weight=inputInt();
                    totalMoney+=fruit("芒果",weight,0.8);
                    break;
                default:
                    System.out.println("您购买的水果暂时没有，谢谢惠顾！");
            }
        }while (select>0);
    }

    /**
     * 限制只能输入整数
     * @return
     */
    public static int inputInt(){
        int input=0;
        Scanner scan=new Scanner(System.in);
        while (true){
            try {
               input=scan.nextInt();
               break;
            }catch (Exception e){
                System.out.println("请重新输入一个整数！");
                scan=new Scanner(System.in);
            }
        }
        return input;
    }
    /**
     * 计算用户购买水果金额
     * @param type 水果类别
     * @param discount 折扣
     * @param weight 重量（斤）
     * @return 返回总的花费金额
     */
    public static double fruit(String type,int weight,double discount){
        double totalMoney=0;
        if(weight==0){
            System.out.println("水果的重量需要大于0");
            return totalMoney;
        }
        switch (type){
            case "苹果":
                totalMoney=8*weight;
                break;
            case "草莓":
                totalMoney=13*weight;
                break;
            case "芒果":
                totalMoney=20*weight;
                break;
            default:
                System.out.println("您购买的水果暂时没有，谢谢惠顾！");
        }
        return totalMoney;
    }
}
