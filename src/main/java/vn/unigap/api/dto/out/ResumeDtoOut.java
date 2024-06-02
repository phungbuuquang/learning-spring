package vn.unigap.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.JobField;
import vn.unigap.api.entity.Resume;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumeDtoOut {
    private Long id;

    private Long seekerId;

    private String seekerName;

    private String careerObj;

    private String title;

    private Integer salary;

    private List<JobFieldDtoOut> jobFields;

    private Date createdAt;

    private Date updatedAt;

    public static ResumeDtoOut from(Resume resume){
        return ResumeDtoOut.builder()
                .id(resume.getId())
                .seekerId(resume.getSeeker().getId())
                .seekerName(resume.getSeeker().getName())
                .careerObj(resume.getCareerObj())
                .title(resume.getTitle())
//                .jobFields(resume.getJobFields().stream().map(JobFieldDtoOut::from).toList())
                .salary(resume.getSalary() * 1000000)
                .createdAt(resume.getCreatedAt())
                .updatedAt(resume.getUpdatedAt()).build();
    }
}
