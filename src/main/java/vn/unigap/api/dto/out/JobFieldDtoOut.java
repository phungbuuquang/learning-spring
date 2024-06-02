package vn.unigap.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.JobField;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobFieldDtoOut {
    private Integer id;

    private String name;

    private String slug;

    public static JobFieldDtoOut from(JobField jobField){
        return JobFieldDtoOut.builder()
                .id(jobField.getId())
                .name(jobField.getName())
                .slug(jobField.getSlug())
                .build();
    }
}
