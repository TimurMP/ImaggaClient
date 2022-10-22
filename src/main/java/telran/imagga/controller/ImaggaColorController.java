package telran.imagga.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import telran.imagga.dto.ResponseColorDto;
import telran.imagga.dto.ResponseTagDto;
import telran.imagga.dto.ResultColorDto;

public class ImaggaColorController {
    static RestTemplate restTemplate = new RestTemplate();
    static final String TOKEN = "Basic YWNjXzg1MGU3MzY0ZjBiMTRjMjpiMTQ0ZDBkNTlmNjFmM2E2MjAzNmMzYWRiMjA2NDE4Yg==";
    static String img = "https://24smi.org/public/media/235x307/person/2017/12/22/4sqqykgn04bo-cheburashka.jpg";
    static String baseUrl = "https://api.imagga.com/v2/colors";

    public static void main(String[] args) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, TOKEN);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("image_url",img);

        RequestEntity<String> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, builder.build().toUri() );
        ResponseEntity<ResponseColorDto> responseEntity = restTemplate.exchange(requestEntity, ResponseColorDto.class);

        System.out.println("Color name\t\t\tParent Color Name\t\t\tCoverage Percent");
        System.out.println("\nBackground Colors:");
        responseEntity.getBody().getResult().getColors().getBackground_colors().forEach(System.out::println);
        System.out.println("\nForeground Colors:");
        responseEntity.getBody().getResult().getColors().getForeground_colors().forEach(System.out::println);
        System.out.println("\nImage Colors:");
        responseEntity.getBody().getResult().getColors().getImage_colors().forEach(System.out::println);

    }

}
