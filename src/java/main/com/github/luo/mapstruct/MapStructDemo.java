package com.github.luo.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * MapStruct框架使用demo
 *
 * @author luoxiangnan
 * @date 2019-11-10
 */
public class MapStructDemo {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PersonDO {
        private Long id;
        private Name name;
        private Date date;
        private Integer age;
        private String innerImportInfo;

        @Data
        @AllArgsConstructor
        public static class Name {
            private String firstName;
            private String lastName;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PersonDTO {
        long id;
        private String firstName; // 对应PersonDO.name.firstName
        private String lastName;  // 对应PersonDO.name.lastName
        private String name;      // 对应PersonDO.name字段
        private Date date;
        private Integer outAge;
        private String dateFormat;
        private String dateFormat2;
        private String innerImportInfo;

        @Data
        @AllArgsConstructor
        public static class Address {
            private String address;
        }
    }

    @Mapper
    public static interface PersonConverter {
        PersonConverter INSTANCE = Mappers.getMapper(PersonConverter.class);

        /**
         * 基本映射
         */
        @Mappings({
                @Mapping(target = "name", expression = "java(personDO.getName().getFirstName() + \":\" + personDO.getName().getLastName())"),
                @Mapping(source = "name.firstName", target = "firstName"),
                @Mapping(source = "name.lastName", target = "lastName"),
                @Mapping(target = "dateFormat", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(personDO.getDate(), \"yyyy-MM-dd HH:mm:ss\"))"),
                @Mapping(source = "date", target = "dateFormat2", dateFormat = "yyyy-MM-dd HH:mm:ss"),
                @Mapping(source = "age", target = "outAge"),
                @Mapping(target = "innerImportInfo", ignore = true)
        })
        PersonDTO toPersonDTO(PersonDO personDO);

        /**
         * 基本映射，映射已有DTO
         * @param personDO
         * @param personDTO
         */
        @InheritConfiguration(name = "toPersonDTO")
        void toPersonDTOV2(PersonDO personDO, @MappingTarget PersonDTO personDTO);

        List<PersonDTO> toPersonDTOList(List<PersonDO> personDOList);
    }

    @Mapper
    public static interface Two2OneConverter {
        Two2OneConverter INSTANCE = Mappers.getMapper(Two2OneConverter.class);

        @Data
        static class A {
            String orderNo = "xxxx";
        }
        @Data
        static class B {
            Long skuId = 11111L;
        }
        @Data
        static class C {
            String orderNo;
            Long skuId;
        }

        @Mappings({
                @Mapping(source = "a.orderNo", target = "orderNo"),
                @Mapping(source = "b.skuId", target = "skuId")
        })
        C toPersonDTO(A a, B b);
    }

    public static void main(String[] args) {
        PersonDO personDO = new PersonDO(1L, new PersonDO.Name("luo", "xiangnan"),
                new Date(), 26, "内部机密信息，勿外传");

        System.out.println(personDO);
        System.out.println(PersonConverter.INSTANCE.toPersonDTO(personDO));

        PersonDTO personDTO = new PersonDTO();
        PersonConverter.INSTANCE.toPersonDTOV2(personDO, personDTO);
        System.out.println(personDTO);

        System.out.println(PersonConverter.INSTANCE.toPersonDTOList(Arrays.asList(personDO)));


        // 多个类转成单个类
        Two2OneConverter.C c = Two2OneConverter.INSTANCE.toPersonDTO(new Two2OneConverter.A(), new Two2OneConverter.B());
        System.out.println(c);
    }
}
