package vn.unigap.api.dto.in;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDtoIn {
    @NotNull
    String email;
    @NotNull
    String name;
    @NotNull
    Integer province;

    String description;

}
