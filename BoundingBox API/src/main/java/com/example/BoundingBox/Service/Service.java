package com.example.BoundingBox.Service;

import com.example.BoundingBox.Object.BoundingBox;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Service {
    private Set<BoundingBox> Box;

    public Service(){
        Box = new HashSet<>();
    }

    public void create(String name, String[] point1, String[] point2){
        BoundingBox newBox = new BoundingBox(String.valueOf(Box.size()), name, point1, point2);
        Box.add(newBox);
    }

    public void remove(String id){
        BoundingBox Remove = findById(id);
        Box.remove(Remove);
    }

    public void update(String id, String name, String[] point1, String[] point2){
        BoundingBox Update = findById(id);
        Update.setName(name);
        Update.setPoint1(point1);
        Update.setPoint2(point2);
    }

    public BoundingBox findById(String id){
        return Box.stream().filter(i -> id.equals(i.getId())).findFirst().orElse(null);
    }

    public Set<BoundingBox> findAll() {
        return Box;
    }
}
