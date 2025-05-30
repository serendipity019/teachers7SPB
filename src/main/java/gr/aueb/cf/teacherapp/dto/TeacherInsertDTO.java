package gr.aueb.cf.teacherapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TeacherInsertDTO (
        @NotNull(message = "The name can't be null")
        @Size(min=3, message= "The name must contain at least 3 characters ")
        String firstname,

        @NotNull(message = "The surname can't be null")
        @Size(min=3, message= "The surname must contain at least 3 characters ")
        String lastname,

        @Pattern(regexp = "\\d{9,}", message = "Vat can't be smaller than 9 digit")
        String vat,

        @NotNull(message = "The region can't be null")
        Long regionId
) {

}
