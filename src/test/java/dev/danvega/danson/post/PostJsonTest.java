package dev.danvega.danson.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class PostJsonTest {

    @Autowired
    private JacksonTester<Post> jacksonTester;

    @Test
    void shouldSerializePost() throws Exception {
        Post post = new Post(1,1,"Hello, World!", "This is my first post.",null);
        String expected = STR."""
                {
                    "id":\{post.id()},
                    "userId":\{post.userId()},
                    "title":"\{post.title()}",
                    "body":"\{post.body()}",
                    "version": null
                }
                """;
        assertThat(jacksonTester.write(post)).isEqualToJson(expected);
    }

    @Test
    void shouldDeserializePost() throws Exception {
        Post post = new Post(1,1,"Hello, World!", "This is my first post.",null);
        String content = STR."""
                {
                    "id":\{post.id()},
                    "userId":\{post.userId()},
                    "title":"\{post.title()}",
                    "body":"\{post.body()}",
                    "version": null
                }
                """;

        assertThat(jacksonTester.parse(content)).isEqualTo(post);
        assertThat(jacksonTester.parseObject(content).id()).isEqualTo(1);
        assertThat(jacksonTester.parseObject(content).userId()).isEqualTo(1);
        assertThat(jacksonTester.parseObject(content).title()).isEqualTo("Hello, World!");
        assertThat(jacksonTester.parseObject(content).body()).isEqualTo("This is my first post.");
    }

}
