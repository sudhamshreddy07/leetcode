import java.util.*;
class Solution {
    public static void main(String args[]){

        return;
    }
    class Data{
        int position,value;
        Data(int position,int value){
            this.position=position;
            this.value= value;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {//https://leetcode.com/problems/daily-temperatures/description/?envType=study-plan-v2&envId=leetcode-75
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Data> st = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<temperatures.length;i++){
            Data d = new Data(i,temperatures[i]);
            while(st.size()>0&&st.peek().value<d.value){
                Data x = st.pop();
                map.put(x.position,i-x.position);
            }
            st.add(d);
        }
        while(!st.isEmpty()){
            map.put(st.pop().position,0);
        }
        int a[]=new int [temperatures.length];
        for(int i=0;i<a.length;i++){
            a[i]=map.get(i);
        }
        return a;
    }
}