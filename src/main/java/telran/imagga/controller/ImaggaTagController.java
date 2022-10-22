package telran.imagga.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import telran.imagga.dto.ResponseTagDto;

public class ImaggaTagController {
    static RestTemplate restTemplate = new RestTemplate();
    static final String TOKEN = "Basic YWNjXzg1MGU3MzY0ZjBiMTRjMjpiMTQ0ZDBkNTlmNjFmM2E2MjAzNmMzYWRiMjA2NDE4Yg==";
    static String img = "https://24smi.org/public/media/235x307/person/2017/12/22/4sqqykgn04bo-cheburashka.jpg";
    static String baseUrl = "https://api.imagga.com/v2/tags";

    public static void main(String[] args) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, TOKEN);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("image_url",img)
                .queryParam("language","ru")
                .queryParam("limit", 3);
        RequestEntity<String> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, builder.build().toUri() );

        ResponseEntity<ResponseTagDto> responseEntity = restTemplate.exchange(requestEntity, ResponseTagDto.class);
        responseEntity.getBody().getResult().getTags().forEach(System.out::println);

    }

}
