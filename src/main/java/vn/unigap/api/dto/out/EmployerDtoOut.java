package vn.unigap.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.Employer;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployerDtoOut {
    Integer id;

    String email;

    String name;

    Integer province;

    String description;

    Date createAt;

    public static EmployerDtoOut from(Employer u) {
        return EmployerDtoOut.builder()
                .id(u.getId())
                .email(u.getEmail())
                .name(u.getName())
                .description(u.getDescription())
                .createAt(u.getCreatedDate())
                .build();
    }

}
