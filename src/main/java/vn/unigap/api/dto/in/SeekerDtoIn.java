package vn.unigap.api.dto.in;

import lombok.Data;
import vn.unigap.api.entity.Seeker;
import vn.unigap.common.Common;

@Data
public class SeekerDtoIn {
    String name;

    String birthday;

    String address;

    Integer provinceId;

    public Seeker copy(Seeker seeker){
        if(name != null){
            seeker.setName(name);
        }
        if(birthday != null){
            seeker.setBirthday(birthday);
        }
        if(address != null){
            seeker.setAddress(address);
        }
        if(provinceId != null){
//            seeker.setProvinceId(provinceId);
        }
        seeker.setUpdatedAt(Common.currentTime());
        return  seeker;
    }
}
