package com.example.BoundingBox.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Value("${workspace.boundingBox.minWidth}")
    private int minWidth;

    @Value("${workspace.boundingBox.minHeight}")
    private int minHeight;

    @Value("${workspace.image.width}")
    private int imageWidth;

    @Value("${workspace.image.height}")
    private int imageHeight;

    public int getMinWidth(){
        return minWidth;
    }

    public int getMinHeight(){
        return minHeight;
    }

    public int getImageWidth(){
        return imageWidth;
    }

    public int getImageHeight(){
        return imageHeight;
    }
}
