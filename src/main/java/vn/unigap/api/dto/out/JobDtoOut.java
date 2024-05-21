package vn.unigap.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.Jobs;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDtoOut {
    Long id;

    Long employerId;

    String title;

    Integer quantity;

    String description;

    String fields;

    String provinces;

    Long salary;

    Date createdAt;

    Date updatedAt;

    Date expiredAt;

    public static JobDtoOut from(Jobs job){
        return JobDtoOut.builder()
                .id(job.getId())
                .employerId(job.getEmployerId())
                .title(job.getTitle())
                .quantity(job.getQuantity())
                .fields(job.getFields())
                .provinces(job.getProvinces())
                .description(job.getDescription())
                .salary(job.getSalary())
                .createdAt(job.getCreatedDate())
                .updatedAt(job.getUpdatedDate())
                .expiredAt(job.getExpiredAt())
                .build();
    }
}
