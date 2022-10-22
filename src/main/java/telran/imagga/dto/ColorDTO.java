package telran.imagga.dto;


import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter

public class ColorDTO {
    String  closest_palette_color;
    String closest_palette_color_parent;
    Double percent;

    @Override
    public String toString() {
        return
                closest_palette_color + "\t\t\t" +
                closest_palette_color_parent + "\t\t\t" +
                percent;
    }
}


