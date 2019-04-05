package com.warems.warehouse.test;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        List<People> list = new ArrayList<People>();
        list.add(new People(1,"tom","12",10));
        list.add(new People(2,"tom","12",20));
        list.add(new People(3,"jerry","32",30));
        list.add(new People(4,"tom","12",40));
        list.add(new People(5,"jerry","32",50));
        list.add(new People(6,"tom","12",60));
        list.add(new People(7,"tom","12",70));
        list.add(new People(8,"小明","12",30));
        list.add(new People(9,"tom01","12",20));
        list.add(new People(10,"小明","12",10));

        List<People> newList = new ArrayList<People>();
        newList.add(list.get(0));
        for(int i=0;i<list.size();i++){
            for(int j=0;j<newList.size();j++){
                if(newList.get(j).getName().equals(list.get(i).getName())
                        &&newList.get(j).getAge().equals(list.get(i).getAge())){
                    break;
                }
                if(j == newList.size()-1){
                    newList.add(list.get(i));
                }
            }
        }

        List<People> beifen  = new ArrayList();
        for(People p:newList){
            beifen.add(p.clone());
        }

        for(int i=0;i<newList.size();i++){
            for(int j=0;j<list.size();j++){
                if(newList.get(i).getName().equals(list.get(j).getName())
                        &&newList.get(i).getAge().equals(list.get(j).getAge())){
                    newList.get(i).setNum(newList.get(i).getNum()+list.get(j).getNum());
                }
            }
        }
        for(int i=0;i<newList.size();i++){
            newList.get(i).setNum(newList.get(i).getNum()-beifen.get(i).getNum());
        }
        System.out.println("结果："+newList);



    }
}
class People implements Cloneable {
    private Integer id;
    private String name;
    private String age;
    private Integer num;

    public People(Integer id, String name, String age, Integer num) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.num = num;
    }
    public People() {

    }
    public People clone(){
        People p = null;
        try {
            p = (People) super.clone();
        }catch (Exception e){

        }
        return p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", num=" + num +
                '}';
    }
}