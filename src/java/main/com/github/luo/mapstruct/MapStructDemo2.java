package com.github.luo.mapstruct;

import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * mapstruct简单使用示例
 *
 * @author luoxiangnan
 * @date 2019-11-10
 */
public class MapStructDemo2 {

    @Data
    static class AaaDO {
        private String name;
        private Integer age;
    }

    @Data
    static class AaaDTO {
        private String name;
        private Integer age;
    }

    @Mapper
    public interface AaaConvert {
        AaaConvert INSTANCE = Mappers.getMapper(AaaConvert.class);

        AaaDTO toAaaDTO(AaaDO aaaDO);
    }

    public static void main(String[] args) {
        AaaDO aaaDO = new AaaDO();
        aaaDO.setName("luo");
        aaaDO.setAge(26);

        System.out.println(aaaDO);
        System.out.println(AaaConvert.INSTANCE.toAaaDTO(aaaDO));
    }
}
