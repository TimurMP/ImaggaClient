package telran.imagga.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter


public class ColorsDto {

    List<ColorDTO> background_colors;
    List<ColorDTO> foreground_colors;
    List<ColorDTO> image_colors;


}
