package com.iobound;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@Document(indexName = "post_shard_8")
public class Post {
    @Id
    private String id;
    private String content;
}
