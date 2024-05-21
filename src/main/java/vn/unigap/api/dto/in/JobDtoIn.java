package vn.unigap.api.dto.in;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.Jobs;
import vn.unigap.common.Common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDtoIn {

    String title;


    Long employId;


    Integer quantity;


    String description;


    List<Integer> fieldIds;


    List<Integer> provinceIds;


    Long salary;


    String expiredAt;

    public Jobs copy(Jobs job){
        if(title != null){
            job.setTitle(title);
        }

        if(employId != null){
            job.setEmployerId(employId);
        }

        if(quantity != null){
            job.setQuantity(quantity);
        }

        if(description != null){
            job.setDescription(description);
        }

        if(fieldIds != null){
            String fields = fieldIds.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("-", "-", "-"));
            job.setFields(fields);
        }

        if(provinceIds != null){
            String provinces = provinceIds.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("-", "-", "-"));
            job.setProvinces(provinces);
        }

        if(salary != null){
            job.setSalary(salary);
        }

        if(expiredAt != null){
            Date date = Common.stringToDate(expiredAt);
            job.setExpiredAt(date);
        }

        job.setUpdatedDate(Common.currentTime());
        return job;
    }
}
