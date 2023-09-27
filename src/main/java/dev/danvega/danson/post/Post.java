package dev.danvega.danson.post;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

record Post(
        @Id
        Integer id,
        Integer userId,
        @NotEmpty
        String title,
        @NotEmpty
        String body,
        @Version Integer version
){

}
