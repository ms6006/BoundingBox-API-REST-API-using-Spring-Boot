package com.example.BoundingBox.Object;

public class BoundingBox {
    private String id;
    private String name;
    private String[] point1;
    private String[] point2;

    public BoundingBox(String id, String name, String[] point1, String[] point2){
        this.id = id;
        this.name = name;
        this.point1 = point1;
        this.point2 = point2;
    }

    public String getId(){
        return id;
    }

    /*public void setId(String id){
        this.id = id;
    }*/

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String[] getPoint1() {
        return point1;
    }

    public void setPoint1(String[] point1){
        this.point1 = point1;
    }

    public String[] getPoint2() {
        return point2;
    }

    public void setPoint2(String[] point2){
        this.point2 = point2;
    }

    public int Point2_Y(){
        return Integer.parseInt(point2[1]);
    }

    public int Point1_Y(){
        return Integer.parseInt(point1[1]);
    }

    public int Point2_X(){
        return Integer.parseInt(point2[0]);
    }

    public int Point1_X(){
        return Integer.parseInt(point1[0]);
    }

    public int Height(){
        return (Integer.parseInt(point2[1]) - Integer.parseInt(point1[1]));
    }

    public int Width(){
        return (Integer.parseInt(point2[0]) - Integer.parseInt(point1[0]));
    }
}
