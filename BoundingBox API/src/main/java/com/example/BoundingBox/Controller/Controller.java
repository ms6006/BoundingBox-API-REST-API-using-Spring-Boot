package com.example.BoundingBox.Controller;

import com.example.BoundingBox.Config.Config;
import com.example.BoundingBox.Object.BoundingBox;
import com.example.BoundingBox.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/BoundingBox")
public class Controller {
    private Service service;
    private Config config;

    @Autowired
    public Controller(Service service, Config config){
        this.service = service;
        this.config = config;
    }

    @PostMapping("/create")
    public ResponseEntity<BoundingBox> create(@RequestBody BoundingBox box){
        if( config.getMinHeight() <= box.Height() &&
                config.getMinWidth() <= box.Width() &&
                config.getImageHeight() >= box.Point2_Y() &&
                0 <= box.Point1_Y() &&
                config.getImageWidth() >= box.Point2_X() &&
                0 <= box.Point1_X()) {

            service.create(box.getName(), box.getPoint1(), box.getPoint2());
            return new ResponseEntity<>(HttpStatus.OK);

        }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/update")
    public ResponseEntity<BoundingBox> updateBoundingBox(@RequestBody BoundingBox box){
        service.update(box.getId(), box.getName(), box.getPoint1(), box.getPoint2());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<BoundingBox> remove(@RequestBody BoundingBox box){
        service.remove(box.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/FindAll")
    public ResponseEntity<Set<BoundingBox>> getAll(){
        Set<BoundingBox> found = service.findAll();

        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/FindById")
    public ResponseEntity<BoundingBox> getById(@RequestBody BoundingBox box){
        BoundingBox found = service.findById(box.getId());

        if(found != null) return new ResponseEntity<>(found, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
