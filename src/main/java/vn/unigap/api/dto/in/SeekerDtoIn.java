package vn.unigap.api.dto.in;

import lombok.Data;

@Data
public class SeekerDtoIn {
    String name;

    String birthday;

    String address;

    Integer provinceId;
}
