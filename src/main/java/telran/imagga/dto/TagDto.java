package telran.imagga.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class TagDto {
    double confidence;
    Map<String, String> tag;


}
