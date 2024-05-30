package vn.unigap.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.Seeker;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeekerDtoOut implements Serializable {
    Long id;

    String name;

    String birthday;

    String address;

    Integer provinceId;

    String provinceName;

    Date createdAt;

    Date updatedAt;

    public static SeekerDtoOut from(Seeker seeker){
        return SeekerDtoOut.builder()
                .id(seeker.getId())
                .name(seeker.getName())
                .birthday(seeker.getBirthday())
                .address(seeker.getAddress())
                .provinceId(seeker.getProvince().getId())
                .provinceName(seeker.getProvince().getName())
                .createdAt(seeker.getCreatedAt())
                .updatedAt(seeker.getUpdatedAt())
                .build();
    }
}
