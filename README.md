# GeoHash JPA 扩展

## 如何使用

1. 添加依赖

```xml

<dependency>
    <groupId>com.chenlm</groupId>
    <artifactId>geohash-jpa-extension</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>

```

2. Entity 实现 Point 接口，并添加 `GeoEntityListener` 监听

```

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@EntityListeners(GeoEntityListener.class)
public class TestEntity implements Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private Double lon;
    private Double lat;
    private String geoCode;

}

```

此时 geoCode 将会自动设置成 8 为的 geo hash 编码

3. 记得给 geo_code 字段加上索引哦
