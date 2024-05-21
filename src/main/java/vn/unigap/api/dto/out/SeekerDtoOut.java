package vn.unigap.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.Seeker;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeekerDtoOut {
    Long id;

    String name;

    String birthday;

    String address;

    Integer provinceId;

    String provinceName;

    public static SeekerDtoOut from(Seeker seeker){
        return SeekerDtoOut.builder()
                .id(seeker.getId())
                .name(seeker.getName())
                .birthday(seeker.getBirthday())
                .address(seeker.getAddress())
                .provinceId(seeker.getProvince())
                .build();
    }
}
