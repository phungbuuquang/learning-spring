package vn.unigap.api.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDtoIn {
    private Long seekerId;

    private String careerObj;

    private String title;

    private Integer salary;

    private List<Integer> fieldIds ;

    private List<Integer> provinceIds ;
}
